package org.acme.presentation;

import java.util.Map;

import org.acme.application.usecase.RegisterMetricUseCase;
import org.acme.domain.model.Metric;

import io.quarkus.logging.Log;
import jakarta.inject.Inject;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/metrics")
public class MetricController {

    @Inject
    private RegisterMetricUseCase useCase;

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Response register(Metric metric) {
        Log.info("register metric endpoints called");
        Log.info(metric);
        String metridId = useCase.execute(metric);
        return Response.ok(Map.of("id", metridId), MediaType.APPLICATION_JSON).status(Response.Status.CREATED).build();
    }
}
