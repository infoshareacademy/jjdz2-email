package com.jbd.DBA;

import com.jbd.Authorization.SessionData;
import com.jbd.ContentmentVerification;
import com.jbd.Email;

import javax.ejb.EJB;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.registry.infomodel.User;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


@WebServlet(urlPatterns = "/App/update")
public class UpdateUsers extends HttpServlet {

    @Inject
    SaveUser saveUser;

    @Inject
    SessionData sessionData;


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        String[] isPreviliged = req.getParameterValues("isPreviliged");
        System.out.println("Previliged " + isPreviliged.toString());
        for (String a:isPreviliged) {
            System.out.println(a);
        }
        for (int i =0; i < isPreviliged.length; i++) {
            SessionData user = saveUser.getUser(Long.parseLong(isPreviliged[i]));
            String previlige = user.getPrivilege();
            if (previlige.equals("Admin")) {
                user.setPrivilege("local");
            }
            else {
                user.setPrivilege("Admin");
            }
            saveUser.updateUser(user);
        }

        RequestDispatcher dispatcher = req.getRequestDispatcher("/App/AdminConsole.jsp");
        dispatcher.forward(req, resp);




    }
}
