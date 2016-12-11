package com.jbd.Authorization;

import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;



@WebServlet("/logout")
public class LogoutServlet extends HttpServlet {
    @Inject
    SessionData sessionData;

    @Inject
    FBConnection fbConnection;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("Logout dziala");
        String name = sessionData.getUsername();
        sessionData.logout();
        HttpSession session = request.getSession(false);
        if(session != null){
            session.invalidate();
        }
        request.setAttribute("name", name);
       //
       // String code = request.getParameter("code");
       // String token = fbConnection.getAccessToken(code);
       // RequestDispatcher dispatcher = request.getRequestDispatcher("https://www.facebook.com/logout.php?next=http://localhost:8080/jbdee/loginFB.jsp&access_token="+token);
        //dispatcher.forward(request,response);
        response.sendRedirect("/jbdee/Bye.jsp");

    }
}
