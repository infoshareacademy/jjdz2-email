package com.jbd.cutEmails;

import com.jbd.Email;
import com.jbd.MailHolder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.Marker;
import org.slf4j.MarkerFactory;

import javax.ejb.EJB;
import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = "weirdcutemails")
public class MyServlet extends HttpServlet {
    private static final Logger LOGGER = LoggerFactory.getLogger(MyServlet.class);
    private static final Marker MARKER = MarkerFactory.getMarker("SearchKeywordsServlet");
    private int questionnaireCounter = 1;
    private List<Email> recivedEamils;

    @EJB
    WeirdMessagesServlet weirdMessagesServlet;

    @Inject
    MailHolder mailHolder;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse response) throws IOException {
        recivedEamils = mailHolder.getMails();
        req.setAttribute("displayMails", recivedEamils);
        LOGGER.info(MARKER, "Displaying: " + recivedEamils.size() + " records.");

        RequestDispatcher dispatcher = req.getRequestDispatcher("/weirdcutemails.jsp");
        try {
            dispatcher.forward(req, response);
        } catch (ServletException e) {
            LOGGER.debug(MARKER, "Caught ServletException " + e);
            e.printStackTrace();
        } catch (IOException e) {
            LOGGER.debug(MARKER, "Caught IOException " + e);
            e.printStackTrace();
        }

        //System.out.println(req.getRemoteHost());
        //req.setAttribute("weirdmailskurw0", weirdMessagesServlet.stringi());
        //RequestDispatcher dispatcher = req.getRequestDispatcher("/weirdcutemails.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse response) {
    }
}
