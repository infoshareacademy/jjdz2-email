package com.jbd.cutEmails;

import com.jbd.Email;
import com.jbd.JBDemail;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.Marker;
import org.slf4j.MarkerFactory;

import javax.ejb.Stateless;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.*;
import java.util.stream.Collectors;
@Stateless
public class FiveDaysNoAnswer extends JBDemail {

    private static final Logger LOGGER = LoggerFactory.getLogger(FiveDaysNoAnswer.class);
    private static final Marker FIVEDAYSNOANSWER_MARKER = MarkerFactory.getMarker("FiveDaysNoAnswer");

    public List<LocalDateTime> sortedEmailDates = new ArrayList<>();
    public List<LocalDateTime> afterAllList = new ArrayList<>();
    public List<Date> sortedEmailDatesInDate = new ArrayList<>();

    public void dateSort(List<Email> eMailKeeper) {
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
                        .map(d -> Date.from(d.atZone(ZoneId.systemDefault()).toInstant()))
                        .collect(Collectors.toList());
        sortedEmailDatesInDate = result;
        return result;
    }

    public void erasingFreeDaysFromDates(List<Date> sortedEmailDatesInDate) {
        sortedEmailDatesInDate.removeIf(date -> date.getDay() == 0 || date.getDay() == 6);
        sortedEmailDatesInDate.forEach((v) -> {
        });
    }

    public void dateToLocalDateTimeParse() {
        for (Date email : sortedEmailDatesInDate) {
            afterAllList.add(LocalDateTime.ofInstant(email.toInstant(), ZoneId.systemDefault()));
        }
    }

    public void checkIfWasAnswer(List<LocalDateTime> afterAllList) {
        LocalDateTime fiveDaysAgo = LocalDateTime.now().minusDays(5);
        afterAllList.removeIf(a -> a.isBefore(fiveDaysAgo));
    }

    public boolean chceckIfContentBetween() {
        boolean ifTrue;
        afterAllList.size();
        if (afterAllList.size() == 0) {
            ifTrue = true;
            LOGGER.info(FIVEDAYSNOANSWER_MARKER, "if true means that there was no answer for 5 working days  :  " + ifTrue);
        } else {
            ifTrue = false;
            LOGGER.info(FIVEDAYSNOANSWER_MARKER, "if false means that there was answer for 5 working days  :  " + ifTrue);
            LOGGER.info(FIVEDAYSNOANSWER_MARKER, "Mails with no answet 4 5 days :  :  " + afterAllList);


        }
        return ifTrue;
    }
    public List<LocalDateTime> fdnaList (){
if(afterAllList.isEmpty()){
    System.out.println("lista jest pusta, nie ma żadnych wiadomości na które nie było odpowiedzi przez 5 dni roboczych");
}
        else{
    System.out.println("lista adresów z którymi został przerwany kontakt :  ");
    System.out.println(afterAllList);
        }
        return afterAllList;
    }
}


