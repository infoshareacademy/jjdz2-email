package com.jbd.Authorization;

import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
    @Inject
    SessionData sessionData;
    private final static long CLIENT_ID = 1783631111890477L;
    private final static String REDIRECT_URI  = "localhost:8080/jbdee/LoginServlet" ;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String username = request.getParameter("username");
        String password = request.getParameter("password");




    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

//        response.sendRedirect("https://www.facebook.com/v2.8/dialog/oauth?client_id=1783631111890477&redirect_uri=http://localhost:8080/jbdee/form.jsp");
//
        }



}
