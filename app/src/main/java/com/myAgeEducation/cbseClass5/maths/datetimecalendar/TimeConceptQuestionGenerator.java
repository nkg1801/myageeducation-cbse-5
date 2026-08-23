package com.myAgeEducation.cbseClass5.maths.datetimecalendar;

import com.myAgeEducation.cbseClass5.utils.OptionUtils;
import com.myAgeEducation.cbsecommon.Question;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import java.util.Random;

public class TimeConceptQuestionGenerator {
    private static final Random RANDOM = new Random();

    public static Question generateQuestion() {
        int type = RANDOM.nextInt(4);
        if (type == 0) {
            return generateStaticConceptQuestion();
        } else if (type == 1) {
            return generateConversionQuestion();
        } else if (type == 2) {
            return generateTimeArithmeticQuestion();
        } else {
            return generateTimeStoryQuestion();
        }
    }

    private static Question generateStaticConceptQuestion() {
        String[][] concepts = {
            {"The short hand in a clock is called _____ hand", "hour", "minute", "second", "fast"},
            {"The ______ hand in a clock moves faster", "second", "hour", "minute", "short"},
            {"The minute hand takes one _____ to go around the clock once.", "hour", "minute", "day", "second"},
            {"A leap year has ______ days.", "366", "365", "364", "360"},
            {"There are ______ months in a year.", "12", "10", "11", "13"},
            {"The long hand in a clock is called the _______ hand.", "minute", "hour", "second", "slow"},
            {"12:00 in the night is called _______.", "midnight", "noon", "morning", "evening"},
            {"12:00 in the day is called _______.", "noon", "midnight", "a.m.", "p.m."},
            {"The time from midnight to 12 noon is called _______.", "a.m.", "p.m.", "noon", "midnight"},
            {"The time from 12 noon to midnight is called _______.", "p.m.", "a.m.", "noon", "morning"}
        };
        int idx = RANDOM.nextInt(concepts.length);
        String[] item = concepts[idx];
        String questionText = item[0];
        String correctAnswer = item[1];
        List<String> options = new ArrayList<>(Arrays.asList(item[1], item[2], item[3], item[4]));
        Collections.shuffle(options);

        Question question = new Question();
        question.setQuestion(questionText);
        question.setAnswer(correctAnswer);
        OptionUtils.setQuestionOptions(question, options.toArray(new String[0]));
        return question;
    }

    private static Question generateConversionQuestion() {
        int subType = RANDOM.nextInt(3);
        String questionText;
        String correctAnswer;
        List<String> options = new ArrayList<>();

        if (subType == 0) { // Hours and half to minutes
            int hours = RANDOM.nextInt(5) + 1;
            boolean hasHalf = RANDOM.nextBoolean();
            int totalMinutes = hours * 60 + (hasHalf ? 30 : 0);
            questionText = hours + (hasHalf ? " and half" : "") + " hour = _______ minutes";
            correctAnswer = String.valueOf(totalMinutes);
            options.add(correctAnswer);
            options.add(String.valueOf(totalMinutes + 30));
            options.add(String.valueOf(totalMinutes - 30));
            options.add(String.valueOf(hours * 60));
        } else if (subType == 1) { // Minutes to seconds
            int minutes = (RANDOM.nextInt(10) + 1) * 5;
            int totalSeconds = minutes * 60;
            questionText = minutes + " minutes = ______ seconds";
            correctAnswer = String.valueOf(totalSeconds);
            options.add(correctAnswer);
            options.add(String.valueOf(totalSeconds + 60));
            options.add(String.valueOf(totalSeconds - 60));
            options.add(String.valueOf(minutes * 100));
        } else { // Days to hours
            int days = RANDOM.nextInt(5) + 1;
            int totalHours = days * 24;
            questionText = days + " days = ______ hours";
            correctAnswer = String.valueOf(totalHours);
            options.add(correctAnswer);
            options.add(String.valueOf(totalHours + 12));
            options.add(String.valueOf(totalHours - 12));
            options.add(String.valueOf(days * 12));
        }

        Collections.shuffle(options);
        Question question = new Question();
        question.setQuestion(questionText);
        question.setAnswer(correctAnswer);
        OptionUtils.setQuestionOptions(question, options.toArray(new String[0]));
        return question;
    }

    private static Question generateTimeArithmeticQuestion() {
        int hoursBefore = RANDOM.nextInt(5) + 1;
        int targetHour = 12 - hoursBefore;
        String questionText = String.format(Locale.US, "%d hours before 12 noon is %d:00 _____", hoursBefore, targetHour);
        String correctAnswer = "a.m.";
        List<String> options = new ArrayList<>(Arrays.asList("a.m.", "p.m.", "noon", "midnight"));
        Collections.shuffle(options);

        Question question = new Question();
        question.setQuestion(questionText);
        question.setAnswer(correctAnswer);
        OptionUtils.setQuestionOptions(question, options.toArray(new String[0]));
        return question;
    }

