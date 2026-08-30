package com.myAgeEducation.cbseClass5.science;

import com.myAgeEducation.cbseClass5.utils.OptionUtils;
import com.myAgeEducation.cbsecommon.Question;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ScienceQuestionGenerator {
    public static List<Question> getQuestions(int chapter)
    {
        String[][] rawQuestions = FixedQuestionRepository.getFixedQuestions(chapter);
        List<String[]> conceptQuestions = new ArrayList<>(Arrays.asList(rawQuestions));

        Collections.shuffle(conceptQuestions);
        List<String[]> onlyFirstTwenty = conceptQuestions.subList(0, Math.min(20, conceptQuestions.size()));

        List<Question> questions = new ArrayList<>();

        for (String[] conceptQuestion : onlyFirstTwenty) {

            Question question = new Question();

            question.setQuestion(conceptQuestion[0]);
            question.setChapter(chapter);
            question.setChapterName(SCIENCE_CHAPTER_NAMES.get(chapter));
            question.setAnswer(conceptQuestion[1]);
            question.setImage(conceptQuestion[5]);

            List<String> options = new ArrayList<>();

            options.add(conceptQuestion[1]);
            options.add(conceptQuestion[2]);
            if(conceptQuestion[3] != null && !conceptQuestion[3].isEmpty())
            {
                options.add(conceptQuestion[3]);
            }

            if(conceptQuestion[4] != null && !conceptQuestion[4].isEmpty()) {
                options.add(conceptQuestion[4]);
            }

            if(options.size() > 2) {
                Collections.shuffle(options);
            }

            OptionUtils.setQuestionOptions(question, options);
            questions.add(question);
        }

        return questions;
    }

    public static final Map<Integer, String> SCIENCE_CHAPTER_NAMES = new HashMap<>();

    static
    {
        SCIENCE_CHAPTER_NAMES.put(1, "Growing Plants");
        SCIENCE_CHAPTER_NAMES.put(2, "Animal Habitats, Adaptations");
        SCIENCE_CHAPTER_NAMES.put(3, "Skeletal, Nervous System");
        SCIENCE_CHAPTER_NAMES.put(4, "Food and health");
        SCIENCE_CHAPTER_NAMES.put(5, "Safety and first aid");
        SCIENCE_CHAPTER_NAMES.put(6, "Air and Water");
        SCIENCE_CHAPTER_NAMES.put(7, "Earth, Sun and Moon");
        SCIENCE_CHAPTER_NAMES.put(8, "Our Environment");
        SCIENCE_CHAPTER_NAMES.put(9, "Natural Disasters");
        SCIENCE_CHAPTER_NAMES.put(10, "Rocks and Minerals");
        SCIENCE_CHAPTER_NAMES.put(11, "Solids, Liquids, Gases");
        SCIENCE_CHAPTER_NAMES.put(12, "Light and Shadow");
        SCIENCE_CHAPTER_NAMES.put(13, "Force and energy");
        SCIENCE_CHAPTER_NAMES.put(14, "Measurement");
    }
}
