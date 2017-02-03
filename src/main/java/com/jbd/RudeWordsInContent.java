package com.jbd;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RudeWordsInContent {
public boolean found;
    ArrayList<String> content = new ArrayList<>();


    String regex = "rudeWord1|rudeWord2";


    public void iteratingThroughList(List<Email> eMailKeeper) {


        for (Email email : eMailKeeper) {
            content.add(email.getContent());
        }
    }
    public boolean ifRudeWord(ArrayList<String> content){
        Pattern pattern = Pattern.compile(regex);


        for (Iterator<String> iter = content.iterator(); iter.hasNext(); ) {
            String var = iter.next();
            Matcher matcher = pattern.matcher(var);
        found = matcher.matches();


        }
        System.out.println("if true that means there were swearings in message   :   " + found);
        return found;
        }


    }

