package org.acme.adapters.in.rest;

import lombok.RequiredArgsConstructor;
import org.acme.application.RegisterMetricUseCase;
import org.acme.infrastructure.persistence.InMemoryMetricRepository;
import org.acme.domain.model.Metric;

import io.quarkus.logging.Log;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/metrics")
public class MetricResource {

    private final RegisterMetricUseCase useCase;

    public MetricResource() {
        this.useCase = new RegisterMetricUseCase(new InMemoryMetricRepository());
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Response register(Metric metric) {
        // useCase.execute(metric);
        Log.info("register metric endpoints called");
        return Response.status(Response.Status.CREATED).build();
    }
}
