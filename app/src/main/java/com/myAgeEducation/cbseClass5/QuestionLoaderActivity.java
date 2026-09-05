package com.myAgeEducation.cbseClass5;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.util.Size;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.myAgeEducation.cbseClass5.maths.LineAndAngle.AngleQuestionGenerator;
import com.myAgeEducation.cbseClass5.maths.LineAndAngle.LineAndAngleQuestionGenerator;
import com.myAgeEducation.cbseClass5.maths.additions.AdditionQuestionGenerator;
import com.myAgeEducation.cbseClass5.maths.additions.AdditionStoryQuestionGenerator;
import com.myAgeEducation.cbseClass5.maths.additions.AdditionSubtractionRelationshipGenerator;
import com.myAgeEducation.cbseClass5.maths.additions.MixedAdditionSubtractionStoryQuestionGenerator;
import com.myAgeEducation.cbseClass5.maths.average.AverageQuestionGenerator;
import com.myAgeEducation.cbseClass5.maths.charts.BarChartQuestionGenerator;
import com.myAgeEducation.cbseClass5.maths.circlegraph.CircleGraphQuestionGenerator;
import com.myAgeEducation.cbseClass5.maths.datahandling.DataHandlingConceptQuestionGenerator;
import com.myAgeEducation.cbseClass5.maths.datetimecalendar.CalendarQuestionGenerator;
import com.myAgeEducation.cbseClass5.maths.datetimecalendar.ClockQuestionGenerator;
import com.myAgeEducation.cbseClass5.maths.datetimecalendar.TimeConceptQuestionGenerator;
import com.myAgeEducation.cbseClass5.maths.decimals.DecimalArithmeticQuestionGenerator;
import com.myAgeEducation.cbseClass5.maths.decimals.DecimalGridQuestionGenerator;
import com.myAgeEducation.cbseClass5.maths.decimals.DecimalImageQuestionGenerator;
import com.myAgeEducation.cbseClass5.maths.decimals.DecimalQuestionGenerator;
import com.myAgeEducation.cbseClass5.maths.divisions.facts.DivisionFactQuestionGenerator;
import com.myAgeEducation.cbseClass5.maths.divisions.facts.DivisionPictureQuestionGenerator;
import com.myAgeEducation.cbseClass5.maths.divisions.story.DivisionStoryQuestionGenerator;
import com.myAgeEducation.cbseClass5.maths.factors.FactorQuestionGenerator;
import com.myAgeEducation.cbseClass5.maths.fractions.EquivalentFractionQuestionGenerator;
import com.myAgeEducation.cbseClass5.maths.fractions.FractionAgeQuestionGenerator;
import com.myAgeEducation.cbseClass5.maths.fractions.FractionComparisonQuestionGenerator;
import com.myAgeEducation.cbseClass5.maths.fractions.FractionConceptQuestionGenerator;
import com.myAgeEducation.cbseClass5.maths.fractions.FractionOfMeasurementQuestionGenerator;
import com.myAgeEducation.cbseClass5.maths.fractions.FractionOfNumberQuestionGenerator;
import com.myAgeEducation.cbseClass5.maths.fractions.FractionQuestionGenerator;
import com.myAgeEducation.cbseClass5.maths.fractions.FractionSeriesQuestionGenerator;
import com.myAgeEducation.cbseClass5.maths.fractions.FractionStoryQuestionGenerator;
import com.myAgeEducation.cbseClass5.maths.fractions.FractionTimeStoryQuestionGenerator;
import com.myAgeEducation.cbseClass5.maths.fractions.FractionTrueFalseQuestionGenerator;
import com.myAgeEducation.cbseClass5.maths.fractions.FractionTypes;
import com.myAgeEducation.cbseClass5.maths.mappingskills.DirectionDistanceQuestionGenerator;
import com.myAgeEducation.cbseClass5.maths.mappingskills.MappingSkillConceptQuestionGenerator;
import com.myAgeEducation.cbseClass5.maths.mappingskills.MetroMapQuestionGenerator;
import com.myAgeEducation.cbseClass5.maths.mappingskills.NeighborhoodMapQuestionGenerator;
import com.myAgeEducation.cbseClass5.maths.mappingskills.ZooMapQuestionGenerator;
import com.myAgeEducation.cbseClass5.maths.measurement.MeasurementQuestionGenerator;
import com.myAgeEducation.cbseClass5.maths.multiples.MultipleQuestionGenerator;
import com.myAgeEducation.cbseClass5.maths.multiplication.MultiplicationQuestionGenerator;
import com.myAgeEducation.cbseClass5.maths.multiplication.MultiplicationStoryQuestionGenerator;
import com.myAgeEducation.cbseClass5.maths.pattern.NumberPatternQuestionGenerator;
import com.myAgeEducation.cbseClass5.maths.pattern.NumberSeriesQuestionGenerator;
import com.myAgeEducation.cbseClass5.maths.pattern.PatternSequenceQuestionGenerator;
import com.myAgeEducation.cbseClass5.maths.perimeterarea.PerimeterAreaQuestionGenerator;
import com.myAgeEducation.cbseClass5.maths.pictograph.PictographQuestionGenerator;
import com.myAgeEducation.cbseClass5.maths.placevalue.arrangedigits.ArrangeDigitsQuestionGenerator;
import com.myAgeEducation.cbseClass5.maths.placevalue.arrangenumbers.ArrangeNumbersQuestionGenerator;
import com.myAgeEducation.cbseClass5.maths.placevalue.digitplace.DigitAtPlaceQuestionGenerator;
import com.myAgeEducation.cbseClass5.maths.placevalue.digitplace.DigitPlaceValueQuestionGenerator;
import com.myAgeEducation.cbseClass5.maths.placevalue.greatestsmallest.GreatestSmallestQuestionGenerator;
import com.myAgeEducation.cbseClass5.maths.placevalue.numbercomparison.ComparisonSymbolQuestionGenerator;
import com.myAgeEducation.cbseClass5.maths.placevalue.numbercomparison.NumberComparisonQuestionGenerator;
import com.myAgeEducation.cbseClass5.maths.placevalue.numberorder.NumberOrderQuestionGenerator;
import com.myAgeEducation.cbseClass5.maths.placevalue.numberword.NumberWordsQuestionGenerator;
import com.myAgeEducation.cbseClass5.maths.placevalue.palindromes.PalindromeNumberQuestionGenerator;
import com.myAgeEducation.cbseClass5.maths.placevalue.romannumerals.RomanNumeralsQuestionGenerator;
import com.myAgeEducation.cbseClass5.maths.placevalue.rounding.RoundingQuestionGenerator;
import com.myAgeEducation.cbseClass5.maths.placevalue.standardform.StandardFormQuestionGenerator;
import com.myAgeEducation.cbseClass5.maths.placevalue.successorpredecessor.SuccessorPredecessorQuestionGenerator;
import com.myAgeEducation.cbseClass5.maths.shapes.ShapesQuestionGenerator;
import com.myAgeEducation.cbseClass5.maths.subtractions.SubtractionFactQuestionGenerator;
import com.myAgeEducation.cbseClass5.maths.subtractions.SubtractionStoryQuestionGenerator;
import com.myAgeEducation.cbseClass5.maths.symmetry.SymmetryQuestionGenerator;
import com.myAgeEducation.cbseClass5.maths.tabularquestions.TableQuestionGenerator;
import com.myAgeEducation.cbsecommon.Question;

