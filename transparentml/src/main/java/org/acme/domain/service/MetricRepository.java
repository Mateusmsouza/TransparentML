package org.acme.domain.service;

import org.acme.domain.model.Metric;
import java.util.List;

public interface MetricRepository {
    void save(Metric metric);
    List<Metric> findByExperimentId(String experimentId);
}

