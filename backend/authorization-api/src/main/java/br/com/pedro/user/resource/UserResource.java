package br.com.pedro.user.resource;

// import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;

import br.com.pedro.user.model.CreateUserRequest;
import br.com.pedro.user.service.UserService;
import br.com.pedro.util.parameter.Paths;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.Response;

@ApplicationScoped
@Path(Paths.user)
public class UserResource {

    private UserService service;

    @Inject
    public UserResource(UserService UserService) {
        this.service = UserService;
    }

    @POST
    // @APIResponse(
    //     responseCode = "201",
    //     description = "User created"
    // )
    public Response createUser(CreateUserRequest request) {

        service.create(request);

        return Response.ok().status(Response.Status.CREATED).build();
    }

}


