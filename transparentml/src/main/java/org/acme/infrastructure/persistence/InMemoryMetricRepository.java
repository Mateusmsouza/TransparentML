package org.acme.infrastructure.persistence;

import org.acme.domain.model.Metric;
import org.acme.domain.repository.MetricRepository;

import java.time.Instant;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class InMemoryMetricRepository implements MetricRepository {

    private final Map<String, Metric> store = new ConcurrentHashMap<>();

    @Override
    public String save(Metric metric) {
        metric.setId(UUID.randomUUID().toString());
        metric.setCreatedAt(Instant.now());
        store.put(metric.getId(), metric);
        return metric.getId();
    }

}
