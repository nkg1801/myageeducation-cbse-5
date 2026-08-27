package com.myAgeEducation.cbseClass5;

import com.myAgeEducation.cbsecommon.Question;

import java.util.ArrayList;
import java.util.List;

public class QuestionManager {

    static ArrayList<Question> allQuestions = new ArrayList<>();
    public static List<Question> getQuestions(String subject)
    {
        switch(subject.toLowerCase())
        {
            case "maths":
                addMathsQuestions();
                break;

            case "science":
                addScienceQuestions();
                break;

        }
        return allQuestions;
    }

    public static void addMathsQuestions()
    {

    }

    public static void addScienceQuestions()
    {

    }
}
