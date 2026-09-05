package com.myAgeEducation.cbseClass5.maths.placevalue.numbercomparison;
import com.myAgeEducation.cbseClass5.utils.OptionUtils;
import com.myAgeEducation.cbsecommon.Question;

public class NumberComparisonQuestionGenerator
{
    private NumberComparisonQuestionGenerator()
    {
        // Prevent object creation
    }

    private static String buildQuestionText(NumberComparisonQuestionData data)
    {
        if (data.questionType == ComparisonQuestionType.WHICH_IS_TRUE)
        {
            return "Which is true?";
        }
        else if (data.questionType == ComparisonQuestionType.WHICH_IS_FALSE)
        {
            return "Which is false?";
        }
        else if (data.questionType == ComparisonQuestionType.WHICH_IS_GREATER)
        {
            return "Which integer is greater?";
        }
        else
        {
            return "Which integer is smaller?";
        }
    }

    public static Question generateQuestion()
    {
        NumberComparisonQuestionData data = NumberComparisonDataGenerator.generate();
        Question question = new Question();
        question.setQuestion(buildQuestionText(data));
        OptionUtils.setQuestionOptions(question, data.statements);
        question.setAnswer(data.correctAnswer);
        return question;
    }
}
