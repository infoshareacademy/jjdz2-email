package com.jbd.KeywordsFinder;

import com.jbd.Email;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DisplayPhoneNumbers {
    String test = " 24 +48 +48 515417846 515417846 135487562314";
    String phonePatternWithPlus = "(\\s\\+?\\d{2})(\\s\\d{9}\\b)"; // +48 515417888
    //String phonePatternWithoutSpace = "(\\s\\+?\\d{2})(\\d{9}\\b)"; // +48515417888
    String phonePatternWithoutPlusAndSpacs = "(\\b\\d{9}\\b)"; // 515417888
    private Pattern patternWithPlus;
    private Pattern patternWithoutPlusAndSpaces;
    private Pattern patternWithoutSpace;

    private boolean searchDuplicates(Map<String, List<String>> mapToSearch, String stringTooSearch) {
        boolean foundDuplicate = false;
        for (String key : mapToSearch.keySet()) {
            System.out.println(key);
            for (String value : mapToSearch.get(key)) {
                if (value.equals(stringTooSearch)) {
                    foundDuplicate = true;
                }
            }
            if (foundDuplicate)
                break;
        }
        //String keys = mapToSearch.keySet();
        return foundDuplicate;
    }

    private String returnFormattedPhoneNumber(String phoneNumber){
        String formatedPhoneNumber;
        formatedPhoneNumber = phoneNumber.trim().replace(" ","");
        return  formatedPhoneNumber;
    }

    public Map<String, List<String>> searchPhoneNumbers(List<Email> emailList) {
        Map<String, List<String>> resultMap = new TreeMap<>();
        List<String> testArrayList = new ArrayList<>();
        patternWithPlus = Pattern.compile(phonePatternWithPlus);
        patternWithoutPlusAndSpaces = Pattern.compile(phonePatternWithoutPlusAndSpacs);
        // patternWithoutSpace = Pattern.compile(phonePatternWithoutSpace);

        for (Email email : emailList) {
            Matcher matcher = patternWithPlus.matcher(email.getContent());
            Matcher matcher1 = patternWithoutPlusAndSpaces.matcher(email.getContent());
            // Matcher matcher2 = patternWithoutSpace.matcher(email.getContent());
            while (matcher.find()) {
                System.out.println("Matcher 0");
                System.out.println(matcher.group());
                String phoneNumber = returnFormattedPhoneNumber(matcher.group());
                System.out.println("Uzyto funckji" + phoneNumber);
//                String phoneNumber = matcher.group();
//                System.out.println(phoneNumber.replace(" ", ""));
//                String fromEmail = email.getFrom();
//                testArrayList.add(phoneNumber);
//                resultMap.put(fromEmail, testArrayList);
//                break;
            }
//            while (matcher2.find()) {
//                System.out.println("Matcher 2");
//                System.out.println(matcher2.group());
//            }
            while (matcher1.find()) {
                System.out.println("Matcher 1");
                System.out.println(matcher1.group(0));
            }


        }


        return resultMap;
    }
}
