package com.jbd;


public class WeirdCutEmails{

    public static void main(String[] args) {

        WeirdCutEmails wierdCutEmails = new WeirdCutEmails();
        FiveDaysNoAnswer fiveDaysNoAnswer = new FiveDaysNoAnswer();
        RudeWordsInContent rudeWordsInContent = new RudeWordsInContent();
        TwoMailsNoAnswer twoMailsNoAnswer = new TwoMailsNoAnswer();

        fiveDaysNoAnswer.dateSort();
        fiveDaysNoAnswer.noWeekends();
        fiveDaysNoAnswer.withoutWeekends();
        fiveDaysNoAnswer.checkIfWasAnswer();

        rudeWordsInContent.ifRudeWord();
        fiveDaysNoAnswer.chceckIfContentBetween();
        rudeWordsInContent.dateSort();
        twoMailsNoAnswer.dateSort();
        twoMailsNoAnswer.decideIfTwoAnswers();
    }
}
