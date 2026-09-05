package com.myAgeEducation.cbseClass5.maths.fractions;

import com.myAgeEducation.cbseClass5.utils.ImageCodeType;
import com.myAgeEducation.cbseClass5.utils.OptionUtils;
import com.myAgeEducation.cbsecommon.Question;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class FractionComparisonQuestionGenerator {
    private static final Random RANDOM = new Random();

    public static Question generateQuestion() {
        int type = RANDOM.nextInt(4);
        if (type == 0) {
            return generateLikeDenominatorComparison();
        } else if (type == 1) {
            return generateLikeNumeratorComparison();
        } else if (type == 2) {
            return generateVisualComparison();
        } else {
            return generateGeneralComparison();
        }
    }

    private static Question generateLikeDenominatorComparison() {
        int denominator = 3 + RANDOM.nextInt(17); // Ensure denominator is at least 3
        int n1 = 1 + RANDOM.nextInt(denominator - 1);
        int n2;
        int attempts = 0;
        do {
            n2 = 1 + RANDOM.nextInt(denominator - 1);
            attempts++;
        } while (n1 == n2 && attempts < 20);

        if (n1 == n2) n2 = (n1 % (denominator - 1)) + 1; // Last resort fallback

        String questionText = "Compare the fractions given below using < or > signs:\n\n"
                + n1 + "/" + denominator + " ______ " + n2 + "/" + denominator;

        String correctAnswer = n1 < n2 ? "<" : ">";

        return createQuestion(questionText, correctAnswer);
    }

    private static Question generateLikeNumeratorComparison() {
        int numerator = 1 + RANDOM.nextInt(9);
        int d1 = numerator + 1 + RANDOM.nextInt(10);
        int d2;
        int attempts = 0;
        do {
            d2 = numerator + 1 + RANDOM.nextInt(10);
            attempts++;
        } while (d1 == d2 && attempts < 20);

        if (d1 == d2) d2 = d1 + 1;

        String questionText = "Compare the fractions given below using < or > signs:\n\n"
                + numerator + "/" + d1 + " ______ " + numerator + "/" + d2;

        String correctAnswer = d1 > d2 ? "<" : ">";

        return createQuestion(questionText, correctAnswer);
    }

    private static Question generateGeneralComparison() {
        int n1, d1, n2, d2;
        int attempts = 0;
        do {
            n1 = 1 + RANDOM.nextInt(6);
            d1 = 2 + RANDOM.nextInt(6);
            n2 = 1 + RANDOM.nextInt(6);
            d2 = 2 + RANDOM.nextInt(6);
            attempts++;
        } while (n1 * d2 == n2 * d1 && attempts < 10);

        String questionText = "Compare the fractions given below using < or > signs:\n\n"
                + n1 + "/" + d1 + " ______ " + n2 + "/" + d2;

        String correctAnswer = (n1 * d2 < n2 * d1) ? "<" : ">";

        return createQuestion(questionText, correctAnswer);
    }

    private static Question generateVisualComparison() {
        FractionInfo f1, f2;
        int attempts = 0;
        do {
            f1 = generateRandomFraction();
            f2 = generateRandomFraction();
            attempts++;
        } while (Math.abs(f1.val - f2.val) < 0.001 && attempts < 10);

        int qSubType = RANDOM.nextInt(3);
        String imgCode;
        String questionText;
        String answer;
        String[] options;

        if (qSubType == 0) { // True/False statement
            int opType = 1 + RANDOM.nextInt(2); // 1: <, 2: >
            imgCode = ImageCodeType.FRACTION_COMPARISON + "_" + f1.w + "_" + f1.n + "_" + f1.d + "_" + opType + "_" + f2.w + "_" + f2.n + "_" + f2.d;
            questionText = "Whether the statement below is correct?";
            
            boolean actualCorrect = (opType == 1 && f1.val < f2.val) || (opType == 2 && f1.val > f2.val);
            answer = actualCorrect ? "TRUE" : "FALSE";
            options = new String[]{"TRUE", "FALSE"};
        } else if (qSubType == 1) { // Fill in the blank
            imgCode = ImageCodeType.FRACTION_COMPARISON + "_" + f1.w + "_" + f1.n + "_" + f1.d + "_0_" + f2.w + "_" + f2.n + "_" + f2.d;
            questionText = "Fill in the blanks with > < or =";
            answer = f1.val < f2.val ? "<" : (f1.val > f2.val ? ">" : "=");
            options = new String[]{"<", ">", "=", "None of these"};
        } else { // Which is greater?
            imgCode = ImageCodeType.FRACTION_COMPARISON + "_" + f1.w + "_" + f1.n + "_" + f1.d + "_0_" + f2.w + "_" + f2.n + "_" + f2.d;
            questionText = "Which fraction is greater?";
            
            String s1 = formatFraction(f1);
            String s2 = formatFraction(f2);
            
            if (f1.val > f2.val) {
                answer = s1;
            } else if (f1.val < f2.val) {
                answer = s2;
            } else {
                answer = "Both are equal";
            }
            options = new String[]{s1, s2, "Both are equal", "Cannot say"};
        }

        Question question = new Question();
        question.setQuestion(questionText);
        question.setAnswer(answer);
        question.setImage(imgCode);
        OptionUtils.setQuestionOptions(question, options);
        return question;
    }

    private static class FractionInfo {
        int w, n, d;
        double val;
        FractionInfo(int w, int n, int d) {
            this.w = w; this.n = n; this.d = d;
            this.val = w + (double)n/d;
        }
    }

    private static FractionInfo generateRandomFraction() {
        int type = RANDOM.nextInt(3); // 0: proper, 1: improper, 2: mixed
        int w = 0, n, d;
        if (type == 0) {
            n = 1 + RANDOM.nextInt(9);
            d = n + 1 + RANDOM.nextInt(5);
        } else if (type == 1) {
            n = 5 + RANDOM.nextInt(10);
            d = 2 + RANDOM.nextInt(4);
        } else {
            w = 1 + RANDOM.nextInt(9);
            n = 1 + RANDOM.nextInt(5);
            d = n + 1 + RANDOM.nextInt(5);
        }
        return new FractionInfo(w, n, d);
    }

    private static String formatFraction(FractionInfo f) {
        if (f.w > 0) {
            return f.w + " " + f.n + "/" + f.d;
        }
        return f.n + "/" + f.d;
    }

    private static Question createQuestion(String questionText, String correctAnswer) {
        Question question = new Question();
        question.setQuestion(questionText);
        question.setAnswer(correctAnswer);
        
        String[] options = {"<", ">", "=", "None of these"};
        OptionUtils.setQuestionOptions(question, options);
        return question;
    }
}
