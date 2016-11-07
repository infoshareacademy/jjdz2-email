package com.jbd;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DisplayPhoneNumbers {
    String phonePattern = "(\\s\\d{3}[\\-,\\s]?\\d{3}[\\-,\\s]?\\d{3}\\b)"; // 515417888

    private Pattern patternPhone;

    private boolean searchDuplicates(Map<String, List<String>> mapToSearch, String stringTooSearch) {
        boolean foundDuplicate = false;
        for (String key : mapToSearch.keySet()) {
            for (String value : mapToSearch.get(key)) {
                if (value.trim().equals(stringTooSearch)) {
                    foundDuplicate = true;
                    break;
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
        if (formatedPhoneNumber.contains("-")) {
            formatedPhoneNumber = phoneNumber.trim().replace("-", "");
        }
        return formatedPhoneNumber;
    }

    public Map<String, List<String>> searchPhoneNumbers(List<Email> emailList) {
        Map<String, List<String>> resultMap = new TreeMap<>();
        patternPhone = Pattern.compile(phonePattern);
        boolean isDuplicate = false;

        for (Email email : emailList) {
            Matcher matcher = patternPhone.matcher(email.getContent());
            while (matcher.find()) {
                String phoneNumber = returnFormattedPhoneNumber(matcher.group());
                System.out.println("Uzyto funckji: " + phoneNumber);
                if (resultMap.isEmpty()) {
                    System.out.println("Mapa pusta dodaje rekord");
                    List<String> phoneList = new ArrayList<>();
                    phoneList.add(phoneNumber.trim());
                    resultMap.put(email.getFrom(), phoneList);
                    } else {
                    if (resultMap.containsKey(email.getFrom())) {
                        System.out.println("Mapa zawiera element " + email.getFrom());
                        System.out.println("Szukam czy duplikat...");
                        isDuplicate = searchDuplicates(resultMap, phoneNumber);
                        if (!isDuplicate) {
                            System.out.println("Brak duplikatów: dodaje numer");
                            List<String> phoneNumberList;
                            phoneNumberList = resultMap.get(email.getFrom());
                            phoneNumberList.add(phoneNumber);
                            System.out.println("Lista maili: " + phoneNumberList);
                            resultMap.put(email.getFrom(), phoneNumberList);
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
