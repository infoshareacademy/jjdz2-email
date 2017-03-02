package com.jbd;


import javax.ejb.Stateless;

@Stateless
public class WeirdMessagesServlet{

    public String stringi(){
        String olo = "dupsko";

        return olo;
    }


}