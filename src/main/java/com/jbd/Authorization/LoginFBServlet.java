package com.jbd.Authorization;

import com.jbd.DBA.SaveUser;
import com.jbd.JBDemail;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

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

@WebServlet("/LoginFBServlet")
public class LoginFBServlet extends HttpServlet {
    private static final Logger LOGGER = LogManager.getLogger(LoginFBServlet.class);

    @Inject
    FBConnection fbConnection;

    @Inject
    FBGraph fbGraph;

    @Inject
    SessionData sessionData;

    @Inject
    SaveUser saveUser;

    private static final long serialVersionUID = 1L;
    private String code = "";

    public void doGet(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {
        LOGGER.info("Trying to log in to FB");
        code = req.getParameter("code");
        if (code == null || code.equals("")) {
            throw new RuntimeException(
                    "ERROR: Didn't get code parameter in callback.");
        }
        LOGGER.info("Logging in FB has been successful");

        String accessToken = fbConnection.getAccessToken(code);
        LOGGER.debug("Access token: " + accessToken);
        fbGraph.setAccessToken(accessToken);

        String graph = fbGraph.getFBGraph();
        LOGGER.info("Generated FBGraph");
        Map<String, String> fbProfileData = fbGraph.getGraphData(graph);

        sessionData.login(code, fbProfileData.get("first_name") + " " + fbProfileData.get("last_name"), fbProfileData.get("email"));
        LOGGER.info("Logged User: " + sessionData.getUsername());
        LOGGER.debug("Session data :" + sessionData);
        SessionData userFromDatabase = new SessionData();

        SessionData user = new SessionData();
        SessionData user2 = new SessionData();
        user.setUsername(sessionData.getUsername());
        user.setCode(sessionData.getCode());
        user.setLogged(sessionData.isLogged());
        user.setUsermail(sessionData.getUsermail());
        user.setLoginTime(sessionData.getLoginTime());
        user.setPrivilege(sessionData.getPrivilege());
        saveUser.saveUser(user);

        userFromDatabase = saveUser.getUser(1L);
        if(userFromDatabase.getUsername().equals("Marcin Bartoszek")){
            user2.setPrivilege("Admin");
        }
        user2.setUsername(sessionData.getUsername());
        user2.setCode(sessionData.getCode());
        user2.setLogged(sessionData.isLogged());
        user2.setUsermail(sessionData.getUsermail());
        user2.setLoginTime(sessionData.getLoginTime());
        saveUser.saveUser(user2);
        String name = fbProfileData.get("first_name");

        if (sessionData.isLogged()) {
            req.setAttribute("name", name);
            res.sendRedirect("/jbdee/App/form.jsp");
        }


    }

}