import java.util.Collections;
import java.util.List;
import java.util.Random;

public class QuestionLoaderActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.question_loader);
        setHeaderImage();
        Util.allQuestions.clear();
        
        new Thread(() -> {
            try {
                long startTime = System.currentTimeMillis();
                addGeneratedQuestionsForMaths();
                long endTime = System.currentTimeMillis();
                long duration = endTime - startTime;
                android.util.Log.d("QuestionLoader", "Total loading time: " + duration + "ms");

                // Ensure loader stays for at least 3 seconds
                if (duration < 2000) {
                    try {
                        Thread.sleep(2000 - duration);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            } catch (Exception e) {
                android.util.Log.e("QuestionLoader", "Error generating questions", e);
            } finally {
                runOnUiThread(() -> openChapters("set1"));
            }
        }).start();
    }

    public void openChapters(String questionSet)
    {
        Intent chapterIntent = new Intent();
        chapterIntent.setClassName(Util.PACKAGE_NAME, Util.PACKAGE_NAME + ".Chapters");
        chapterIntent.putExtra("question_set", questionSet);
        startActivity(chapterIntent);
        finish();
    }

    private void updateLoadingText(String text) {
        runOnUiThread(() -> {
            android.widget.TextView textView = findViewById(R.id.progressMessage);
            if (textView != null) {
                textView.setText(text);
            }
        });
    }

    private void addGeneratedQuestionsForMaths()
    {
        long start;
        
        start = System.currentTimeMillis();
        updateLoadingText("Loading questions for Chapter #1");
        addQuestionsForChapterOne();
        android.util.Log.d("QuestionLoader", "Chapter 1 took: " + (System.currentTimeMillis() - start) + "ms");

        updateLoadingText("Loading questions for Chapter #2");
        start = System.currentTimeMillis();
        addQuestionsForChapterTwo();
        android.util.Log.d("QuestionLoader", "Chapter 2 took: " + (System.currentTimeMillis() - start) + "ms");

        updateLoadingText("Loading questions for Chapter #3");
        start = System.currentTimeMillis();
        addQuestionsForChapterThree();
        android.util.Log.d("QuestionLoader", "Chapter 3 took: " + (System.currentTimeMillis() - start) + "ms");

        updateLoadingText("Loading questions for Chapter #4");
        start = System.currentTimeMillis();
        addQuestionsForChapterFour();
        android.util.Log.d("QuestionLoader", "Chapter 4 took: " + (System.currentTimeMillis() - start) + "ms");

        updateLoadingText("Loading questions for Chapter #5");
        start = System.currentTimeMillis();
        addQuestionsForChapterFive();
        android.util.Log.d("QuestionLoader", "Chapter 5 took: " + (System.currentTimeMillis() - start) + "ms");

        updateLoadingText("Loading questions for Chapter #6");
        start = System.currentTimeMillis();
        addQuestionsForChapterSix();
        android.util.Log.d("QuestionLoader", "Chapter 6 took: " + (System.currentTimeMillis() - start) + "ms");

        updateLoadingText("Loading questions for Chapter #7");
        start = System.currentTimeMillis();
        addQuestionsForChapterSeven();
        android.util.Log.d("QuestionLoader", "Chapter 7 took: " + (System.currentTimeMillis() - start) + "ms");

        updateLoadingText("Loading questions for Chapter #8");
        start = System.currentTimeMillis();
        addQuestionsForChapterEight();
        android.util.Log.d("QuestionLoader", "Chapter 8 took: " + (System.currentTimeMillis() - start) + "ms");

        updateLoadingText("Loading questions for Chapter #9");
        start = System.currentTimeMillis();
        addQuestionsForChapterNine();
        android.util.Log.d("QuestionLoader", "Chapter 9 took: " + (System.currentTimeMillis() - start) + "ms");

        updateLoadingText("Loading questions for Chapter #10");
        start = System.currentTimeMillis();
        addQuestionsForChapterTen();
        android.util.Log.d("QuestionLoader", "Chapter 10 took: " + (System.currentTimeMillis() - start) + "ms");

        updateLoadingText("Loading questions for Chapter #11");
        start = System.currentTimeMillis();
        addQuestionsForChapterEleven();
        android.util.Log.d("QuestionLoader", "Chapter 11 took: " + (System.currentTimeMillis() - start) + "ms");

        updateLoadingText("Loading questions for Chapter #12");
        start = System.currentTimeMillis();
        addQuestionsForChapterTwelve();
        android.util.Log.d("QuestionLoader", "Chapter 12 took: " + (System.currentTimeMillis() - start) + "ms");

        updateLoadingText("Loading questions for Chapter #13");
        start = System.currentTimeMillis();
        addQuestionsForChapterThirteen();
        android.util.Log.d("QuestionLoader", "Chapter 13 took: " + (System.currentTimeMillis() - start) + "ms");
        updateLoadingText("Generating questions");

        addQuestionsForChapterFourteen();
        addQuestionsForChapterFifteen();
        addQuestionsForChapterSixteen();
    }


    private void addQuestionsForChapterOne()
    {
        int chapterNumber = 1;
        String chapterName = "Place Value";
        //Util.allQuestions.removeIf(question -> question.getChapter() == chapterNumber);
        final Random RANDOM = new Random();
        int randomNumber;

        Question question;

        for(int i = 0; i < 20; i++)
        {
            randomNumber = RANDOM.nextInt(16);

            switch(randomNumber)
            {
                case 0:
                    //checked
                    question = ArrangeDigitsQuestionGenerator.generateQuestion();
                    break;

                case 1:
                    //checked
                    question = ArrangeNumbersQuestionGenerator.generateQuestion();
                    break;

                case 2:
                    //checked
                    question = NumberComparisonQuestionGenerator.generateQuestion();
                    break;

                case 3:
                    //checked
                    question = ComparisonSymbolQuestionGenerator.generateQuestion();
                    break;

                case 4:
                    //checked
                    question = DigitPlaceValueQuestionGenerator.generateQuestion();
                    break;

                case 5:
                    //checked
                    question = GreatestSmallestQuestionGenerator.generateQuestion();
                    break;

                case 6:
                    question = SuccessorPredecessorQuestionGenerator.generateQuestion();
                    break;

                case 7:
                    //checked
                    question = NumberOrderQuestionGenerator.generateQuestion();
                    break;

                case 8:
                    //checked
                    question = StandardFormQuestionGenerator.generateQuestion();
                    break;

                case 9:
                    question = RomanNumeralsQuestionGenerator.generateQuestion();
                    break;

                case 10:
                    question = DigitAtPlaceQuestionGenerator.generateQuestion();
                    break;

                case 11:
                    question = NumberSeriesQuestionGenerator.generateQuestion();
                    break;

                case 12:
                    question = PatternSequenceQuestionGenerator.generateQuestion();
                    break;

                case 13:
                    //checked
                    question = RoundingQuestionGenerator.generateQuestion();
                    break;

                case 14:
                    question = PalindromeNumberQuestionGenerator.generateQuestion();
                    break;

                default:
                    //checked
                    question = NumberWordsQuestionGenerator.generateQuestion();
            }
            //question = MissingPlaceValueQuestionGenerator.generateQuestion();
            //question = RoundingQuestionGenerator.generateQuestion();
            question.setChapter(chapterNumber);
            question.setChapterName(chapterName);
            Util.allQuestions.add(question);
        }
    }

    private void addQuestionsForChapterTwo()
    {
        int chapterNumber = 2;
        String chapterName = "Addition and Subtraction";
        //Util.allQuestions.removeIf(question -> question.getChapter() == chapterNumber);
        final Random RANDOM = new Random();
        int randomNumber;

        Question question;// = new Question();

        for(int i = 0; i < 20; i++) {
            randomNumber = RANDOM.nextInt(6);

            switch(randomNumber)
            {
                case 0:
                    question = AdditionStoryQuestionGenerator.generateQuestion();
                    break;

                case 1:
                    question = AdditionQuestionGenerator.generateQuestion();
                    break;

                case 2:
                    question = SubtractionFactQuestionGenerator.generateQuestion();
                    break;

                case 3:
                    question = MixedAdditionSubtractionStoryQuestionGenerator.generateQuestion();
                    break;

                case 4:
                    question = AdditionSubtractionRelationshipGenerator.generateQuestion();
                    break;

                default:
                    question = SubtractionStoryQuestionGenerator.generateQuestion();
            }

            question.setChapter(chapterNumber);
            question.setChapterName(chapterName);
            Util.allQuestions.add(question);
        }
    }

    private void addQuestionsForChapterThree()
    {
        int chapterNumber = 3;
        String chapterName = "Multiplication and Division";
        //Util.allQuestions.removeIf(question -> question.getChapter() == chapterNumber);
        final Random RANDOM = new Random();
        int randomNumber;
        Question question;
        for(int i = 0; i < 20; i++) {
            randomNumber = RANDOM.nextInt(100);
            if(randomNumber < 25)
            {
                question = MultiplicationStoryQuestionGenerator.generateQuestion();
            }
            else if(randomNumber < 50)
            {
                question = DivisionStoryQuestionGenerator.generateQuestion();
            }
            else if(randomNumber < 75)
            {
                question = AverageQuestionGenerator.generateQuestion();
            }
            else if(randomNumber < 85)
            {
                question = MultiplicationQuestionGenerator.generateQuestion();
            }
            else if(randomNumber < 95)
            {
                question = DivisionFactQuestionGenerator.generateQuestion();
            }
            else
            {
                question = DivisionPictureQuestionGenerator.generateQuestion();
            }

            question.setChapter(chapterNumber);
            question.setChapterName(chapterName);
            Util.allQuestions.add(question);
        }
    }

    private void addQuestionsForChapterFour()
    {
        int chapterNumber = 4;
        String chapterName = "Factors";
        //Util.allQuestions.removeIf(question -> question.getChapter() == chapterNumber);
        Question question;
        for(int i = 0; i < 20; i++) {
            question = FactorQuestionGenerator.generateQuestion();
            question.setChapter(chapterNumber);
            question.setChapterName(chapterName);
            Util.allQuestions.add(question);
        }
    }

    private void addQuestionsForChapterFive()
    {
        int chapterNumber = 5;
        String chapterName = "Multiples";
        //Util.allQuestions.removeIf(question -> question.getChapter() == chapterNumber);
        Question question;
        for(int i = 0; i < 20; i++) {
            question = MultipleQuestionGenerator.generateQuestion();
            question.setChapter(chapterNumber);
            question.setChapterName(chapterName);
            Util.allQuestions.add(question);
        }
    }

    private void addQuestionsForChapterSix()
    {
        int chapterNumber = 6;
        String chapterName = "Fractions";
        //Util.allQuestions.removeIf(question -> question.getChapter() == chapterNumber);
        Random RANDOM = new Random();
        Question question;

        for(int i = 0; i < 20; i++) {
            FractionTypes[] types = FractionTypes.values();
            FractionTypes type = types[RANDOM.nextInt(types.length)];

            switch(type)
            {
                case FRACTION_SERIES:
                    question = FractionSeriesQuestionGenerator.generateQuestion();
                    break;

                case STORY_TYPE:
                    question = FractionStoryQuestionGenerator.generateRemainingQuestion();
                    break;

                case FRACTION_WITH_AGE:
                    question = FractionAgeQuestionGenerator.generateQuestion();
                    break;

                case FRACTION_OF_NUMBER:
                    question = FractionOfNumberQuestionGenerator.generateQuestion();
                    break;

                case FRACTION_OF_MEASUREMENT_DATA:
                    question = FractionOfMeasurementQuestionGenerator.generateQuestion();
                    break;

                case FRACTION_TIME_STORY:
                    question = FractionTimeStoryQuestionGenerator.generateQuestion();
                    break;

                case FRACTION_TRUE_FALSE:
                    question = FractionTrueFalseQuestionGenerator.generateQuestion();
                    break;

                case FRACTION_CONCEPTS:
                    question = FractionConceptQuestionGenerator.generateQuestion();
                    break;

                case EQUIVALENT_FRACTIONS:
                    //checked
                    question = EquivalentFractionQuestionGenerator.generateQuestion();
                    break;

                case FRACTION_COMPARISON:
                    question = FractionComparisonQuestionGenerator.generateQuestion();
                    break;

                default:
                    question = FractionQuestionGenerator.generateQuestion();
            }
            question.setChapter(chapterNumber);
            question.setChapterName(chapterName);
            Util.allQuestions.add(question);
        }
    }

    private void addQuestionsForChapterSeven()
    {
        int chapterNumber = 7;
        String chapterName = "Decimals";
        //Util.allQuestions.removeIf(question -> question.getChapter() == chapterNumber);
        Question question;
        Random RANDOM = new Random();

        for(int i = 0; i < 20; i++) {
            int randomNumber = RANDOM.nextInt(100);

            if(randomNumber < 35) // 40%
            {
                question = DecimalQuestionGenerator.generateQuestion();
            }
            else if(randomNumber < 70)
            {
                question = DecimalImageQuestionGenerator.generateQuestion();
            }
            else {
                question = DecimalGridQuestionGenerator.generateQuestion();
            }

            question.setChapter(chapterNumber);
            question.setChapterName(chapterName);
            Util.allQuestions.add(question);
        }
    }

    private void addQuestionsForChapterEight()
    {
        int chapterNumber = 8;
        String chapterName = "More about decimals";
        //Util.allQuestions.removeIf(question -> question.getChapter() == chapterNumber);

        for(int i = 0; i < 20; i++) {
            Question question = DecimalArithmeticQuestionGenerator.generateQuestion();
            question.setChapter(chapterNumber);
            question.setChapterName(chapterName);
            Util.allQuestions.add(question);
        }
    }

    private void addQuestionsForChapterNine()
    {
        int chapterNumber = 9;
        String chapterName = "Shapes, Patterns and Nets";
        //Util.allQuestions.removeIf(question -> question.getChapter() == chapterNumber);
        final Random RANDOM = new Random();

        for(int i = 0; i < 20; i++) {
            Question question;
            int type = RANDOM.nextInt(100);
            if (type < 30) {
                question = ShapesQuestionGenerator.generateQuestion();
            } else if (type < 60) {
                question = NumberPatternQuestionGenerator.generateQuestion();
            } else if (type < 80) {
                question = PatternSequenceQuestionGenerator.generateQuestion();
            } else {
                question = NumberSeriesQuestionGenerator.generateQuestion();
            }

            question.setChapter(chapterNumber);
            question.setChapterName(chapterName);
            Util.allQuestions.add(question);
        }
    }

    private void addQuestionsForChapterTen()
    {
        int chapterNumber = 10;
        String chapterName = "Geometry Basics";
        //Util.allQuestions.removeIf(question -> question.getChapter() == chapterNumber);
        Question question;
        final Random RANDOM = new Random();

        for(int i = 0; i < 20; i++) {
            if(RANDOM.nextBoolean()) {
                question = LineAndAngleQuestionGenerator.generateQuestion();
            }
            else {
                question = AngleQuestionGenerator.generateQuestion();
            }

            question.setChapter(chapterNumber);
            question.setChapterName(chapterName);
            Util.allQuestions.add(question);
        }
    }

    private void addQuestionsForChapterEleven()
    {
        int chapterNumber = 11;
        String chapterName = "Measurement";
        //Util.allQuestions.removeIf(question -> question.getChapter() == chapterNumber);

        for(int i = 0; i < 20; i++) {
            Question question = MeasurementQuestionGenerator.generateQuestion();
            question.setChapter(chapterNumber);
            question.setChapterName(chapterName);
            Util.allQuestions.add(question);
        }
    }

    private void addQuestionsForChapterTwelve()
    {
        int chapterNumber = 12;
        String chapterName = "Perimeter, Area and Volume";
        //Util.allQuestions.removeIf(question -> question.getChapter() == chapterNumber);

        for(int i = 0; i < 20; i++) {
            Question question = PerimeterAreaQuestionGenerator.generateQuestion();
            question.setChapter(chapterNumber);
            question.setChapterName(chapterName);
            Util.allQuestions.add(question);
        }
    }

    private void addQuestionsForChapterThirteen()
    {
        int chapterNumber = 13;
        String chapterName = "Time and Temperature";
        //Util.allQuestions.removeIf(question -> question.getChapter() == chapterNumber);
        final Random RANDOM = new Random();
        int randomNumber;

        Question question;

        for(int i = 0; i < 20; i++) {
            randomNumber = RANDOM.nextInt(100);

            if(randomNumber < 40) // 40%
            {
                question = TimeConceptQuestionGenerator.generateQuestion();
            }
            else if(randomNumber < 70) // 30%
            {
                question = ClockQuestionGenerator.generateQuestion();
            }
            else // 30%
            {
                question = CalendarQuestionGenerator.generateQuestion();
            }

            question.setChapter(chapterNumber);
            question.setChapterName(chapterName);
            Util.allQuestions.add(question);
        }
    }

    private void addQuestionsForChapterFourteen()
    {
        int chapterNumber = 14;
        String chapterName = "Mapping Skill";
        //Util.allQuestions.removeIf(question -> question.getChapter() == chapterNumber);
        List<Question> questions = MappingSkillConceptQuestionGenerator.generateAllQuestions();
        Collections.shuffle(questions);

        // 4 questions
        int numberOfQuestions = 4;
        List<Question> top10Questions = questions.subList(0, Math.min(numberOfQuestions, questions.size()));
        for(Question question : top10Questions)
        {
            question.setChapter(chapterNumber);
            question.setChapterName(chapterName);
            Util.allQuestions.add(question);
        }

        // 4 questions
        for(int i = 0; i < numberOfQuestions; i++) {
            Question question = DirectionDistanceQuestionGenerator.generateQuestion();
            question.setChapter(chapterNumber);
            question.setChapterName(chapterName);
            Util.allQuestions.add(question);
        }

        // 4 questions
        for(int i = 0; i < numberOfQuestions; i++) {
            Question question = ZooMapQuestionGenerator.generateQuestion();
            question.setChapter(chapterNumber);
            question.setChapterName(chapterName);
            Util.allQuestions.add(question);
        }

        // 4 questions
        for(int i = 0; i < numberOfQuestions; i++) {
            Question question = NeighborhoodMapQuestionGenerator.generateQuestion();
            question.setChapter(chapterNumber);
            question.setChapterName(chapterName);
            Util.allQuestions.add(question);
        }

        // 4 questions
        for(int i = 0; i < numberOfQuestions; i++) {
            Question question = MetroMapQuestionGenerator.generateQuestion();
            question.setChapter(chapterNumber);
            question.setChapterName(chapterName);
            Util.allQuestions.add(question);
        }
    }

    private void addQuestionsForChapterFifteen()
    {
        int chapterNumber = 15;
        String chapterName = "Handling Data";
        //Util.allQuestions.removeIf(question -> question.getChapter() == chapterNumber);
        Random RANDOM = new Random();
        int randomNumber;

        Question question;

        for(int i = 0; i < 20; i++) {
            randomNumber = RANDOM.nextInt(100);

            if(randomNumber < 40) // 40%
            {
                question = TableQuestionGenerator.generateQuestion();
            }
            else if(randomNumber < 80) // 40%
            {
                question = BarChartQuestionGenerator.generateQuestion();
            }
            else if(randomNumber < 90) // 10%
            {
                question = CircleGraphQuestionGenerator.generateQuestion();
            }
            else if(randomNumber < 95) // 5%
            {
                question = PictographQuestionGenerator.generateQuestion();
            }
            else // 5%
            {
                question = DataHandlingConceptQuestionGenerator.generateQuestion();
            }

            question.setChapter(chapterNumber);
            question.setChapterName(chapterName);
            Util.allQuestions.add(question);
        }
    }

    private void addQuestionsForChapterSixteen()
    {
        int chapterNumber = 16;
        String chapterName = "Symmetry";
        //Util.allQuestions.removeIf(question -> question.getChapter() == chapterNumber);

        List<Question> questions = SymmetryQuestionGenerator.generateAllQuestions();
        int numberOfQuestions = 20;

        List<Question> top20Questions = questions.subList(0, Math.min(numberOfQuestions, questions.size()));
        for(Question question : top20Questions)
        {
            question.setChapter(chapterNumber);
            question.setChapterName(chapterName);
            Util.allQuestions.add(question);
        }
    }

    private void setHeaderImage()
    {
        ImageView img = findViewById(R.id.imgEducation);
        String imageName = IMAGES[RANDOM.nextInt(IMAGES.length)];
        int resourceIdentifier = getResources().getIdentifier(imageName, "drawable", getPackageName());
        img.setImageResource(resourceIdentifier);
        Size size = getDrawableSize(this, imageName);

        int IMAGE_WIDTH = 800;
        float factor = (float) IMAGE_WIDTH / size.getWidth();
        int width = (int) (size.getWidth() * factor);
        int height = (int)(size.getHeight() * factor);
        setImageViewWidthHeight(img, width/2, height/2);
    }

    public Size getDrawableSize(Context context, String drawableName) {
        int resId = context.getResources().getIdentifier(drawableName,"drawable",context.getPackageName());
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeResource(context.getResources(),resId,options);
        return new Size(options.outWidth, options.outHeight);
    }

    private void setImageViewWidthHeight(ImageView img, int width, int height)
    {
        ViewGroup.LayoutParams params = img.getLayoutParams();
        params.width = width;
        params.height = height;
        img.setLayoutParams(params);
        img.setTop(20);
    }

    private static final Random RANDOM = new Random();

    private static final String[] IMAGES = {
            "thinking_owl",
            "blue_bird",
            "ant_thinking",
            "boy_thinking",
            "girl_thinking",
            "tortoise",
            "snail_thinking",
            "slate_thinking",
            "school_bag_thinking",
            "puppy",
            "protector_thinking",
            "plus_thinking",
            "pie_thinking",
            "captain_cortex",
            "pixel_panda",
            "professor_owl",
            "curious_monkey",
            "atom_ant",
            "buddy_bear",
            "circuit_cat",
            "cosmo_explorer",
            "knowledge_phoenix",
            "learning_lion",
            "lumina",
            "nova_the_robot",
            "quest_bot",
            "rocket_ranger",
            "sage_fox"
    };
}
