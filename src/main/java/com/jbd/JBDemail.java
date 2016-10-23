package com.jbd;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class JBDemail {
    public static void main(String[] args) {
        List<String> filesInStrings = new ArrayList<>();
        List<Email> eMailKeeper = new ArrayList<>();

        QuestionForm askQuestionsAndQuestionForm = new QuestionForm();
        askQuestionsAndQuestionForm.askQuestionsAndSetAnswers();

        PathGetter pG = new PathGetter();
        pG.createFileListFromPath(pG.askUserAboutInputPath());

        FileLoad fL = new FileLoad();
        filesInStrings.addAll(pG.getFileList().stream().map(fL::fileLoad).collect(Collectors.toList()));

        MakeEmailsFromString makeEmails = new MakeEmailsFromString();
        for (String s : filesInStrings) {
            eMailKeeper.addAll(makeEmails.makeEmailList(s));
        }

        ContentmentVerification cV = new ContentmentVerification();

        List<String> eMailToLookFor = new ArrayList<>();
        eMailToLookFor.add(SearchCriteria.getEMAIL());
        List<Email> result1;
        List<Email> result2;
        //List<Email> result3;
        result1 = cV.searchEmailByName(eMailToLookFor, eMailKeeper);
        result2 = cV.searchEmailByTitleWithKeyWords(SearchCriteria.getKEYWORDS(), eMailKeeper);
        //result3 = cV.searchEmailByDate()

        // awh@malcolmhardie.com
        // 12/12/2004
        // 12/12/2006
        // test

        System.out.println("\n" + result1.size() + "\n");
        System.out.println(result1);

        System.out.println("\n" + result2.size() + "\n");
        System.out.println(result2);

        System.out.println("\n" + eMailKeeper.size() + "\n");
        System.out.println(eMailKeeper);
        System.out.println(eMailKeeper.get(1).getData());

    }
}
