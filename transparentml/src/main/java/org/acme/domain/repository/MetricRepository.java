package org.acme.domain.repository;

import org.acme.domain.model.Metric;

public interface MetricRepository {
    String save(Metric metric);
}

