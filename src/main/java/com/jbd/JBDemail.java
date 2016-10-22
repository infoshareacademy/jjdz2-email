package com.jbd;

public class JBDemail {
    public static void main(String[] args) {

        QuestionForm askQuestionsAndQuestionForm = new QuestionForm();
      //  askQuestionsAndQuestionForm.askQuestionsAndSetAnswers();
        GetFromDataSubjectContent lol = new GetFromDataSubjectContent();


        PathGetter pG = new PathGetter();
      //  pG.createFileListFromPath(pG.askUserAboutInputPath());

        String a2 =lol.reportFrom(pG.askUserAboutInputPath());
        System.out.println(a2);

    }
}
