package org.acme.adapters.in.rest;

import lombok.RequiredArgsConstructor;
import org.acme.application.RegisterMetricUseCase;
import org.acme.domain.model.Metric;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("/metrics")
public class MetricResource {

    private final RegisterMetricUseCase useCase;

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public String register(Metric metric) {
	
	if (metric.getTimestamp() == null) {
            metric.setTimestamp(Instant.now());
        }
        useCase.execute(metric);
        return Response.status(Response.Status.CREATED).build();
    }
}
