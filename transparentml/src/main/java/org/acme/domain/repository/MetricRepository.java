package org.acme.domain.repository;

import org.acme.domain.model.Metric;
import java.util.List;

public interface MetricRepository {
    Metric save(Metric metric);
    List<Metric> findByExperimentId(String experimentId);
}

