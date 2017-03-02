package com.jbd;


import com.jbd.database.Form;
import com.jbd.database.Form_Details;
import com.jbd.database.ManageUser;

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
import java.time.LocalDateTime;
import java.util.List;

import static com.jbd.searchKeywords.KeywordsQuestionsMap.QUESTION;

@WebServlet(urlPatterns = "C:\\Users\\dzefrej0\\IdeaProjects\\jjdz2-email\\jjdz2-email\\src\\main\\webapp\\weirdcutemails.jsp")
public class MyServlet extends HttpServlet {

    private static final Logger LOGGER = LoggerFactory.getLogger(MyServlet.class);
    private static final Marker MARKER = MarkerFactory.getMarker("SearchKeywordsServlet");
    private int questionnaireCounter = 1;

    @EJB
   WeirdMessagesServlet weirdMessagesServlet;


    protected void doGet(HttpServletRequest req, HttpServletResponse response) throws IOException {
        System.out.println(req.getRemoteHost());
        req.setAttribute("weirdmailskurw0", weirdMessagesServlet.stringi());

        RequestDispatcher dispatcher = req.getRequestDispatcher("/weirdcutemails.jsp");

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse response) {





    }
}
