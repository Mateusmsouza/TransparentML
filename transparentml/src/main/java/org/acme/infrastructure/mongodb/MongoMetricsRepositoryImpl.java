package org.acme.infrastructure.mongodb;

import java.util.List;

import org.acme.domain.model.Metric;
import org.acme.domain.repository.MetricRepository;
import org.bson.Document;
import org.bson.types.ObjectId;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import lombok.NoArgsConstructor;

@ApplicationScoped
@NoArgsConstructor
public class MongoMetricsRepositoryImpl implements MetricRepository {

    @Inject
    private MongoClient mongoClient;

    // MongoDB client and collection setup
    // private MongoClient mongoClient;
    // private MongoCollection<Metric> collection;

    @Override
    public String save(Metric metric) {
        Document document = new Document()
                .append("experimentId", new ObjectId(metric.getExperimentId()))
                .append("name", metric.getName())
                .append("value", metric.getValue())
                .append("timestamp", metric.getCreatedAt())
                .append("step", metric.getStep());
        return this.getCollection().insertOne(document).getInsertedId().asObjectId().getValue().toString();
    }
    
    private MongoCollection getCollection(){
        return mongoClient.getDatabase("transparentml").getCollection("metrics");
    }
}
