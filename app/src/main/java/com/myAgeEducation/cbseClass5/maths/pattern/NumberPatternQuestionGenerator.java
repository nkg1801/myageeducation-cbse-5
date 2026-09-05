package com.myAgeEducation.cbseClass5.maths.pattern;

import com.myAgeEducation.cbseClass5.maths.utils.NumberFormatUtil;
import com.myAgeEducation.cbseClass5.utils.ImageCodeType;
import com.myAgeEducation.cbseClass5.utils.OptionUtils;
import com.myAgeEducation.cbsecommon.Question;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.stream.Collectors;

public class NumberPatternQuestionGenerator
{
    private static final String[] QUESTION_TEXTS =
            {
                    "Which number is missing from this sequence?",
                    "What comes in the blank?",
                    "Find the missing number.",
                    "Which number should come in the blank?",
                    "Complete the pattern:",
                    "Continue the series:"
            };

    private static final String[] HEX_QUESTION_TEXTS =
            {
                    "Find the number that should come in the place of question mark (?) in the pattern given in the picture.",
                    "Which number will replace the question mark (?) in the given number pattern?",
                    "Study the pattern in the picture and find the missing number represented by '?'",
                    "What is the value of '?' in the given picture?"
            };

    private static final Random RANDOM = new Random();

    public static Question generateQuestion()
    {
        int type = RANDOM.nextInt(10);
        if (type < 4) { // 40% chance for old text-based pattern
            NumberPatternQuestionData questionData = generate();
            Question question = new Question();
            question.setQuestion(questionData.questionText);
            OptionUtils.setQuestionOptions(question, questionData.options);
            question.setAnswer(questionData.correctAnswer);
            return question;
        }
        /*else if (type < 6) {
            return generateHexagonHoneycombQuestion();
        } */
        else if (type < 7) {
            return generateHexagonRingQuestion();
        }
        else if (type < 9) {
            return generateHexagonZigZagQuestion();
        }
        else {
            return generateDoubleHexagonHoneycombQuestion();
        }
    }

    private static Question generateHexagonHoneycombQuestion() {
        // Image 1 style: Complementary pairs
        int sum = (RANDOM.nextInt(10) + 1) * 10;
        int center = sum / 2;
        int[] nums = new int[9];
        nums[4] = center; // center "?"

        List<Integer> pairs = new ArrayList<>();
        for (int i = 1; i < center; i++) {
            pairs.add(i);
        }
        Collections.shuffle(pairs);

        // Pairs positions: (0,9), (1,7), (2,6), (3,5) -- relative to positions array in generator
        // positions: 0:Top, 1:UL, 2:UR, 3:L, 4:Center, 5:R, 6:LL, 7:LR, 8:Bottom
        // Pairs in image 1: (Top,Bottom), (UL,LR), (UR,LL), (L,R)
        // Indices: (0,8), (1,7), (2,6), (3,5)
        int[][] pairIndices = {{0, 8}, {1, 7}, {2, 6}, {3, 5}};
        for (int i = 0; i < 4; i++) {
            int val = pairs.get(i);
            nums[pairIndices[i][0]] = val;
            nums[pairIndices[i][1]] = sum - val;
        }

        String numbersStr = Arrays.stream(nums).mapToObj(String::valueOf).collect(Collectors.joining(","));
        String imageCode = String.format("%s_SUBTYPE=HONEYCOMB9_MISSING=4_NUMBERS=%s", ImageCodeType.HEXAGON_PATTERN, numbersStr);

        Question question = new Question();
        question.setQuestion(HEX_QUESTION_TEXTS[RANDOM.nextInt(HEX_QUESTION_TEXTS.length)]);
        question.setImage(imageCode);
        question.setAnswer(String.valueOf(center));

        List<String> options = new ArrayList<>();
        options.add(question.getAnswer());

        Set<Integer> distractors = new LinkedHashSet<>();
        int[] candidates = {center + 1, center - 1, center + 2, center - 2, center + 5, center - 5, center + 10, center - 10};
        for (int c : candidates) {
            if (c > 0 && c != center) distractors.add(c);
            if (distractors.size() >= 3) break;
        }
        int fallback = center + 3;
        while (distractors.size() < 3) {
            if (fallback != center) distractors.add(fallback);
            fallback++;
        }
        for (int d : distractors) options.add(String.valueOf(d));
        Collections.shuffle(options);
        OptionUtils.setQuestionOptions(question, options);

        return question;
    }

