package org.acme.application.usecase;

import org.acme.domain.model.Experiment;
import org.acme.domain.repository.ExperimentRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import java.time.Instant;

@ApplicationScoped
public class CreateExperimentUseCase {

    @Inject
    private ExperimentRepository repository;

    public String execute(Experiment experiment) {
   
        experiment.setCreatedAt(Instant.now());
        return repository.save(experiment);
    }
}
