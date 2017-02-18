package com.jbd;

import java.time.LocalDateTime;
import java.time.Month;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

public class FiveDaysNoAnswer {

    public ArrayList<LocalDateTime> dataList = new ArrayList<>();
    public ArrayList<LocalDateTime> afterSortList = new ArrayList<>();
    public List<Date> sortedAndInDate = new ArrayList<>();

    public LocalDateTime data6 = LocalDateTime.of(2017, Month.JANUARY, 05, 23, 59, 59);
    public LocalDateTime data5 = LocalDateTime.of(2017, Month.JANUARY, 02, 23, 59, 59);
    public LocalDateTime data1 = LocalDateTime.of(2017, Month.JANUARY, 01, 23, 59, 59);
    public LocalDateTime data2 = LocalDateTime.of(2017, Month.JANUARY, 04, 23, 59, 59);
    public LocalDateTime data3 = LocalDateTime.of(2016, Month.DECEMBER, 31, 23, 59, 59);
    public LocalDateTime data4 = LocalDateTime.of(2016, Month.DECEMBER, 26, 23, 59, 51);
    public LocalDateTime data7 = LocalDateTime.of(2016, Month.DECEMBER, 06, 23, 59, 59);


    void dateSort(){

        dataList.add(data3);
        dataList.add(data2);
        dataList.add(data1);
        dataList.add(data4);
        dataList.add(data5);
        dataList.add(data6);
        dataList.add(data7);

        Collections.sort(dataList);
        afterSortList.addAll(dataList);
    }

    public List<Date> noWeekends(){

        ArrayList<LocalDateTime> a;
        a = afterSortList;
        List<Date> result =
                a.stream()
                        .map(d -> Date.from(d.atZone(ZoneId.systemDefault()).toInstant()))   // to jest parser z LocalDateTime do Date
                        .collect(Collectors.toList());
        sortedAndInDate = result;
        return result;

    }
    public void withoutWeekends(){
        sortedAndInDate.removeIf(date -> date.getDay() == 0 || date.getDay() == 6);
        sortedAndInDate.forEach((v) -> {}
        );
    }
    public void checkIfWasAnswer (){

        LocalDateTime fiveDaysAgo = LocalDateTime.now().minusDays(5);

        afterSortList.removeIf(lol -> lol.isAfter(fiveDaysAgo));
        afterSortList.forEach((v) -> {
                }
        );
    }
    public void chceckIfContentBetween (){
        afterSortList.size();
        if (afterSortList.size()<5)
        {
            boolean ifTrue = true;
            System.out.println("if true means that there was no answer for 5 working days  :  "+ifTrue);
        }
    }
}




