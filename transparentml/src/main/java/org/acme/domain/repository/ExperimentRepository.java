package org.acme.domain.repository;

import domain.model.Experiment;
import java.util.Optional;
import java.util.UUID;

public interface ExperimentRepository {
    Experiment save(Experiment experiment);
    Optional<Experiment> findById(UUID id);
}

