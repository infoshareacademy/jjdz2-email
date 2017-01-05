package com.jbd;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RudeWordsInContent extends FiveDaysNoAnswer {

    String tekst = "kur0wa";
    String regex = "kurwa";


    public void dateSort(){
        System.out.println("tu dziedziczymy z klasy FiveDaysNoAswer oraz wybieramy jedynie ostatni wynik w listy");
        super.dateSort();

        System.out.println("to jest ostatnia data z listy");
        System.out.println(dataList.get(dataList.size()-1));

    }
    public void ifRudeWord() {
        System.out.println("     tu się wyszukuje brzydkie wyrazy");
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(tekst);
        boolean found = matcher.matches();

        if (!found)
            System.out.println("nie znalazło:          kryterium brzydkich wyrazów nie zostało spełnione");
        else System.out.println("znalazło:               kryterium brzydkich wyrazów zotało spełione");

    }
}
