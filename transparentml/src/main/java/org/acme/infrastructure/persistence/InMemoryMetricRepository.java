package org.acme.infrastructure.persistence;

import org.acme.domain.model.Metric;
import org.acme.domain.service.MetricRepository;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

public class InMemoryMetricRepository implements MetricRepository {

    private final Map<UUID, Metric> store = new ConcurrentHashMap<>();

    @Override
    public void save(Metric metric) {
        store.put(metric.getId(), metric);
    }

    @Override
    public List<Metric> findByExperimentId(String experimentId) {
        return store.values().stream()
                .filter(m -> m.getExperimentId().equals(experimentId))
                .collect(Collectors.toList());
    }
}
