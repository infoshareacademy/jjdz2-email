package com.jbd;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RudeWordsInContent extends FiveDaysNoAnswer {

    String tekst = "kur0wa";
    String regex = "kurwa";

    public void dateSort(){super.dateSort();}

    public void ifRudeWord() {
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(tekst);

        boolean found = matcher.matches();
        System.out.println("if true that means there were swearings in message   :   "+found);
    }
}
