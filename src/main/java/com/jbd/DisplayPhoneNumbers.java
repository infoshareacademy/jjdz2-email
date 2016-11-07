package com.jbd;

import com.jbd.Email;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DisplayPhoneNumbers {
    //String test = " 24 +48 +48 515417846 515417846 135487562314";
//    String phonePatternWithPlus = "(\\s\\+?\\d{2}?)?(\\s\\d{9}\\b)"; // +48 515417888
    String phonePatternWithPlus = "(\\s\\d{3}[\\-,\\s]?\\d{3}[\\-,\\s]?\\d{3}\\b)"; // +48 515417888

    //String phonePatternWithoutSpace = "(\\s\\+?\\d{2})(\\d{9}\\b)"; // +48515417888
    String phonePatternWithoutPlusAndSpacs = "(\\b\\d{9}\\b)"; // 515417888
    private Pattern patternWithPlus;
    private Pattern patternWithoutPlusAndSpaces;
    private Pattern patternWithoutSpace;

    private boolean searchDuplicates(Map<String, List<String>> mapToSearch, String stringTooSearch) {
        boolean foundDuplicate = false;
        for (String key : mapToSearch.keySet()) {
            for (String value : mapToSearch.get(key)) {
                if (value.trim().equals(stringTooSearch)) {
                    foundDuplicate = true;
                }
            }
            if (foundDuplicate)
                break;
        }

        return foundDuplicate;
    }

    private String returnFormattedPhoneNumber(String phoneNumber) {
        String formatedPhoneNumber;
        formatedPhoneNumber = phoneNumber.trim().replace(" ", "");
        //TO DO!
        //zamienic - na nic
        if (formatedPhoneNumber.contains("-")) {
            formatedPhoneNumber = phoneNumber.replace("-", "");
            formatedPhoneNumber.trim();
        }
        return formatedPhoneNumber;
    }

    public Map<String, List<String>> searchPhoneNumbers(List<Email> emailList) {
        Map<String, List<String>> resultMap = new TreeMap<>();
        List<String> testArrayList = new ArrayList<>();
        List<String> listContainingPhoneNumbers = new ArrayList<>();
        patternWithPlus = Pattern.compile(phonePatternWithPlus);
        patternWithoutPlusAndSpaces = Pattern.compile(phonePatternWithoutPlusAndSpacs);
        // patternWithoutSpace = Pattern.compile(phonePatternWithoutSpace);
        boolean isDuplicate = false;

        for (Email email : emailList) {
            Matcher matcher = patternWithPlus.matcher(email.getContent());
            Matcher matcher1 = patternWithoutPlusAndSpaces.matcher(email.getContent());
            // Matcher matcher2 = patternWithoutSpace.matcher(email.getContent());
            while (matcher.find()) {
                System.out.println("Poczatek!-----------------------------------");
                System.out.println("Matcher 0");
                System.out.println(matcher.group());
                String phoneNumber = returnFormattedPhoneNumber(matcher.group());
                System.out.println("Uzyto funckji: " + phoneNumber);
                if (resultMap.isEmpty()) {
                    System.out.println("Mapa pusta dodaje rekord");
                    List<String> phoneList = new ArrayList<>();
                    //phoneNumber = returnFormattedPhoneNumber(phoneNumber);
                    phoneList.add(phoneNumber.trim());
                    resultMap.put(email.getFrom(), phoneList);
                    System.out.println("Dodano : " + resultMap.get(email.getFrom()) + " od " + email.getFrom());
                } else {
                    if (resultMap.containsKey(email.getFrom())) {
                        System.out.println("Mapa zawiera element " + email.getFrom());
                        System.out.println("Szukam czy duplikat...");
                        isDuplicate = searchDuplicates(resultMap, phoneNumber);
                        if (!isDuplicate) {
                            System.out.println("Brak duplikatów: dodaje numer");
                            List<String> tempPhoneNumberList = new ArrayList<>();
                            tempPhoneNumberList = resultMap.get(email.getFrom());
                            tempPhoneNumberList.add(phoneNumber);
                            testArrayList = tempPhoneNumberList;
                            //listContainingPhoneNumbers = resultMap.get("marcin@wp.pl");
                            System.out.println("Lista maili: " + testArrayList);
                            resultMap.put(email.getFrom(), testArrayList);
                        } else {
                            System.out.println("Duplikat, nie dodaje!");
                        }
                    } else {
                        List<String> phoneList = new ArrayList<>();
                        phoneList.add(phoneNumber);
                        resultMap.put(email.getFrom(), phoneList);
                    }

                }

            }


        }


        return resultMap;
    }
}
