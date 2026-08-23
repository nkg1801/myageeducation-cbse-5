package com.myAgeEducation.cbseClass5.maths.LineAndAngle;
import static com.google.android.gms.common.util.ArrayUtils.contains;

import com.myAgeEducation.cbseClass5.maths.utils.ImageCodeType;
import com.myAgeEducation.cbseClass5.utils.OptionUtils;
import com.myAgeEducation.cbsecommon.Question;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

public class AngleQuestionGenerator
{
    private static final Random RANDOM = new Random();

    private AngleQuestionGenerator()
    {
        // Prevent object creation
    }

    public static Question generateQuestion()
    {
        AngleQuestionType[] types = AngleQuestionType.values();
        AngleQuestionType type = types[RANDOM.nextInt(types.length)];
        AngleQuestionData data = generateQuestion(type);

        Question question = new Question();
        question.setQuestion(data.getQuestion());
        question.setAnswer(data.getAnswer());
        question.setImage(data.getImageCode());
        OptionUtils.setQuestionOptions(question, data.getOptions());
        return question;
    }

    private static String normalizeQuestionText(String question)
    {
        if (question == null)
        {
            return "";
        }

        return question.trim().replaceAll("\\s+", " ").toLowerCase();
    }

    public static AngleQuestionData generateQuestion(AngleQuestionType type)
    {
        switch (type)
        {
            case IDENTIFY_ANGLE:
                return generateIdentifyAngle();

            case FIND_MEASURE:
                return generateFindMeasure();

            case WHICH_IS_ACUTE:
                return generateWhichIsAcute();

            case WHICH_IS_RIGHT:
                return generateWhichIsRight();

            case WHICH_IS_GREATER:
                return generateWhichIsGreater();

            case SAME_TYPE:
                return generateSameType();

            default:
                throw new IllegalArgumentException("Unsupported angle question type: " + type);
        }
    }

    private static String[] generateAngleNameOptions(String correctAnswer)
    {
        String[] options =
                {
                        "acute angle",
                        "right angle",
                        "obtuse angle",
                        "straight angle"
                };

        if (!contains(options, correctAnswer))
        {
            throw new IllegalArgumentException("Invalid correct answer: " + correctAnswer);
        }

        List<String> shuffled = new ArrayList<>();
        Collections.addAll(shuffled, options);
        Collections.shuffle(shuffled, RANDOM);
        return shuffled.toArray(new String[0]);
    }

    private static AngleQuestionData generateIdentifyAngle()
    {
        AngleKind angleType = generateRandomAngleType();
        int angle = generateAngle(angleType);
        String answer = getAngleName(angleType);
        String[] options = generateAngleNameOptions(answer);

        AngleQuestionData data = new AngleQuestionData(
                "Which angle is shown in the picture below?",
                answer,
                options,
                AngleQuestionType.IDENTIFY_ANGLE,
                angle);
        data.setImageCode(createSingleAngleCode(angle, false));
        return data;
    }

    private static AngleKind generateRandomAngleType()
    {
        AngleKind[] types =
                {
                        AngleKind.ACUTE,
                        AngleKind.RIGHT,
                        AngleKind.OBTUSE,
                        AngleKind.STRAIGHT
                };

        return types[RANDOM.nextInt(types.length)];
    }

    private static int generateAngle(AngleKind type)
    {
        switch (type)
        {
            case ACUTE:
                // 20 to 89 degrees
                return 20 + RANDOM.nextInt(70);

            case RIGHT:
                return 90;

            case OBTUSE:
                // 100 to 169 degrees
                return 100 + RANDOM.nextInt(70);

            case STRAIGHT:
                return 180;

            default:
                throw new IllegalArgumentException("Unsupported angle type: " + type);
        }
    }

    private static AngleQuestionData generateFindMeasure()
    {
        AngleKind type = generateRandomAngleType();
        int angle = generateAngle(type);
        String answer = angle + "°";
        String[] options = generateMeasureOptions(angle);

        AngleQuestionData data = new AngleQuestionData(
                "What is the measure of the angle shown below?",
                answer,
                options,
                AngleQuestionType.FIND_MEASURE,
                angle);
        data.setImageCode(createSingleAngleCode(angle, true));
        return data;
    }

