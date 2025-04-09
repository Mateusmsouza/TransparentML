package org.acme.presentation;

import lombok.RequiredArgsConstructor;

import org.acme.infrastructure.persistence.InMemoryMetricRepository;
import org.acme.application.usecase.RegisterMetricUseCase;
import org.acme.domain.model.Metric;

import io.quarkus.logging.Log;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;


@Path("/experiments")
public class ExperimentController {
    
    //private final RegisterMetricUseCase useCase;

    public ExperimentController() {
        int a = 1+1;
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Response register(Metric metric) {
        //Log.info("register metric endpoints called");
        //Log.info(metric);
        //Metric createdMetric = useCase.execute(metric);
        return Response.ok(createdMetric, MediaType.APPLICATION_JSON).status(Response.Status.CREATED).build();
    }
}
