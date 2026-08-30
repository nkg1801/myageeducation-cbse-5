package com.myAgeEducation.cbseClass5.computers;

import com.myAgeEducation.cbseClass5.maths.utils.PersonNameUtil;
import com.myAgeEducation.cbseClass5.utils.OptionUtils;
import com.myAgeEducation.cbsecommon.Question;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class LogoProgramQuestionGenerator {
    private static final Random RANDOM = new Random();

    public static List<Question> getQuestions(int count) {
        List<Question> questions = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            int type = RANDOM.nextInt(3);
            if (type == 0) {
                questions.add(generateLogoNameQuestion());
            } else if (type == 1) {
                questions.add(generateLogoProgramSelectionQuestion());
            } else {
                questions.add(generateLogoShapeIdentificationQuestion());
            }
        }
        return questions;
    }

    private static class LogoShapeInfo {
        String name;
        String correctCode;
        List<String> incorrectCodes;

        LogoShapeInfo(String name, String correctCode, List<String> incorrectCodes) {
            this.name = name;
            this.correctCode = correctCode;
            this.incorrectCodes = incorrectCodes;
        }
    }

    private static LogoShapeInfo getRandomShapeInfo() {
        int shapeType = RANDOM.nextInt(8); // 0: Square, 1: Rectangle, 2: Triangle, 3: L, 4: H, 5: T, 6: U, 7: V
        String shapeName;
        String correctCode;
        List<String> incorrectCodes = new ArrayList<>();

        switch (shapeType) {
            case 0: // Square
                shapeName = "square";
                int side = (RANDOM.nextInt(5) + 1) * 20;
                correctCode = String.format("FD %d\nRT 90\nFD %d\nRT 90\nFD %d\nRT 90\nFD %d", side, side, side, side);
                incorrectCodes.add(String.format("FD %d\nRT 90\nFD %d\nRT 90\nFD %d\nRT 90\nFD %d", side, side / 2, side, side / 2));
                incorrectCodes.add(String.format("FD %d\nRT 90\nFD %d\nRT 90\nFD %d\nRT 90\nFD %d", side, side, side + 20, side));
                incorrectCodes.add(String.format("FD %d\nRT 90\nFD %d\nRT 90\nFD %d", side, side, side));
                break;
            case 1: // Rectangle
                shapeName = "rectangle";
                int length = (RANDOM.nextInt(5) + 3) * 20;
                int width = (RANDOM.nextInt(2) + 1) * 20;
                correctCode = String.format("FD %d\nRT 90\nFD %d\nRT 90\nFD %d\nRT 90\nFD %d", length, width, length, width);
                incorrectCodes.add(String.format("FD %d\nRT 90\nFD %d\nRT 90\nFD %d\nRT 90\nFD %d", length, length, length, length));
                incorrectCodes.add(String.format("FD %d\nRT 90\nFD %d\nRT 90\nFD %d", length, width, length));
                incorrectCodes.add(String.format("FD %d\nRT 90\nFD %d\nRT 90\nFD %d\nRT 90\nFD %d", length, width, length, width + 10));
                break;
            case 2: // Triangle (Equilateral)
                shapeName = "equilateral triangle";
                int tSide = (RANDOM.nextInt(5) + 2) * 20;
                correctCode = String.format("FD %d\nRT 120\nFD %d\nRT 120\nFD %d", tSide, tSide, tSide);
                incorrectCodes.add(String.format("FD %d\nRT 60\nFD %d\nRT 60\nFD %d", tSide, tSide, tSide));
                incorrectCodes.add(String.format("FD %d\nRT 90\nFD %d\nRT 90\nFD %d", tSide, tSide, tSide));
                incorrectCodes.add(String.format("FD %d\nRT 120\nFD %d", tSide, tSide));
                break;
            case 3: // Letter L
                shapeName = "letter 'L'";
                int lH = (RANDOM.nextInt(3) + 3) * 20;
                int lW = (RANDOM.nextInt(2) + 2) * 10;
                correctCode = String.format("FD %d\nBK %d\nRT 90\nFD %d", lH, lH, lW);
                incorrectCodes.add(String.format("FD %d\nBK %d\nLT 90\nFD %d", lH, lH, lW));
                incorrectCodes.add(String.format("FD %d\nRT 90\nFD %d", lH, lW));
                incorrectCodes.add(String.format("FD %d\nBK %d\nRT 45\nFD %d", lH, lH, lW));
                break;
            case 4: // Letter H
                shapeName = "letter 'H'";
                int hSide = (RANDOM.nextInt(3) + 4) * 20;
                int hMid = hSide / 2;
                correctCode = String.format("FD %d\nBK %d\nRT 90\nFD %d\nLT 90\nFD %d\nBK %d", hSide, hMid, hMid, hMid, hSide);
                incorrectCodes.add(String.format("FD %d\nRT 90\nFD %d\nLT 90\nFD %d", hSide, hMid, hSide));
                incorrectCodes.add(String.format("FD %d\nBK %d\nRT 45\nFD %d\nLT 90\nFD %d\nBK %d", hSide, hMid, hMid, hMid, hSide));
                incorrectCodes.add(String.format("FD %d\nBK %d\nRT 90\nFD %d\nFD %d\nBK %d", hSide, hMid, hMid, hSide, hSide));
                break;
            case 5: // Letter T
                shapeName = "letter 'T'";
                int tH = (RANDOM.nextInt(3) + 4) * 20;
                int tW = (RANDOM.nextInt(3) + 2) * 20;
                correctCode = String.format("FD %d\nLT 90\nFD %d\nBK %d", tH, tW / 2, tW);
                incorrectCodes.add(String.format("FD %d\nRT 90\nFD %d\nBK %d", tH, tW / 2, tW));
                incorrectCodes.add(String.format("FD %d\nLT 90\nFD %d", tH, tW / 2));
                incorrectCodes.add(String.format("FD %d\nRT 90\nFD %d", tH, tW / 2));
                break;
            case 6: // Letter U
                shapeName = "letter 'U'";
                int uSide = (RANDOM.nextInt(3) + 4) * 20;
                int uBase = (RANDOM.nextInt(2) + 2) * 20;
                correctCode = String.format("RT 180\nFD %d\nLT 90\nFD %d\nLT 90\nFD %d", uSide, uBase, uSide);
                incorrectCodes.add(String.format("RT 180\nFD %d\nRT 90\nFD %d\nRT 90\nFD %d", uSide, uBase, uSide));
                incorrectCodes.add(String.format("FD %d\nLT 90\nFD %d\nLT 90\nFD %d", uSide, uBase, uSide));
                incorrectCodes.add(String.format("RT 180\nFD %d\nLT 90\nFD %d", uSide, uBase));
                break;
            case 7: // Letter V
                shapeName = "letter 'V'";
                int vSide = (RANDOM.nextInt(3) + 4) * 20;
                correctCode = String.format("RT 150\nFD %d\nLT 120\nFD %d", vSide, vSide);
                incorrectCodes.add(String.format("RT 150\nFD %d\nRT 120\nFD %d", vSide, vSide));
                incorrectCodes.add(String.format("RT 120\nFD %d\nLT 60\nFD %d", vSide, vSide));
                incorrectCodes.add(String.format("RT 150\nFD %d\nLT 90\nFD %d", vSide, vSide));
                break;
            default:
                shapeName = "shape";
                correctCode = "";
        }
        return new LogoShapeInfo(shapeName, correctCode, incorrectCodes);
    }

    private static Question generateLogoNameQuestion() {
        String[] names = PersonNameUtil.getDifferentNames(3);
        LogoShapeInfo shapeInfo = getRandomShapeInfo();

        List<Integer> nameIndices = new ArrayList<>();
        nameIndices.add(0);
        nameIndices.add(1);
        nameIndices.add(2);
        Collections.shuffle(nameIndices);

        int correctPersonIndex = nameIndices.get(0);
        int wrongPerson1Index = nameIndices.get(1);
        int wrongPerson2Index = nameIndices.get(2);

        String person0Code = (0 == correctPersonIndex) ? shapeInfo.correctCode : (0 == wrongPerson1Index ? shapeInfo.incorrectCodes.get(0) : shapeInfo.incorrectCodes.get(1));
        String person1Code = (1 == correctPersonIndex) ? shapeInfo.correctCode : (1 == wrongPerson1Index ? shapeInfo.incorrectCodes.get(0) : shapeInfo.incorrectCodes.get(1));
        String person2Code = (2 == correctPersonIndex) ? shapeInfo.correctCode : (2 == wrongPerson1Index ? shapeInfo.incorrectCodes.get(0) : shapeInfo.incorrectCodes.get(1));

        StringBuilder supportiveText = new StringBuilder();
        supportiveText.append(String.format("Program written by %s:\n========================\n%s\n\n", names[0], person0Code));
        supportiveText.append(String.format("Program written by %s:\n========================\n%s\n\n", names[1], person1Code));
        supportiveText.append(String.format("Program written by %s:\n========================\n%s", names[2], person2Code));

        Question question = new Question();
        question.setQuestion(String.format("%s, %s and %s were asked to write LOGO programs to draw a %s. The LOGO program written by them is shown in the box below. Find out whose program is correct.",
                names[0], names[1], names[2], shapeInfo.name));
        question.setSupportiveText(supportiveText.toString());
        question.setAnswer(String.format("%s's program is correct", names[correctPersonIndex]));

        List<String> options = new ArrayList<>();
        options.add(String.format("%s's program is correct", names[0]));
        options.add(String.format("%s's program is correct", names[1]));
        options.add(String.format("%s's program is correct", names[2]));
        Collections.shuffle(options);
        options.add("All programs are correct");

        OptionUtils.setQuestionOptions(question, options);

        return question;
    }

    private static Question generateLogoProgramSelectionQuestion() {
        LogoShapeInfo shapeInfo = getRandomShapeInfo();

        List<String> codes = new ArrayList<>();
        codes.add(shapeInfo.correctCode);
        codes.addAll(shapeInfo.incorrectCodes.subList(0, Math.min(3, shapeInfo.incorrectCodes.size())));

        while (codes.size() < 4) {
            codes.add("FD " + (RANDOM.nextInt(5) + 1) * 20);
        }

        Collections.shuffle(codes);

        int correctIndex = codes.indexOf(shapeInfo.correctCode);

        StringBuilder supportiveText = new StringBuilder();
        for (int i = 0; i < codes.size(); i++) {
            supportiveText.append(String.format("LOGO Program %d:\n==============\n%s\n\n", i + 1, codes.get(i)));
        }

        Question question = new Question();
        question.setQuestion(String.format("With the turtle at the home position, which one of the program, given in the box below, will draw a %s:", shapeInfo.name));
        question.setSupportiveText(supportiveText.toString().trim());
        question.setAnswer("LOGO Program " + (correctIndex + 1));

        List<String> options = new ArrayList<>();
        for (int i = 0; i < codes.size(); i++) {
            options.add("LOGO Program " + (i + 1));
        }

        OptionUtils.setQuestionOptions(question, options);

        return question;
    }

    private static Question generateLogoShapeIdentificationQuestion() {
        LogoShapeInfo shapeInfo = getRandomShapeInfo();

        Question question = new Question();
        question.setQuestion("What shape will you get if you run the commands given in the box below?");
        question.setSupportiveText(shapeInfo.correctCode);
        question.setAnswer(capitalize(shapeInfo.name));

        List<String> options = new ArrayList<>();
        options.add(capitalize(shapeInfo.name));
        
        // Add other shape names as distractors
        List<String> otherShapes = new ArrayList<>();
        otherShapes.add("Square");
        otherShapes.add("Rectangle");
        otherShapes.add("Equilateral triangle");
        otherShapes.add("Letter 'L'");
        otherShapes.add("Letter 'H'");
        otherShapes.add("Letter 'T'");
        otherShapes.add("Letter 'U'");
        otherShapes.add("Letter 'V'");
        otherShapes.remove(capitalize(shapeInfo.name));
        Collections.shuffle(otherShapes);
        
        options.add(otherShapes.get(0));
        options.add(otherShapes.get(1));
        options.add("Circle"); // Common distractor

        Collections.shuffle(options);
        OptionUtils.setQuestionOptions(question, options);

        return question;
    }
    
    private static String capitalize(String str) {
        if (str == null || str.isEmpty()) return str;
        return str.substring(0, 1).toUpperCase() + str.substring(1);
    }
}