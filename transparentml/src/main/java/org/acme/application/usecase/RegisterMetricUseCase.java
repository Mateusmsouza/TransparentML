package org.acme.application.usecase;

import lombok.RequiredArgsConstructor;
import org.acme.domain.model.Metric;
import org.acme.domain.repository.MetricRepository;

//import javax.enterprise.context.ApplicationScoped;

//@ApplicationScoped
//@RequiredArgsConstructor
public class RegisterMetricUseCase {

    private final MetricRepository metricRepository;

    public RegisterMetricUseCase(MetricRepository repository) {
        this.metricRepository = repository;
    }

    public Metric execute(Metric metric) {
        return metricRepository.save(metric);
    }
}
