package org.acme.domain.repository;

import org.acme.domain.model.Experiment;
import java.util.Optional;

public interface ExperimentRepository {
    String save(Experiment experiment);
    Optional<Experiment> findById(String id);
}