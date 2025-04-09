package org.acme.infrastructure.mongodb;

import java.util.Optional;
import java.util.UUID;

import org.acme.domain.model.Experiment;
import org.acme.domain.repository.ExperimentRepository;

public class MongoExperimentRepositoryImpl implements ExperimentRepository {


    @Override
    public Experiment save(Experiment experiment) {
        // Save experiment to MongoDB
        return experiment;
    }

    @Override
    public Optional<Experiment> findById(UUID id) {
        // Retrieve experiment from MongoDB by ID
        return Optional.empty();
    }
    
}
