package com.jbd.KeywordsFinder;

import com.jbd.Email;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DisplayPhoneNumbers {
    String test = " 24 +48 +48 515417846 515417846 135487562314";
    String phonePatternWithPlus = "(\\s.?\\d{2})(\\s\\d{9}\\b)"; // +48 515417888
    String phonePatternWithoutSpace = "(\\s.?\\d{2})(\\d{9}\\b)"; // +48515417888
    String phonePatternWithoutPlusAndSpacs = "(\\b\\d{9}\\b)"; // 515417888
    private Pattern patternWithPlus;
    private Pattern patternWithoutPlusAndSpaces;
    private Pattern patternWithoutSpace;

    public Map<Email,String> searchPhoneNumbers(List<Email> emailList) {
        Map<Email,String> resultMap = new TreeMap<>();
        patternWithPlus = Pattern.compile(phonePatternWithPlus);
        patternWithoutPlusAndSpaces = Pattern.compile(phonePatternWithoutPlusAndSpacs);
        patternWithoutSpace = Pattern.compile(phonePatternWithoutSpace);

        for (Email email: emailList) {
            Matcher matcher = patternWithPlus.matcher(email.getContent());
            Matcher matcher1 = patternWithoutPlusAndSpaces.matcher(email.getContent());
            Matcher matcher2 = patternWithoutSpace.matcher(email.getContent());
            while (matcher.find()){
                System.out.println("Matcher 0");
                System.out.println(matcher.group());
            }
            while (matcher2.find()) {
                System.out.println("Matcher 2");
                System.out.println(matcher2.group());
            }
            while (matcher1.find()){
                System.out.println("Matcher 1");
                System.out.println(matcher1.group(0));
            }


        }




        return resultMap;
    }
}
