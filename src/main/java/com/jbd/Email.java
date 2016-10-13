package com.jbd;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Email {
    String regexFrom = "From (.)*(a-zA-Z)*(com)";
    String regexContent = "(.)";
    String regexDate = "Date: (.)*";
    String regexSubject = "Subject: (.)*";
    String file = "alalala";


    public Email(String from, String content , String data, String subject) {
        regexFrom = from;
       regexContent = content;
        regexDate = data;
        regexSubject = subject;
    }


    public String reportFrom(String file) {




        String result = "Wzorzec: \"" + regexFrom + "\"\n" +
                "Tekst: \"" + file + "\"";

        Pattern pattern;
        try {
            pattern = Pattern.compile(regexFrom);
        } catch (Exception exc) {
            return result + "\n" + exc.getMessage();
        }
        Matcher matcher = pattern.matcher(file);
        boolean found = matcher.find();
        if (!found)
            result += "\nfind(): Nie znaleziono żadnego podłańcucha " +
                    "pasującego do wzorca";
        else
            do {
                result += "\nfind(): Dopasowano podłańcuch \"" + matcher.group() +
                        "\" od pozycji " + matcher.start() +
                        " do pozycji " + matcher.end() + ".";
            } while(matcher.find());


        System.out.println();
        return result;
    }
    public String reportContent (String file) {
        String result = "Wzorzec: \"" + regexContent + "\"\n" +
                "Tekst: \"" + file + "\"";

        Pattern pattern;
        try {
            pattern = Pattern.compile(regexContent);
        } catch (Exception exc) {
            return result + "\n" + exc.getMessage();
        }
        Matcher matcher = pattern.matcher(file);
        boolean found = matcher.find();
        if (!found)
            result += "\nfind(): Nie znaleziono żadnego podłańcucha " +
                    "pasującego do wzorca";
        else
            do {
                result += "\nfind(): Dopasowano podłańcuch \"" + matcher.group() +
                        "\" od pozycji " + matcher.start() +
                        " do pozycji " + matcher.end() + ".";
            } while (matcher.find());


        System.out.println();
        return result;
    }


    public String reportDate (String file) {

        String result = "Wzorzec: \"" + regexDate + "\"\n" +
                "Tekst: \"" + file + "\"";

        Pattern pattern;
        try {
            pattern = Pattern.compile(regexDate);
        } catch (Exception exc) {
            return result + "\n" + exc.getMessage();
        }
        Matcher matcher = pattern.matcher(regexDate);
        boolean found = matcher.find();
        if (!found)
            result += "\nfind(): Nie znaleziono żadnego podłańcucha " +
                    "pasującego do wzorca";
        else
            do {
                result += "\nfind(): Dopasowano podłańcuch \"" + matcher.group() +
                        "\" od pozycji " + matcher.start() +
                        " do pozycji " + matcher.end() + ".";
            } while (matcher.find());


        System.out.println();
        return result;

    }

    public String reportSubject (String file) {

        String result = "Wzorzec: \"" + regexSubject + "\"\n" +
                "Tekst: \"" + file + "\"";

        Pattern pattern;
        try {
            pattern = Pattern.compile(regexSubject);
        } catch (Exception exc) {
            return result + "\n" + exc.getMessage();
        }
        Matcher matcher = pattern.matcher(regexSubject);
        boolean found = matcher.find();
        if (!found)
            result += "\nfind(): Nie znaleziono żadnego podłańcucha " +
                    "pasującego do wzorca";
        else
            do {
                result += "\nfind(): Dopasowano podłańcuch \"" + matcher.group() +
                        "\" od pozycji " + matcher.start() +
                        " do pozycji " + matcher.end() + ".";
            } while (matcher.find());

        return result;
    }

}