    private static Question generateHexagonRingQuestion() {
        // Image 2 style: Multiples or arithmetic series in a ring
        int[] easySteps = {5, 10, 20, 25, 50, 100};
        int step = easySteps[RANDOM.nextInt(easySteps.length)];
        int start = (RANDOM.nextInt(5) + 1) * step;

        int missingIndex = RANDOM.nextInt(6);
        int[] nums = new int[6];
        for (int i = 0; i < 6; i++) {
            nums[i] = start + i * step;
        }

        String numbersStr = Arrays.stream(nums).mapToObj(String::valueOf).collect(Collectors.joining(","));
        String imageCode = String.format("%s_SUBTYPE=HEXRING_MISSING=%d_NUMBERS=%s", ImageCodeType.HEXAGON_PATTERN, missingIndex, numbersStr);

        Question question = new Question();
        question.setQuestion(HEX_QUESTION_TEXTS[RANDOM.nextInt(HEX_QUESTION_TEXTS.length)]);
        question.setImage(imageCode);
        question.setAnswer(String.valueOf(nums[missingIndex]));

        List<String> options = new ArrayList<>();
        int answer = nums[missingIndex];
        options.add(String.valueOf(answer));

        Set<Integer> distractors = new LinkedHashSet<>();
        int[] candidates = {answer + step, answer - step, answer + 2 * step, answer - 2 * step, answer + 1, answer - 1, answer + 10, answer - 10};
        for (int c : candidates) {
            if (c > 0 && c != answer) distractors.add(c);
            if (distractors.size() >= 3) break;
        }
        int fallback = answer + 2;
        while (distractors.size() < 3) {
            if (fallback != answer) distractors.add(fallback);
            fallback++;
        }
        for (int d : distractors) options.add(String.valueOf(d));
        Collections.shuffle(options);
        OptionUtils.setQuestionOptions(question, options);

        return question;
    }

    private static Question generateHexagonZigZagQuestion() {
        // Image 3 & 4 style: Zig-zag AP
        int start = (RANDOM.nextInt(20) + 1) * 5;
        int[] easySteps = {2, 3, 4, 5, 10, 20};
        int step = easySteps[RANDOM.nextInt(easySteps.length)];
        int length = 5;
        int missingIndex = RANDOM.nextInt(length);

        int[] nums = new int[length];
        for (int i = 0; i < length; i++) {
            nums[i] = start + i * step;
        }

        String color = RANDOM.nextBoolean() ? "#FFFF00" : "#D3D3D3"; // Yellow or Grey
        String numbersStr = Arrays.stream(nums).mapToObj(String::valueOf).collect(Collectors.joining(","));
        String imageCode = String.format("%s_SUBTYPE=ZIGZAG_MISSING=%d_NUMBERS=%s_COLOR=%s", ImageCodeType.HEXAGON_PATTERN, missingIndex, numbersStr, color);

        Question question = new Question();
        question.setQuestion(HEX_QUESTION_TEXTS[RANDOM.nextInt(HEX_QUESTION_TEXTS.length)]);
        question.setImage(imageCode);
        question.setAnswer(String.valueOf(nums[missingIndex]));

        List<String> options = new ArrayList<>();
        int answer = nums[missingIndex];
        options.add(String.valueOf(answer));

        Set<Integer> distractors = new LinkedHashSet<>();
        int[] candidates = {answer + step, answer - step, answer + 2 * step, answer - 2 * step, answer + 1, answer - 1, answer + 10, answer - 10};
        for (int c : candidates) {
            if (c > 0 && c != answer) distractors.add(c);
            if (distractors.size() >= 3) break;
        }
        int fallback = answer + 2;
        while (distractors.size() < 3) {
            if (fallback != answer) distractors.add(fallback);
            fallback++;
        }
        for (int d : distractors) options.add(String.valueOf(d));
        Collections.shuffle(options);
        OptionUtils.setQuestionOptions(question, options);

        return question;
    }

