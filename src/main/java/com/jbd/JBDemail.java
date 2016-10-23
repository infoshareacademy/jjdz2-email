package com.jbd;

import java.util.ArrayList;
import java.util.List;

public class JBDemail {
    public static void main(String[] args) {
        List<String> filesInStrings = new ArrayList<>();
        List<Email> eMailKeeper = new ArrayList<>();

        QuestionForm askQuestionsAndQuestionForm = new QuestionForm();
        //askQuestionsAndQuestionForm.askQuestionsAndSetAnswers();

        PathGetter pG = new PathGetter();
        //pG.createFileListFromPath(pG.askUserAboutInputPath());

        FileLoad fL = new FileLoad();
        //filesInStrings.addAll(pG.getFileList().stream().map(fL::fileLoad).collect(Collectors.toList()));
        /*Comment left intentionally for educational purposes as explanation of line above
        for (String s : pG.getFileList()) {
            filesInStrings.add(fL.fileLoad(s));
        }*/

        MakeEmailsFromString makeEmails = new MakeEmailsFromString();
        System.out.println(makeEmails.tempName());

    }
}
