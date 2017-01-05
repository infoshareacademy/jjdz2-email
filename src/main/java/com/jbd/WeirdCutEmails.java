package com.jbd;

import java.time.LocalDateTime;

public class WeirdCutEmails{


    public static void main(String[] args) {

        WeirdCutEmails lolo1 = new WeirdCutEmails();
        FiveDaysNoAnswer fiveDaysNoAnswer = new FiveDaysNoAnswer();
        RudeWordsInContent rudeWordsInContent = new RudeWordsInContent();
        TwoMailsNoAnswer twoMailsNoAnswer = new TwoMailsNoAnswer();

        fiveDaysNoAnswer.dateSort();
        fiveDaysNoAnswer.noWeekends();
        fiveDaysNoAnswer.bezWeekendów();
        fiveDaysNoAnswer.checkIfWasAnswer();

        rudeWordsInContent.ifRudeWord();
        fiveDaysNoAnswer.chceckIfContentBetween();
        rudeWordsInContent.dateSort();
        twoMailsNoAnswer.dateSort();
        twoMailsNoAnswer.decideIfTwoAnswers();

    }

}



