package com.myAgeEducation.cbseClass5.computers;

import com.myAgeEducation.cbseClass5.maths.utils.PersonNameUtil;
import com.myAgeEducation.cbseClass5.utils.OptionUtils;
import com.myAgeEducation.cbsecommon.Question;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ComputerQuestionGenerator {
    public static List<Question> getQuestions(int chapter)
    {
        String[] threeRandomNames = PersonNameUtil.getDifferentNames(3);

        String[][] rawQuestions = FixedComputersQuestionRepository.getFixedQuestions(chapter);
        List<String[]> conceptQuestions = new ArrayList<>(Arrays.asList(rawQuestions));

        Collections.shuffle(conceptQuestions);
        List<String[]> onlyFirstTwenty = conceptQuestions.subList(0, Math.min(20, conceptQuestions.size()));

        List<Question> questions = new ArrayList<>();

        for (String[] conceptQuestion : onlyFirstTwenty) {

            Question question = new Question();
            String questionText = conceptQuestion[0];
            String answer = conceptQuestion[1];
            String option2 = conceptQuestion[2];
            String option3 = conceptQuestion[3];
            String option4 = conceptQuestion[4];
            // if there are 7 tokens, 6th one (5th index) is supportiveText and the last one is image resource
            String supportiveText = (conceptQuestion.length == 7) ? conceptQuestion[5] : null;

            if (questionText != null && questionText.contains("%")) {
                questionText = String.format(questionText, (Object[]) threeRandomNames);
            }
            if (answer != null && answer.contains("%")) {
                answer = String.format(answer, (Object[]) threeRandomNames);
            }
            if (option2 != null && option2.contains("%")) {
                option2 = String.format(option2, (Object[]) threeRandomNames);
            }
            if (option3 != null && option3.contains("%")) {
                option3 = String.format(option3, (Object[]) threeRandomNames);
            }
            if (option4 != null && option4.contains("%")) {
                option4 = String.format(option4, (Object[]) threeRandomNames);
            }
            if (supportiveText != null && supportiveText.contains("%")) {
                supportiveText = String.format(supportiveText, (Object[]) threeRandomNames);
            }

            question.setQuestion(questionText);
            question.setChapter(chapter);
            question.setChapterName(COMPUTER_CHAPTER_NAMES.get(chapter));
            question.setAnswer(answer);

            if((conceptQuestion.length == 6 || conceptQuestion.length == 7))
            {
                if(conceptQuestion[conceptQuestion.length - 1] != null && !conceptQuestion[conceptQuestion.length - 1].isEmpty())
                {
                    question.setImage(conceptQuestion[conceptQuestion.length - 1]);
                }
            }

            if(supportiveText != null && !supportiveText.isEmpty())
            {
                question.setSupportiveText(supportiveText);
            }

            List<String> options = new ArrayList<>();

            options.add(answer);
            options.add(option2);
            if(option3 != null && !option3.isEmpty())
            {
                options.add(option3);
            }

            if(option4 != null && !option4.isEmpty()) {
                options.add(option4);
            }

            OptionUtils.setQuestionOptions(question, options);
            questions.add(question);
        }

        if (chapter == 9) {
            List<Question> generatedQuestions = LogoProgramQuestionGenerator.getQuestions(15);
            for(Question q : generatedQuestions)
            {
                q.setChapter(chapter);
                q.setChapterName(COMPUTER_CHAPTER_NAMES.get(chapter));
                questions.add(q);
            }

            Collections.shuffle(questions);
            // we are keeping max 20 questions per test
            if(questions.size() > 20)
            {
                questions = questions.subList(0, 20);
            }
        }

        return questions;
    }

    public static final Map<Integer, String> COMPUTER_CHAPTER_NAMES = new HashMap<>();

    static
    {
        COMPUTER_CHAPTER_NAMES.put(1, "About a Computer");
        COMPUTER_CHAPTER_NAMES.put(2, "Windows Operating System");
        COMPUTER_CHAPTER_NAMES.put(3, "MS Word");
        COMPUTER_CHAPTER_NAMES.put(4, "Tables in MS Word");
        COMPUTER_CHAPTER_NAMES.put(5, "MS PowerPoint");
        COMPUTER_CHAPTER_NAMES.put(6, "MS Excel");
        COMPUTER_CHAPTER_NAMES.put(7, "Multimedia");
        COMPUTER_CHAPTER_NAMES.put(8, "LOGO - Complex Procedures");
        COMPUTER_CHAPTER_NAMES.put(9, "Advanced LOGO");
        COMPUTER_CHAPTER_NAMES.put(10, "Game Programming in LOGO");
        COMPUTER_CHAPTER_NAMES.put(11, "Scratch");
        COMPUTER_CHAPTER_NAMES.put(12, "Internet");
    }
}
