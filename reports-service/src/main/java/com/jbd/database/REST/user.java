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
import java.util.List;

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
    public Response createUser(sessionUser usersList){
        //usersList.stream().forEach(System.out::println);
//        System.out.println(usersList.get(0).getUsername());
//        for(int i =0; i< usersList.size();i++){
//            manageDB.saveUser(usersList.get(i));
//        }
        manageDB.saveUser(usersList);

        return Response
                .created(uriInfo
                .getAbsolutePathBuilder()
                .build())
                .build();
    }
}
