package com.jbd;
import java.time.LocalDate;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


import java.time.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Email {
    private String from = "From (.)*(a-zA-Z)*(\\\\\\\\.com)*";
    private LocalDate data;
    private String subject = "Subject: (.)*";
    private String content;

    LocalDate objectOfDate;

    public Email(String from, String subject, String data, String content) {
        this.from = from;
        objectOfDate = LocalDate.parse(data);
        this.data = objectOfDate;
        this.subject = subject;
        this.content = content;
    }


    public LocalDate getData() {
        return data;
    }

    public void setData(String data) {
        objectOfDate = LocalDate.parse(data);
//        try {
//            objectOfDate = simpleDateFormat.parse(data);
//            this.data = objectOfDate;
//        } catch (ParseException e) {
//            e.printStackTrace();
//        }
    }

    public String getFrom(String file) {
        String result = "Wzorzec: \"" + from + "\"\n" +
                "Tekst: \"" + file + "\"";

        Pattern pattern;
        try {
            pattern = Pattern.compile(from);
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

    public void setFrom(String from) {
        this.from = from;
    }

    public String getSubject(String file) {

        String result = "Wzorzec: \"" + subject + "\"\n" +
                "Tekst: \"" + file + "\"";

        Pattern pattern;
        try {
            pattern = Pattern.compile(from);
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

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getContent(String file) {



        String result = "Wzorzec: \"" + content + "\"\n" +
                "Tekst: \"" + file + "\"";

        Pattern pattern;
        try {
            pattern = Pattern.compile(content);
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

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return from + " " + subject + " " + data.toString();
    }


}
