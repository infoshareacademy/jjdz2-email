package com.jbd.Authorization;

import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;



@WebServlet("/logout")
public class LogoutServlet extends HttpServlet {
    @Inject
    SessionData sessionData;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("Logout dziala");
        String name = sessionData.getUsername();
        sessionData.logout();
        request.setAttribute("name", name);
        response.sendRedirect("/jbdee/Bye.jsp");
//        RequestDispatcher dispatcher = request.getRequestDispatcher("/Bye.jsp");
//        dispatcher.forward(request,response);
    }
}
