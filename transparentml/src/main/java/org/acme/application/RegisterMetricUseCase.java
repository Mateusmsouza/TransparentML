package org.acme.application;

import lombok.RequiredArgsConstructor;
import org.acme.domain.model.Metric;
import org.acme.domain.service.MetricRepository;

//import javax.enterprise.context.ApplicationScoped;

//@ApplicationScoped
//@RequiredArgsConstructor
public class RegisterMetricUseCase {

    private final MetricRepository metricRepository;

    public RegisterMetricUseCase(MetricRepository repository) {
        this.metricRepository = repository;
    }

    public void execute(Metric metric) {
        metricRepository.save(metric);
    }
}
