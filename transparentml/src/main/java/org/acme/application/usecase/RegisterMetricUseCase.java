package org.acme.application.usecase;

import java.time.Instant;

import org.acme.domain.model.Metric;
import org.acme.domain.repository.MetricRepository;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;


@ApplicationScoped
public class RegisterMetricUseCase {

    @Inject
    private MetricRepository metricRepository;

    public String execute(Metric metric) {
        metric.setCreatedAt(Instant.now());
        return metricRepository.save(metric);
    }
}