    private static String[] generateMeasureOptions(int correctAngle)
    {
        LinkedHashSet<Integer> values = new LinkedHashSet<>();

        values.add(correctAngle);

        if (correctAngle == 90)
        {
            values.add(80);
            values.add(100);
            values.add(60);
        }
        else if (correctAngle == 180)
        {
            values.add(170);
            values.add(90);
            values.add(160);
        }
        else
        {
            values.add(
                    Math.max(
                            1,
                            correctAngle - 10));

            values.add(
                    correctAngle + 10);

            values.add(
                    correctAngle + 20);
        }

        List<Integer> result =
                new ArrayList<>(values);

        Collections.shuffle(
                result,
                RANDOM);

        String[] options =
                new String[4];

        for (int i = 0; i < 4; i++)
        {
            options[i] =
                    result.get(i) + "°";
        }

        return options;
    }

    private static AngleQuestionData generateWhichIsAcute()
    {
        int correctAngle = 30 + RANDOM.nextInt(50);
        int rightAngle = 90;
        int obtuseAngle = 110 + RANDOM.nextInt(50);
        int straightAngle = 180;

        int[] angles =
                {
                        correctAngle,
                        rightAngle,
                        obtuseAngle,
                        straightAngle
                };

        shuffleIntArray(angles);
        int correctIndex = findAngleIndex(angles, correctAngle);
        String answer = String.valueOf((char) ('A' + correctIndex));

        String[] options =
                {
                        "A",
                        "B",
                        "C",
                        "D"
                };

        AngleQuestionData data = new AngleQuestionData("Which of the following angles is an acute angle?",
                answer,
                options,
                AngleQuestionType.WHICH_IS_ACUTE,
                correctAngle);
        data.setImageCode(createMultipleAnglesCode(angles, false));
        return data;
    }

    private static AngleQuestionData generateWhichIsRight()
    {
        int acuteAngle =
                30 + RANDOM.nextInt(40);

        int obtuseAngle =
                110 + RANDOM.nextInt(40);

        int straightAngle =
                180;

        int[] angles =
                {
                        acuteAngle,
                        90,
                        obtuseAngle,
                        straightAngle
                };

        shuffleIntArray(angles);

        int correctIndex =
                findAngleIndex(
                        angles,
                        90);

        String answer =
                String.valueOf(
                        (char) ('A' + correctIndex));

        String[] options =
                {
                        "A",
                        "B",
                        "C",
                        "D"
                };

        AngleQuestionData data = new AngleQuestionData(
                "Which of the following angles is a right angle?",
                answer,
                options,
                AngleQuestionType.WHICH_IS_RIGHT,
                90);
        data.setImageCode(createMultipleAnglesCode(angles, false));
        return data;
    }

    private static int findAngleIndex(
            int[] angles,
            int value)
    {
        for (int i = 0;
             i < angles.length;
             i++)
        {
            if (angles[i] == value)
            {
                return i;
            }
        }

        throw new IllegalStateException(
                "Angle not found: " + value);
    }

    private static void shuffleIntArray(
            int[] array)
    {
        for (int i = array.length - 1;
             i > 0;
             i--)
        {
            int j =
                    RANDOM.nextInt(i + 1);

            int temp =
                    array[i];

            array[i] =
                    array[j];

            array[j] =
                    temp;
        }
    }

    private static AngleQuestionData generateWhichIsGreater()
    {
        int angleA = 20 + RANDOM.nextInt(70);
        int angleB = 100 + RANDOM.nextInt(70);

        String answer = angleA > angleB ? "A" : "B";

        String[] options =
                {
                        "A",
                        "B",
                        "Both are equal",
                        "Cannot be determined"
                };

        AngleQuestionData data = new AngleQuestionData(
                "Which angle is greater?",
                answer,
                options,
                AngleQuestionType.WHICH_IS_GREATER,
                Math.max(angleA, angleB));
        data.setImageCode(createTwoAnglesCode(angleA, angleB, true));
        return data;
    }

