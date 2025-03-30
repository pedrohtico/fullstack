package br.com.pedro.user.resource;

import org.eclipse.microprofile.openapi.annotations.media.Content;
import org.eclipse.microprofile.openapi.annotations.media.Schema;
import org.eclipse.microprofile.openapi.annotations.parameters.RequestBody;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;
import org.jboss.resteasy.reactive.RestQuery;

import br.com.pedro.user.model.CreateUserRequest;
import br.com.pedro.user.service.UserService;
import br.com.pedro.util.parameter.Paths;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@ApplicationScoped
@Consumes(MediaType.APPLICATION_JSON)
@Path(Paths.user)
public class UserResource {

    private UserService service;

    @Inject
    public UserResource(UserService UserService) {
        this.service = UserService;
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @APIResponse(responseCode = "201", description = "User created")
    public Response createUser(
            @RequestBody(description = "Recurso para criar um usuário", content =
                @Content(schema = @Schema(implementation = CreateUserRequest.class))) CreateUserRequest request) {

        service.create(request);

        return Response.ok().status(Response.Status.CREATED).build();
    }

    @GET
    @Path("/{id}")
    public Response getUserById(@RestQuery Long id) {

        var user = service.getUserById(id);

        return Response.ok().entity(user).build();
    }

}
