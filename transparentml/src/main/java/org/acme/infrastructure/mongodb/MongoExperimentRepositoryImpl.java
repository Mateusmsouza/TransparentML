package org.acme.infrastructure.mongodb;

import java.util.Optional;
import java.util.UUID;

import org.acme.domain.model.Experiment;
import org.acme.domain.repository.ExperimentRepository;
import org.bson.Document;
import org.bson.types.ObjectId;
import static com.mongodb.client.model.Filters.eq;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import lombok.NoArgsConstructor;

@ApplicationScoped
@NoArgsConstructor
public class MongoExperimentRepositoryImpl implements ExperimentRepository {

    @Inject
    private MongoClient mongoClient;

    @Override
    public String save(Experiment experiment) {
        Document document = new Document()
                .append("name", experiment.getName())
                .append("description", experiment.getDescription())
                .append("createdAt", experiment.getCreatedAt())
                .append("tags", experiment.getTags());
        return this.getCollection().insertOne(document).getInsertedId().asObjectId().getValue().toString();
    }

    @Override
    public Optional<Experiment> findById(String id) {
        try {
            ObjectId objectId = new ObjectId(id);
            Document doc = this.getCollection().find(eq("_id", objectId)).first();

            if (doc == null) {
                return Optional.empty();
            }

            Experiment experiment = new Experiment();
            experiment.setId(objectId.toHexString());
            experiment.setName(doc.getString("name"));
            experiment.setDescription(doc.getString("description"));
            experiment.setCreatedAt(doc.getDate("createdAt").toInstant());
            experiment.setTags(doc.getList("tags", String.class));
            return Optional.of(experiment);
        } catch (IllegalArgumentException e) {
            return Optional.empty();
        }
    }

    private MongoCollection getCollection(){
        return mongoClient.getDatabase("transparentml").getCollection("experiments");
    }
}
