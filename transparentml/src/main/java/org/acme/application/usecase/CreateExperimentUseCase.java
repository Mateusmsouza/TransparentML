package org.acme.application.usecase;

import domain.model.Experiment;
import domain.repository.ExperimentRepository;

import java.util.UUID;

public class CreateExperimentUseCase {

    private final ExperimentRepository repository;

    public CreateExperimentUseCase(ExperimentRepository repository) {
        this.repository = repository;
    }

    public Experiment execute(String name, String description) {
        Experiment experiment = new Experiment(UUID.randomUUID(), name, description);
        return repository.save(experiment);
    }
}

