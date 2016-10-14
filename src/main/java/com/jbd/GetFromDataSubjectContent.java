package com.jbd;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class GetFromDataSubjectContent {

    private String regexFrom = "From (.)*(a-zA-Z)*(\\\\.com)*";
    private String regexData = "Date: (.)**";
    private String regexSubject = "Subject: (.)*";
    private String regexContent = "(.)";
    String file = "";

    public String reportFrom(String file) {

        this.file = file;

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

    public String reportContent () {
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

    public String reporData () {

        String result = "Wzorzec: \"" + regexData + "\"\n" +
                "Tekst: \"" + file + "\"";

        Pattern pattern;
        try {
            pattern = Pattern.compile(regexData);
        } catch (Exception exc) {
            return result + "\n" + exc.getMessage();
        }
        Matcher matcher = pattern.matcher(regexData);
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

    public String reporSubject () {

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


        System.out.println();
        return result;

    }


}