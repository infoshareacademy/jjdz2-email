package com.jbd.REST;

import com.jbd.SessionData;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

public class Users {
    @Context
    UriInfo uriInfo;

    @POST
    @Consumes({MediaType.APPLICATION_JSON})
    public Response createNewUser(SessionData sessionData){

//        Integer id = service.process(sessionData);


        return Response.created(
                uriInfo.getBaseUriBuilder()
                        .segment(sessionData.getUsername().toString())
                        .segment(sessionData.getPrivilege().toString()).build())
                .build();


//                                .getAbsolutePathBuilder()
//                                .path(sessionData.getUsername())
//                                .build())
//                .build();

    }

    SessionData user = ClientBuilder.newClient()
            .target("http://localhost:8080/jbdee/api/users")
            .request()
                .accept(MediaType.APPLICATION_JSON_TYPE)
                .get(SessionData.class);

}
