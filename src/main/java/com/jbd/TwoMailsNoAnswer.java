package com.jbd;

import java.time.LocalDateTime;
import java.time.Month;

// Logika działania. Z listy dat wybieramy przedostatnią datę, oraz porównujemy ją z  datą ostatniego maila
// otrzymanego przez od danego nadawcy (reciver).
public class TwoMailsNoAnswer extends FiveDaysNoAnswer{


    public LocalDateTime data6 = LocalDateTime.of(2017, Month.JANUARY, 03, 23, 59, 59);

    public LocalDateTime recieverMailDate;
    public LocalDateTime ourOneBeforeLastDate;


    public void dateSort(){
        super.dateSort();

        System.out.println("to jest przedostatnia data z listy     "+ dataList.get(dataList.size()-2));
        ourOneBeforeLastDate =     dataList.get(dataList.size()-2);
        recieverMailDate = data6;
    }

    public void decideIfTwoAnswers(){
        System.out.println("reciever date  :   "+ recieverMailDate);
        System.out.println("Our one before last date"+ ourOneBeforeLastDate);


        System.out.println("Jeśli ");
        Boolean checkIf = recieverMailDate.isBefore(ourOneBeforeLastDate );
        System.out.println(checkIf);


        //
    }


}


