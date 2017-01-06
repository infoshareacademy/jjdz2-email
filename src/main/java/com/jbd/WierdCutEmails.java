package com.jbd;


public class WierdCutEmails{

    public static void main(String[] args) {

        WierdCutEmails wierdCutEmails = new WierdCutEmails();
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
