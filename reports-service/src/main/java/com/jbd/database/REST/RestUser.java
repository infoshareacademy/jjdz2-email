package com.jbd.database.REST;

import com.jbd.database.ActivityReport;
import com.jbd.database.ManageDB;
import com.jbd.database.User;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import java.util.List;

@Stateless
@Path("users")
public class RestUser {

    @Inject
    ManageDB manageDB;

    @Inject
    ActivityReport activityReport;

    @Context
    UriInfo uriInfo;

    @Path("name")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<User> users() {
        System.out.println("Dzialam?");
        activityReport.generateReport();
        return null;
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response createUser(User usersList){
        manageDB.saveUser(usersList);

        return Response
                .created(uriInfo
                .getAbsolutePathBuilder()
                .build())
                .build();
    }
}
