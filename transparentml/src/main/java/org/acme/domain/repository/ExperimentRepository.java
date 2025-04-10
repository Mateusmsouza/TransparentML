package org.acme.domain.repository;

import org.acme.domain.model.Experiment;
import java.util.Optional;
import java.util.UUID;

public interface ExperimentRepository {
    String save(Experiment experiment);
    Optional<Experiment> findById(UUID id);
}