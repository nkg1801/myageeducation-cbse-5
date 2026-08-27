package com.myAgeEducation.cbseClass5.science;

public class ConceptQuestion
{
    private final String question;
    private final String answer;
    private final String option1;
    private final String option2;
    private final String option3;
    private final String imageCode;

    public ConceptQuestion(
            String question,
            String answer,
            String option1,
            String option2,
            String option3,
            String imageCode)
    {
        this.question = question;
        this.answer = answer;
        this.option1 = option1;
        this.option2 = option2;
        this.option3 = option3;
        this.imageCode = imageCode;
    }

    public String getQuestion()
    {
        return question;
    }

    public String getAnswer()
    {
        return answer;
    }

    public String getOption1()
    {
        return option1;
    }

    public String getOption2()
    {
        return option2;
    }

    public String getOption3()
    {
        return option3;
    }

    public String getImageCode()
    {
        return imageCode;
    }
}