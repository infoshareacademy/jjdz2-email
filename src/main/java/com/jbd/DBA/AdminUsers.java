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


@WebServlet(urlPatterns = "/App/search")
public class AdminUsers extends HttpServlet {

    @Inject
    SaveUser saveUser;

    @EJB
    ContentmentVerification verification;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        List<SessionData> userList = new ArrayList<>();
        userList = saveUser.searchForAll();
        System.out.println(userList);


        req.setAttribute("userList", userList);
        RequestDispatcher dispatcher = req.getRequestDispatcher("/App/AdminConsole.jsp");
        dispatcher.forward(req, resp);



    }
}
