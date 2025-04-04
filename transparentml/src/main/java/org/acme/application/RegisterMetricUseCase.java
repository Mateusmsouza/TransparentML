package org.acme.application;

import lombok.RequiredArgsConstructor;
import org.acme.domain.model.Metric;
import org.acme.domain.service.MetricRepository;

import javax.enterprise.context.ApplicationScoped;
import java.util.UUID;

@ApplicationScoped
@RequiredArgsConstructor
public class RegisterMetricUseCase {

    private final MetricRepository metricRepository;

    public void execute(Metric metric) {
        metric.setId(UUID.randomUUID());
        metricRepository.save(metric);
    }
}

