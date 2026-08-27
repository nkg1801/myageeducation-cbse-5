package com.myAgeEducation.cbseClass5.science;

import com.myAgeEducation.cbseClass5.utils.OptionUtils;
import com.myAgeEducation.cbsecommon.Question;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Dictionary;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

public class ScienceQuestionGenerator {
    public static List<Question> getQuestions(int chapter)
    {
        List<ConceptQuestion> conceptQuestions = FixedQuestionRepository.getFixedQuestions(chapter);

        Collections.shuffle(conceptQuestions);
        List<ConceptQuestion> onlyFirstTwenty = conceptQuestions.subList(0, Math.min(20, conceptQuestions.size()));
        Collections.shuffle(onlyFirstTwenty);

        List<Question> questions = new ArrayList<>();

        for (ConceptQuestion conceptQuestion : onlyFirstTwenty) {

            Question question = new Question();

            question.setQuestion(conceptQuestion.getQuestion());
            question.setChapter(chapter);
            question.setChapterName(SCIENCE_CHAPTER_NAMES.get(chapter));
            question.setAnswer(conceptQuestion.getAnswer());
            question.setImage(conceptQuestion.getImageCode());

            List<String> options = new ArrayList<>();

            options.add(conceptQuestion.getAnswer());
            options.add(conceptQuestion.getOption1());
            if(!conceptQuestion.getOption2().isEmpty())
            {
                options.add(conceptQuestion.getOption2());
            }

            if(!conceptQuestion.getOption3().isEmpty()) {
                options.add(conceptQuestion.getOption3());
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
