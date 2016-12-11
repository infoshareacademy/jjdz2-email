package com.jbd.Authorization;

import java.io.IOException;
import java.util.Map;

import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.ServletRequest;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/Main")
public class MainMenu extends HttpServlet {

    @Inject
    FBConnection fbConnection;

    @Inject
    FBGraph fbGraph;

    @Inject
    SessionData sessionData;

    private static final long serialVersionUID = 1L;
    private String code = "";

    public void doGet(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {
        code = req.getParameter("code");
        System.out.println("code: " + code);
        if (code == null || code.equals("")) {
            throw new RuntimeException(
                    "ERROR: Didn't get code parameter in callback.");
        }

        String accessToken = fbConnection.getAccessToken(code);
        fbGraph.setAccessToken(accessToken);

        String graph = fbGraph.getFBGraph();
        Map<String, String> fbProfileData = fbGraph.getGraphData(graph);

        sessionData.login(code, fbProfileData.get("first_name") + " " + fbProfileData.get("last_name"));
        String name = fbProfileData.get("first_name");

        if (sessionData.isLogged()) {
            System.out.println("Now work dispatcher");
            System.out.println("SessionData: " + sessionData.getUsername() );
            req.setAttribute("name", name);

            //req.getSession(false);
            //HttpSession
           // HttpServletResponse httpResponse = (HttpServletResponse) req;
           // HttpServletRequest httpRequest =(HttpServletRequest) res;
           // System.out.println("Session Data:" +req.getAttribute("sessionData"));
            // req.setAttribute("sessionData", sessionData);


//            RequestDispatcher dispatcher = req.getRequestDispatcher("/form.jsp");
//            dispatcher.forward(req, res);
//            System.out.println();

            res.sendRedirect("/jbdee/form.jsp");
        }
        //req.setAttribute("results", results);

    }

}

