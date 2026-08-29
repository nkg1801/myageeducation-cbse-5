package com.myAgeEducation.cbseClass5.maths.symmetry;
import com.myAgeEducation.cbseClass5.utils.OptionUtils;
import com.myAgeEducation.cbsecommon.Question;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class SymmetryQuestionGenerator {
    private static final Random RANDOM = new Random();

    /*public static Question generateQuestion() {
        SymmetryQuestionData data = generateQuestionData();
        return convertToQuestion(data);
    }*/

    public static ArrayList<Question> generateAllQuestions()
    {
        ArrayList<Question> questions = new ArrayList<>();
        for(String[] s : symmetryQuestionBank)
        {
            SymmetryQuestionData data = generateQuestionData(s);
            Question question = convertToQuestion(data);
            questions.add(question);
        }

        Collections.shuffle(questions);

        return questions;
    }

    private static SymmetryQuestionData generateQuestionData(String[] questionText) {
        String question;
        String answer;
        String[] options;

        question = questionText[0];
        answer = questionText[1];
        options = Arrays.copyOfRange(questionText, 1, questionText.length);

        // Shuffle options if they are not TRUE/FALSE to add variety
        if (options.length > 2) {
            List<String> optionList = new ArrayList<>();
            Collections.addAll(optionList, options);
            Collections.shuffle(optionList, RANDOM);
            options = optionList.toArray(new String[0]);
        }

        return new SymmetryQuestionData(question, answer, options);
    }

    private static Question convertToQuestion(SymmetryQuestionData data) {
        Question question = new Question();
        question.setQuestion(data.question);
        question.setAnswer(data.answer);
        OptionUtils.setQuestionOptions(question, data.options);
        return question;
    }

    private static final String[][] symmetryQuestionBank = {
            {"How many lines of symmetry does a rectangle have?", "2", "1", "4", "infinite"},
            {"How many lines of symmetry does a square have?", "4", "2", "1", "8"},
            {"How many lines of symmetry does a pair of scissors have?", "1", "2", "0", "4"},
            {"TRUE or FALSE. A circle has only one line of symmetry.", "FALSE", "TRUE"},
            {"A circle has ___________ lines of symmetry.", "infinite", "one", "two", "four"},
            {"How many lines of symmetry does an equilateral triangle have?", "3", "1", "2", "0"},
            {"How many lines of symmetry does a regular pentagon have?", "5", "1", "4", "infinite"},
            {"How many lines of symmetry does the letter 'H' have?", "2", "1", "0", "4"},
            {"Which of these letters has no line of symmetry?", "F", "A", "M", "T"},
            {"A line that divides a figure into two identical halves is called a line of _________.", "symmetry", "boundary", "intersection", "division"}
    };
}
