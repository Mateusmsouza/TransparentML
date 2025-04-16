package org.acme.presentation;
import java.util.Map;

import org.acme.application.usecase.CreateExperimentUseCase;

import org.acme.domain.model.Experiment;
import org.eclipse.microprofile.jwt.JsonWebToken;

import io.quarkus.logging.Log;
import io.quarkus.oidc.IdToken;
import io.quarkus.security.Authenticated;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/experiments")
public class ExperimentController {
    
    @Inject
    private CreateExperimentUseCase useCase;

    @Inject
    @IdToken
    JsonWebToken idToken;


    @POST
    @Authenticated
    @Produces(MediaType.APPLICATION_JSON)
    public Response create(Experiment experiment) {
        Log.info("create experiment endpoints called");
        String experiment_id = this.useCase.execute(experiment);
        return Response.ok(Map.of("id", experiment_id), MediaType.APPLICATION_JSON).status(Response.Status.CREATED).build();
    }

    @GET
    @Authenticated
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response get_by_id(@PathParam ("id") String id) {
        Log.info("get experiment by id endpoint called");
        Log.info(idToken.getTokenID());
        Experiment experiment = this.useCase.findById(id);
        //String experiment_id = this.useCase.execute(experiment);
        // Map.of("id", experiment_id)
        return Response.ok(experiment, MediaType.APPLICATION_JSON).status(Response.Status.OK).build();
    }
}
