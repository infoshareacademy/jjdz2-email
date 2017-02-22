package com.jbd.REST;

import com.jbd.authorization.SessionData;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.io.IOException;



@WebServlet(urlPatterns = "/sendUserServlet")

public class sendUserServlet extends HttpServlet {
    @Inject
    SessionData sessionData;
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        SessionData test = new SessionData();
        test.setUsername("Karol");
        test.setUsermail("Kowalski@wp.pl");
        test.setPrivilege(1);

        Response user = ClientBuilder.newClient()
                .target("http://localhost:8081/reporting/reportApi/users")
                .request(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .post(Entity.json(test));
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("costam");
    }
}
