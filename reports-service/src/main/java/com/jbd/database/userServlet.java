package com.jbd.database;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.io.IOException;
import java.util.List;

@WebServlet("/create")
public class userServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Response user = ClientBuilder.newClient()
                .target("http://localhost:8080/jbdee/api/users")
                .request()
                .accept(MediaType.APPLICATION_JSON)
                .get();

        List<sessionUser> userList = user.readEntity(List.class);
        System.out.println(userList.get(0));

        System.out.println("Pobralem!");
    }
}
