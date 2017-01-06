package com.jbd;

import java.time.LocalDateTime;
import java.time.Month;

public class TwoMailsNoAnswer extends FiveDaysNoAnswer{

    public LocalDateTime data6 = LocalDateTime.of(2017, Month.JANUARY, 03, 23, 59, 59);
    public LocalDateTime recieverMailDate;
    public LocalDateTime ourOneBeforeLastDate;

    public void dateSort(){
        super.dateSort();
        ourOneBeforeLastDate =     dataList.get(dataList.size()-2);
        recieverMailDate = data6;
    }
    public void decideIfTwoAnswers(){

        Boolean checkIf = recieverMailDate.isBefore(ourOneBeforeLastDate );
        System.out.println("if true we send two emails and get no answer   :   "+checkIf);
    }
}


