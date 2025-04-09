package org.acme.infrastructure.persistence;

import org.acme.domain.model.Metric;
import org.acme.domain.repository.MetricRepository;

import java.time.Instant;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

public class InMemoryMetricRepository implements MetricRepository {

    private final Map<UUID, Metric> store = new ConcurrentHashMap<>();

    @Override
    public Metric save(Metric metric) {
        metric.setId(new UUID(999, 0));
        metric.setTimestamp(Instant.now());
        store.put(metric.getId(), metric);
        return metric;
    }

    @Override
    public List<Metric> findByExperimentId(String experimentId) {
        return store.values().stream()
                .filter(m -> m.getExperimentId().equals(experimentId))
                .collect(Collectors.toList());
    }
}