    private static Question generateTimeStoryQuestion() {
        int subType = RANDOM.nextInt(3);
        if (subType == 0) { // Duration calculation (Play)
            int startHour = 5 + RANDOM.nextInt(3); // 5, 6, 7
            int startMin = (RANDOM.nextInt(4)) * 15; // 0, 15, 30, 45

            int durationHour = 1 + RANDOM.nextInt(3); // 1, 2, 3
            int durationMin = (RANDOM.nextInt(4)) * 15; // 0, 15, 30, 45
            if (durationHour == 1 && durationMin == 0) durationMin = 30; // Min 1.5h

            int endHour = startHour + durationHour;
            int endMin = startMin + durationMin;
            if (endMin >= 60) {
                endMin -= 60;
                endHour += 1;
            }

            String startTimeStr = String.format(Locale.US, "%d:%02d pm", startHour, startMin);
            String endTimeStr = String.format(Locale.US, "%d:%02d pm", endHour, endMin);

            String questionText = String.format(Locale.US, "A play that started at %s got over at %s. How long was the play?", startTimeStr, endTimeStr);
            String correctAnswer = durationHour + " hours " + durationMin + " minutes";
            if (durationMin == 0) correctAnswer = durationHour + " hours";

            List<String> options = new ArrayList<>();
            options.add(correctAnswer);
            options.add((durationHour + 1) + " hours " + durationMin + " minutes");
            options.add(durationHour + " hours " + (durationMin == 0 ? 30 : 0) + " minutes");
            options.add((durationHour - 1 > 0 ? durationHour - 1 : durationHour + 2) + " hours " + durationMin + " minutes");

            Collections.shuffle(options);
            Question question = new Question();
            question.setQuestion(questionText);
            question.setAnswer(correctAnswer);
            OptionUtils.setQuestionOptions(question, options.toArray(new String[0]));
            return question;

        } else if (subType == 1) { // End time calculation (Play)
            int startHour = 4 + RANDOM.nextInt(3); // 4, 5, 6
            int startMin = (RANDOM.nextInt(4)) * 15; // 0, 15, 30, 45

            int durationHour = 1 + RANDOM.nextInt(3); // 1, 2, 3
            int durationMin = (RANDOM.nextInt(4)) * 15; // 0, 15, 30, 45
            if (durationHour == 1 && durationMin == 0) durationMin = 30;

            int endHour = startHour + durationHour;
            int endMin = startMin + durationMin;
            if (endMin >= 60) {
                endMin -= 60;
                endHour += 1;
            }

            String startTimeStr = String.format(Locale.US, "%d:%02d pm", startHour, startMin);
            String durationStr = durationHour + " hours " + durationMin + " minutes";
            if (durationMin == 0) durationStr = durationHour + " hours";

            String questionText = String.format(Locale.US, "A play that started at %s was %s long. When did it get over?", startTimeStr, durationStr);
            String correctAnswer = String.format(Locale.US, "%d:%02d pm", endHour, endMin);

            List<String> options = new ArrayList<>();
            options.add(correctAnswer);
            options.add(String.format(Locale.US, "%d:%02d pm", endHour + 1, endMin));
            options.add(String.format(Locale.US, "%d:%02d pm", endHour, (endMin + 30) % 60));
            options.add(String.format(Locale.US, "%d:%02d pm", endHour - 1, endMin));

            Collections.shuffle(options);
            Question question = new Question();
            question.setQuestion(questionText);
            question.setAnswer(correctAnswer);
            OptionUtils.setQuestionOptions(question, options.toArray(new String[0]));
            return question;

        } else { // Duration calculation (School)
            int startHour = 7 + RANDOM.nextInt(2); // 7, 8
            int startMin = 30 + RANDOM.nextInt(25); // 30-54

            int durationMin = 20 + RANDOM.nextInt(30); // 20-49 minutes

            int endHour = startHour;
            int endMin = startMin + durationMin;
            if (endMin >= 60) {
                endMin -= 60;
                endHour += 1;
            }

            String startTimeStr = String.format(Locale.US, "%d:%02d am", startHour, startMin);
            String endTimeStr = String.format(Locale.US, "%d:%02d am", endHour, endMin);

            String questionText = String.format(Locale.US, "A boy started for school at %s and reached at %s. How long did he take to reach his school?", startTimeStr, endTimeStr);
            String correctAnswer = durationMin + " minutes";

            List<String> options = new ArrayList<>();
            options.add(correctAnswer);
            options.add((durationMin + 10) + " minutes");
            options.add((durationMin - 5) + " minutes");
            options.add((durationMin + 5) + " minutes");

            Collections.shuffle(options);
            Question question = new Question();
            question.setQuestion(questionText);
            question.setAnswer(correctAnswer);
            OptionUtils.setQuestionOptions(question, options.toArray(new String[0]));
            return question;
        }
    }
}