    private static Question generateDoubleHexagonHoneycombQuestion() {
        // Image 5 style: Two honeycombs with related patterns
        int factor1 = (RANDOM.nextInt(4) + 1) * 20; // 20, 40, 60, 80
        int factor2 = factor1 / 2;

        int[] nums1 = new int[7];
        for (int i = 0; i < 7; i++) nums1[i] = (i + 1) * factor1;

        int[] nums2 = new int[7];
        for (int i = 0; i < 7; i++) nums2[i] = (i + 1) * factor2;

        String numbers1Str = Arrays.stream(nums1).mapToObj(String::valueOf).collect(Collectors.joining(","));
        String numbers2Str = Arrays.stream(nums2).mapToObj(String::valueOf).collect(Collectors.joining(","));

        // Missing index is always 6 (the center) of the second honeycomb
        String imageCode = String.format("%s_SUBTYPE=DOUBLEHONEYCOMB_NUMBERS1=%s_NUMBERS2=%s_MISSING2=6", ImageCodeType.HEXAGON_PATTERN, numbers1Str, numbers2Str);

        Question question = new Question();
        question.setQuestion(HEX_QUESTION_TEXTS[RANDOM.nextInt(HEX_QUESTION_TEXTS.length)]);
        question.setImage(imageCode);
        question.setAnswer(String.valueOf(nums2[6]));

        List<String> options = new ArrayList<>();
        int answer = nums2[6];
        options.add(String.valueOf(answer));

        Set<Integer> distractors = new LinkedHashSet<>();
        int[] candidates = {answer + factor2, answer - factor2, answer + 2 * factor2, answer - 2 * factor2, answer + 1, answer - 1, answer + 10, answer - 10};
        for (int c : candidates) {
            if (c > 0 && c != answer) distractors.add(c);
            if (distractors.size() >= 3) break;
        }
        int fallback = answer + 2;
        while (distractors.size() < 3) {
            if (fallback != answer) distractors.add(fallback);
            fallback++;
        }
        for (int d : distractors) options.add(String.valueOf(d));
        Collections.shuffle(options);
        OptionUtils.setQuestionOptions(question, options);

        return question;
    }

    private static NumberPatternQuestionData generate()
    {
        // Generate the number pattern
        NumberPatternData data = NumberPatternGenerator.generate();

        // Create question text
        String questionText = QUESTION_TEXTS[RANDOM.nextInt(QUESTION_TEXTS.length)] + "\n\n" + data.getSequenceText();

        // Correct answer
        String correctAnswer = NumberFormatUtil.formatIndianNumber(data.getMissingNumber());

        // Create question data
        NumberPatternQuestionData questionData = new NumberPatternQuestionData(data, questionText, correctAnswer);

        // Generate four options
        questionData.options = generateOptions( questionData);
        return questionData;
    }

    private static String[] generateOptions(NumberPatternQuestionData questionData)
    {
        int correctAnswerVal = questionData.patternData.getMissingNumber();
        int step = questionData.patternData.step;
        Set<Integer> distractors = new LinkedHashSet<>();

        int[] candidates =
                {
                        correctAnswerVal - step,
                        correctAnswerVal + step,
                        correctAnswerVal - (2 * step),
                        correctAnswerVal + (2 * step),
                        correctAnswerVal - 1,
                        correctAnswerVal + 1,
                        correctAnswerVal + 10,
                        correctAnswerVal - 10,
                        correctAnswerVal + 100,
                        correctAnswerVal - 100
                };

        for (int value : candidates)
        {
            if (value > 0 && value != correctAnswerVal)
            {
                distractors.add(value);
            }

            if (distractors.size() >= 3)
            {
                break;
            }
        }

        // Safety fallback
        int extraValue = correctAnswerVal + 2;

        while (distractors.size() < 3)
        {
            if (extraValue > 0 && extraValue != correctAnswerVal)
            {
                distractors.add(extraValue);
            }

            extraValue++;
        }

        // Now there are exactly 4 options
        List<String> options = new ArrayList<>();

        options.add(questionData.correctAnswer);
        
        List<Integer> distractorList = new ArrayList<>(distractors);
        Collections.shuffle(distractorList);
        
        for (int i = 0; i < 3; i++) {
            options.add(NumberFormatUtil.formatIndianNumber(distractorList.get(i)));
        }

        Collections.shuffle(options);

        return options.toArray(new String[0]);
    }
}
