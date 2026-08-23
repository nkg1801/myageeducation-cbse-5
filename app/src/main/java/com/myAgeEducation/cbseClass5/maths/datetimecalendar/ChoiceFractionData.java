package com.myAgeEducation.cbseClass5.maths.datetimecalendar;
import com.myAgeEducation.cbseClass5.maths.fractions.FractionData;

public class ChoiceFractionData {
    public FractionData[] fractions = new FractionData[4];
    public int correctIndex;
    public String imageCode;
    public String questionText;
    public String answer;

    public String getCorrectOption()
    {
        return String.valueOf((char)('A' + correctIndex));
    }
}
