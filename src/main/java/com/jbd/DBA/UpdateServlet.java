package com.jbd.DBA;

import com.jbd.Authorization.SessionData;

import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet(urlPatterns = "/App/update")
public class UpdateServlet extends HttpServlet {

    @Inject
    ManageUser manageUser;

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
            SessionData user = manageUser.getUser(Long.parseLong(isPreviliged[i]));
            String previlige = user.getPrivilege();
            if (previlige.equals("Admin")) {
                user.setPrivilege("local");
            }
            else {
                user.setPrivilege("Admin");
            }
            manageUser.updateUser(user);
        }

        RequestDispatcher dispatcher = req.getRequestDispatcher("/App/AdminConsole.jsp");
        dispatcher.forward(req, resp);




    }
}
