package com.jbd;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.*;
import java.util.stream.Collectors;

public class FiveDaysNoAnswer extends JBDemail {

    public List<LocalDateTime> sortedEmailDates = new ArrayList<>();
    public List<LocalDateTime> afterAllList = new ArrayList<>();
    public List<Date> sortedEmailDatesInDate = new ArrayList<>();

    void dateSort(List<Email> eMailKeeper) {

        for (Email email : eMailKeeper) {

            sortedEmailDates.add(email.getData());
        }
        Collections.sort(sortedEmailDates);
    }

    public List<Date> LocalDateTimeToDateParse() {
        List<LocalDateTime> a;
        a = sortedEmailDates;
        List<Date> result =
                a.stream()
                        .map(d -> Date.from(d.atZone(ZoneId.systemDefault()).toInstant()))   // to jest parser z LocalDateTime do Date
                        .collect(Collectors.toList());
        sortedEmailDatesInDate = result;
        return result;
    }

    public void erasingFreeDaysFromDates(List<Date>sortedEmailDatesInDate) {
        sortedEmailDatesInDate.removeIf(date -> date.getDay() == 0 || date.getDay() == 6);
        sortedEmailDatesInDate.forEach((v) -> {
                } );}

    public void dateToLocalDateTimeParse() {
        for (Date email : sortedEmailDatesInDate) {
            afterAllList.add(LocalDateTime.ofInstant(email.toInstant(), ZoneId.systemDefault()));
        }
    }

    public void checkIfWasAnswer(List<LocalDateTime>afterAllList) {

        LocalDateTime fiveDaysAgo = LocalDateTime.now().minusDays(5);

        afterAllList.removeIf(lol -> lol.isBefore(fiveDaysAgo));
    }

    public boolean chceckIfContentBetween(boolean ifTrue) {

        afterAllList.size();
        if (afterAllList.size() ==0 ) {
ifTrue = true;
            System.out.println("if true means that there was no answer for 5 working days  :  " + ifTrue);
        }else{
            ifTrue = false;
            System.out.println("if false means that there was answer for 5 working days  :  " + ifTrue);
        }
        return ifTrue;
    }
}


