package com.myAgeEducation.cbseClass5.maths.mappingskills;

import com.myAgeEducation.cbseClass5.utils.ConceptQuestion;
import com.myAgeEducation.cbseClass5.utils.OptionUtils;
import com.myAgeEducation.cbsecommon.Question;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class MappingSkillConceptQuestionGenerator
{
    private static final Random RANDOM = new Random();

    public static Question generateQuestion()
    {
        return generateFixedQuestion();
    }

    public static ArrayList<Question> generateAllQuestions()
    {
        ArrayList<Question> questions = new ArrayList<>();

        List<ConceptQuestion> list = Arrays.asList(FIXED_QUESTIONS);
        Collections.shuffle(list);

        for (ConceptQuestion data : list) {
            List<String> options = new ArrayList<>();
            options.add(data.correctAnswer);
            Collections.addAll(options, data.wrongAnswers);
            Collections.shuffle(options);
            Question question = createQuestion(data.question, data.correctAnswer, options);
            questions.add(question);
        }

        return questions;
    }

    private static final ConceptQuestion[] FIXED_QUESTIONS =
            {
                    new ConceptQuestion(
                            "If the direction is between the north and east, it is called _____ direction",
                            "north-east",
                            "north", "east", "south"),

                    new ConceptQuestion(
                            "If the direction is between the north and west, it is called _____ direction",
                            "north-west",
                            "north-east", "east", "south"),

                    new ConceptQuestion(
                            "If the direction is between the south and west, it is called _____ direction",
                            "south-west",
                            "north-east", "east", "south"),
            };

    private static Question generateFixedQuestion()
    {
        ConceptQuestion data = FIXED_QUESTIONS[RANDOM.nextInt(FIXED_QUESTIONS.length)];
        List<String> options = new ArrayList<>();
        options.add(data.correctAnswer);
        Collections.addAll(options, data.wrongAnswers);
        Collections.shuffle(options);
        return createQuestion(data.question, data.correctAnswer, options);
    }

    private static Question createQuestion(String questionText, String correctAnswer, List<String> options)
    {
        Question question = new Question();
        question.setQuestion(questionText);
        OptionUtils.setQuestionOptions(question, options);
        question.setAnswer(correctAnswer);
        return question;
    }
}