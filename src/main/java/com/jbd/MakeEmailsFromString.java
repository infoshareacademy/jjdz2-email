package com.jbd;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MakeEmailsFromString {
    private List<Email> emailsFromString = new ArrayList<>();
    private String EMAILREGEX = "(?:[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*|\"(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21\\x23-\\x5b\\x5d-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])*\")@(?:(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?|\\[(?:(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.){3}(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?|[a-z0-9-]*[a-z0-9]:(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21-\\x5a\\x53-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])+)\\])";
    private String FROMREGEX = "(from\\s)("+EMAILREGEX+")";
    private String SUBJECTREGEX = "(subject:\\s)(.*)";
    //private String DATEREGEX = "(\\ndate:\\s)(.*)";
    //private String CONTENTREGEX = "(x-list.*|list.*)(\\n\\n)(?s)(.*)(\\n\\n\\n)";//(?s)<FMSFlightPlan>(.*?)</FMSFlightPlan>

    public List<Email> makeEmailList(String file){
        Matcher fromMatcher = getMatcherFor(FROMREGEX, file);
        Matcher subjectMatcher = getMatcherFor(SUBJECTREGEX, file);

        //Pattern pattern3 = Pattern.compile(DATEREGEX, Pattern.CASE_INSENSITIVE);
        //Matcher matcher3 = pattern3.matcher(file);

        //Pattern pattern4 = Pattern.compile(CONTENTREGEX, Pattern.CASE_INSENSITIVE);
        //Matcher matcher4 = pattern4.matcher(file);

        while(fromMatcher.find() && subjectMatcher.find()){
            Email e = new Email(fromMatcher.group(2),subjectMatcher.group(2));
            emailsFromString.add(e);
        }

//        while(matcher4.find()) {
//            System.out.println("found: "
//                    + matcher4.start() + " - " + matcher4.end());
//            System.out.println(matcher4.group(3));
//        }

//        for(int i=0;i<1500;i++){
//            System.out.print(file.charAt(i));
//        }

        return emailsFromString;
    }

    private Matcher getMatcherFor(String fromregex, String file) {
        Pattern pattern = Pattern.compile(fromregex, Pattern.CASE_INSENSITIVE);
        return pattern.matcher(file);
    }


}