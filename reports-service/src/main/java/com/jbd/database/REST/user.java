package com.jbd.database.REST;

import com.jbd.database.sessionUser;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

@Stateless
@Path("users")
public class user  {

    @Context
    UriInfo uriInfo;

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response createUser(sessionUser user){
        System.out.println(user.getUsermail());

        return Response
                .created(uriInfo
                .getAbsolutePathBuilder()
                .build())
                .build();
    }
}
