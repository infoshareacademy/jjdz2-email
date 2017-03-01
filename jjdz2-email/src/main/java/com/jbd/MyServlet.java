package com.jbd;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/myservlet")
public class MyServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
FiveDaysNoAnswer olo = new FiveDaysNoAnswer();
   String button = request.getParameter("button");

        if (request.getParameter("button1") != null) {
        olo.chceckIfContentBetween();
            System.out.println("pipa");
            System.out.println(olo.chceckIfContentBetween());


            request.getRequestDispatcher("footer.jsp").forward(request, response);
       }

    }}