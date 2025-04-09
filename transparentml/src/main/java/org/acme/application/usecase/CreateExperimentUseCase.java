package org.acme.application.usecase;

import org.acme.domain.model.Experiment;
import org.acme.domain.repository.ExperimentRepository;

import java.time.Instant;
import java.util.List;
import java.util.UUID;

public class CreateExperimentUseCase {

    private final ExperimentRepository repository;

    public CreateExperimentUseCase(ExperimentRepository repository) {
        this.repository = repository;
    }

    public Experiment execute(String name, String description, List<String> tags) {
        Experiment experiment = new Experiment();
        experiment.setName(name);
        experiment.setDescription(description);
        experiment.setTags(tags);
        experiment.setCreatedAt(Instant.now());
        experiment.setId(UUID.randomUUID());
        return repository.save(experiment);
    }
}
