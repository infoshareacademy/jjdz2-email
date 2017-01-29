package com.jbd;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RudeWordsInContent {

    ArrayList<String> content = new ArrayList<>();

    String text = "test";
    String regex = "test";



    public void ifRudeWord(List<Email> eMailKeeper) {
        ListIterator<String> litr = null;

        for (Email email: eMailKeeper) {
            content.add(email.getContent());
        }

        Pattern pattern = Pattern.compile(regex);


        for (Iterator<String> iter = content.iterator(); iter.hasNext(); ){
            String var = iter.next();
            Matcher matcher = pattern.matcher(var);

            boolean found = matcher.matches();
            System.out.println("if true that means there were swearings in message   :   "+found);

        }










    }
}
