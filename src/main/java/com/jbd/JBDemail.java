package com.jbd;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.Marker;
import org.slf4j.MarkerFactory;

import java.util.ArrayList;
import java.util.List;

public class JBDemail {
    private static final Logger LOGGER = LoggerFactory.getLogger(JBDemail.class);
    private static final Marker MAIN_MARKER = MarkerFactory.getMarker("Main");

    public static void main(String[] args) throws Exception {
        List<String> filesInStrings;
        List<Email> eMailKeeper;

        DisplayPhoneNumbers displayPhoneNumbers = new DisplayPhoneNumbers();

        QuestionForm askQuestionsAndQuestionForm = new QuestionForm();
        askQuestionsAndQuestionForm.askQuestionsAndSetAnswers();

        PathGetter pG = new PathGetter();
        filesInStrings = pG.createFileListFromPath(pG.askUserAboutInputPath());
        LOGGER.info(MAIN_MARKER, "Found: " + pG.getFileList().size() + " files.");

        FileParser fP = new FileParser();
        eMailKeeper = fP.parseEmails(filesInStrings);

        LOGGER.info("Total emails parsed: " + eMailKeeper.size());
        System.out.println(eMailKeeper);

        ContentmentVerification cV = new ContentmentVerification();

        List<String> eMailToLookFor = new ArrayList<>();
        eMailToLookFor.addAll((SearchCriteria.getEMAIL()));
        String dateOfEmailToLookFor = SearchCriteria.getSTARTDATE();
        //eMailToLookFor.add(SearchCriteria.getSTARTDATE());
        List<Email> result1;
        List<Email> result2;
        List<Email> result3;
        result1 = cV.searchEmailByName(eMailToLookFor, eMailKeeper);
        result2 = cV.searchEmailByTitleWithKeyWords(SearchCriteria.getKEYWORDS(), eMailKeeper);
        result3 = cV.searchEmailByDate(dateOfEmailToLookFor,eMailKeeper);

        // awh@malcolmhardie.com
        // 12/12/2004
        // 12/12/2006
        // test

        System.out.println("\n" + result1.size() + "\n");
        if(result1.size() == 0){
            System.out.println("Nie znaleziono wyników odpowiadająych podanemu krytetrium email");
        }
        else {
            System.out.println("Wyniki po nazwie maila: ");
        }
        System.out.println(result1);

        System.out.println("\n" + result2.size() + "\n");
        if(result2.size() == 0){
            System.out.println("Nie znaleziono wyników odpowiadająych podanemu krytetrium (Slowa kluczowe w tytule: )" + SearchCriteria.getKEYWORDS());
        }
        else {
            System.out.println("Wyniki po słowach kluczowych w tytule: ");
        }
        System.out.println(result2);

        System.out.println("\n" + result3.size() + "\n");
        if(result3.size() == 0){
            System.out.println("Nie znaleziono wyników odpowiadająych podanemu krytetrium (Data początkowa: )" + SearchCriteria.getSTARTDATE());
        }
        else {
            System.out.println("Wyniki po dacie: " + SearchCriteria.getSTARTDATE());
        }
        System.out.println(result3);

        System.out.println("\n" + eMailKeeper.size() + "\n");
        System.out.println(eMailKeeper);
        System.out.println(eMailKeeper.get(1).getData());

        }
}
