package com.jbd.Authorization;
import java.io.IOException;
import java.util.Map;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Main")
public class MainMenu extends HttpServlet {

    @Inject
    FBConnection fbConnection;

    @Inject
    FBGraph fbGraph;

    private static final long serialVersionUID = 1L;
    private String code="";

    public void service(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {
        code = req.getParameter("code");
        System.out.println("code: "+ code);
        if (code == null || code.equals("")) {
            throw new RuntimeException(
                    "ERROR: Didn't get code parameter in callback.");
        }
        //FBConnection fbConnection = new FBConnection();
        String accessToken = fbConnection.getAccessToken(code);

       // FBGraph fbGraph = new FBGraph(accessToken);
        fbGraph.setAccessToken(accessToken);
        String graph = fbGraph.getFBGraph();
        Map<String, String> fbProfileData = fbGraph.getGraphData(graph);
        ServletOutputStream out = res.getOutputStream();
        out.println("<h1>Facebook Login using Java</h1>");
        out.println("<h2>Application Main Menu</h2>");
        out.println("<div>Welcome "+fbProfileData.get("name"));
        out.println("<div>Your Email: "+fbProfileData.get("email"));
//        out.println("<div>You are "+fbProfileData.get("gender"));
    }

}

