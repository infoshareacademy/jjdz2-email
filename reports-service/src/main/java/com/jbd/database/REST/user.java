package com.jbd.database.REST;

import com.jbd.database.ManageDB;
import com.jbd.database.sessionUser;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

@Stateless
@Path("users")
public class user  {

    @Inject
    ManageDB manageDB;

    @Context
    UriInfo uriInfo;

    @Path("name")
    @GET
    @Produces
    public String name() {
        return "Dzial!";
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response createUser(sessionUser user){
        System.out.println(user.getUsermail());
        manageDB.saveUser(user);

        return Response
                .created(uriInfo
                .getAbsolutePathBuilder()
                .build())
                .build();
    }
}