    private static AngleQuestionData generateSameType()
    {
        int[][] pairs = new int[4][2];

        /*
         * Correct pair: both acute.
         */
        pairs[0][0] =
                20 + RANDOM.nextInt(60);

        pairs[0][1] =
                20 + RANDOM.nextInt(60);

        /*
         * Other three pairs contain
         * different angle types.
         */
        pairs[1][0] = 90;
        pairs[1][1] = 180;

        pairs[2][0] = 100 + RANDOM.nextInt(60);
        pairs[2][1] = 20 + RANDOM.nextInt(60);

        pairs[3][0] = 30 + RANDOM.nextInt(50);

        pairs[3][1] = 90;

        shufflePairs(pairs);

        int correctIndex = findSameTypePair(pairs);

        String answer =
                String.valueOf(
                        (char) ('A' + correctIndex));

        String[] options =
                {
                        "A",
                        "B",
                        "C",
                        "D"
                };

        AngleQuestionData data = new AngleQuestionData(
                "Which pair of angles is of the same type?",
                answer,
                options,
                AngleQuestionType.SAME_TYPE,
                0);
        data.setImageCode(createAnglePairsCode(pairs, false));
        return data;
    }


    private static int findSameTypePair(
            int[][] pairs)
    {
        for (int i = 0;
             i < pairs.length;
             i++)
        {
            if (getBasicAngleType(
                    pairs[i][0])
                    == getBasicAngleType(
                    pairs[i][1]))
            {
                return i;
            }
        }

        throw new IllegalStateException("No same-type angle pair found");
    }

    private static AngleKind getBasicAngleType(int angle)
    {
        if (angle < 90)
        {
            return AngleKind.ACUTE;
        }

        if (angle == 90)
        {
            return AngleKind.RIGHT;
        }

        if (angle < 180)
        {
            return AngleKind.OBTUSE;
        }

        return AngleKind.STRAIGHT;
    }

    private static void shufflePairs(int[][] pairs)
    {
        for (int i = pairs.length - 1; i > 0; i--)
        {
            int j = RANDOM.nextInt(i + 1);
            int[] temp = pairs[i];
            pairs[i] = pairs[j];
            pairs[j] = temp;
        }
    }

    private static String getAngleName(AngleKind type)
    {
        switch (type)
        {
            case ACUTE:
                return "acute angle";

            case RIGHT:
                return "right angle";

            case OBTUSE:
                return "obtuse angle";

            case STRAIGHT:
                return "straight angle";

            default:
                throw new IllegalArgumentException("Unsupported angle type: " + type);
        }
    }

    private static String createSingleAngleCode(int angle, boolean showDegree) {
        return ImageCodeType.ANGLE + "_SINGLE_" + angle + "_" + (showDegree ? 1 : 0);
    }

    private static String createTwoAnglesCode(int a, int b, boolean showDegree) {
        return ImageCodeType.ANGLE + "_TWO_" + a + "_" + b + "_" + (showDegree ? 1 : 0);
    }

    private static String createMultipleAnglesCode(int[] angles, boolean showDegree) {
        return ImageCodeType.ANGLE + "_MULTIPLE_" + angles[0] + "_" + angles[1] + "_" + angles[2] + "_" + angles[3] + "_" + (showDegree ? 1 : 0);
    }

    private static String createAnglePairsCode(int[][] pairs, boolean showDegree) {
        return ImageCodeType.ANGLE + "_PAIRS_" + pairs[0][0] + "_" + pairs[0][1] + "_" + pairs[1][0] + "_" + pairs[1][1] + "_" + pairs[2][0] + "_" + pairs[2][1] + "_" + pairs[3][0] + "_" + pairs[3][1] + "_" + (showDegree ? 1 : 0);
    }
}
