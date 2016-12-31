package com.jbd.Authorization;

import com.jbd.DBA.SaveUser;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
    private SessionData userFromDatabase;
    private List<SessionData> usersFromDatabase;
    String privilege = "local";
    private boolean isNotInDB;
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

        SessionData adminUser = new SessionData();
        adminUser.setUsermail("marbar1812@gmail.com");
        adminUser.setUsername("Marcin Bartoszek");
        adminUser.setPrivilege("Admin");
        saveUser.saveUser(adminUser);

        usersFromDatabase = saveUser.searchForAll();
        for (SessionData user:usersFromDatabase) {
            String userName = fbProfileData.get("first_name") + " " + fbProfileData.get("last_name");
            if (user.getUsername().equals(userName) && user.getUsermail().equals(fbProfileData.get("email"))){
                if(user.getPrivilege().equals("Admin")){
                privilege = "Admin";
                }
                else
                privilege = "local";
                isNotInDB = false;
                break;
            }
            else
                privilege = "local";
                isNotInDB = true;
        }

        sessionData.login(code, fbProfileData.get("first_name") + " " + fbProfileData.get("last_name"), fbProfileData.get("email"), privilege);
        if(isNotInDB){
            String userName = fbProfileData.get("first_name") + " " + fbProfileData.get("last_name");
            String userMail = fbProfileData.get("email");
            SessionData sessionData = new SessionData();
            sessionData = createUserToDB(userName, userMail,privilege);
            saveUser.saveUser(sessionData);
        }
        LOGGER.info("Logged User: " + sessionData.getUsername());
        LOGGER.debug("Session data :" + sessionData);


        SessionData user3 = new SessionData();
        user3.setUsername("Karolina Badziak");
        user3.setCode(null);
        user3.setLogged(true);
        user3.setUsermail("Karolina");
        user3.setLoginTime(sessionData.getLoginTime());
        user3.setPrivilege("local");

        //saveUser.saveUser(user2);
        saveUser.saveUser(user3);
        String name = fbProfileData.get("first_name");

        if (sessionData.isLogged()) {
            req.setAttribute("name", name);
            res.sendRedirect("/jbdee/App/AdminConsole.jsp");
        }


    }

    public SessionData createUserToDB(String userName, String userMail, String privilege){
        SessionData user = new SessionData();
        user.setUsername(userName);
        user.setUsermail(userMail);
        user.setPrivilege(privilege);
        return user;
    }


}



