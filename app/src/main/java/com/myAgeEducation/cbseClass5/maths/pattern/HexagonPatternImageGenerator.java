package com.myAgeEducation.cbseClass5.maths.pattern;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;

import com.myAgeEducation.cbseClass5.maths.utils.NumberFormatUtil;
import com.myAgeEducation.cbseClass5.utils.ImageCodeParser;
import com.myAgeEducation.cbseClass5.utils.ImageCodeType;

import java.util.Map;
import java.util.Objects;

public class HexagonPatternImageGenerator {

    private static final int WIDTH = 1000;
    private static final int HEIGHT = 600;

    public static Bitmap generate(Context context, String imageCode) {
        Map<String, String> values = ImageCodeParser.parse(imageCode);
        String subType = values.get("SUBTYPE");

        Bitmap bitmap = Bitmap.createBitmap(WIDTH, HEIGHT, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmap);
        canvas.drawColor(Color.TRANSPARENT);

        if ("HONEYCOMB9".equals(subType)) {
            drawHoneycomb9(canvas, values);
        } else if ("HEXRING".equals(subType)) {
            drawHexRing(canvas, values);
        } else if ("ZIGZAG".equals(subType)) {
            drawZigZag(canvas, values);
        } else if ("DOUBLEHONEYCOMB".equals(subType)) {
            drawDoubleHoneycomb(canvas, values);
        }

        return bitmap;
    }

    private static void drawHoneycomb9(Canvas canvas, Map<String, String> values) {
        float centerX = WIDTH / 2f;
        float centerY = HEIGHT / 2f;
        float s = 80; // side length
        float h = (float) (s * Math.sqrt(3) / 2);

        // Row positions relative to center
        float[][] positions = {
                {0, -2 * h}, // Top (4)
                {-1.5f * s, -h}, {1.5f * s, -h}, // Row 2 (2, 7)
                {-3 * s, 0}, {0, 0}, {3 * s, 0}, // Row 3 (1, ?, 9)
                {-1.5f * s, h}, {1.5f * s, h}, // Row 4 (3, 8)
                {0, 2 * h} // Bottom (6)
        };

        int missingIndex = Integer.parseInt(Objects.requireNonNull(values.get("MISSING")));
        String[] numbers = Objects.requireNonNull(values.get("NUMBERS")).split(",");

        Paint fillPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        fillPaint.setColor(Color.rgb(100, 180, 70)); // Green
        fillPaint.setStyle(Paint.Style.FILL);

        Paint strokePaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        strokePaint.setColor(Color.rgb(50, 100, 180)); // Blue border
        strokePaint.setStyle(Paint.Style.STROKE);
        strokePaint.setStrokeWidth(3);

        Paint textPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        textPaint.setColor(Color.WHITE);
        textPaint.setTextSize(40);
        textPaint.setTextAlign(Paint.Align.CENTER);
        textPaint.setFakeBoldText(true);

        Paint questionPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        questionPaint.setColor(Color.YELLOW);
        questionPaint.setTextSize(50);
        questionPaint.setTextAlign(Paint.Align.CENTER);
        questionPaint.setFakeBoldText(true);

        for (int i = 0; i < positions.length; i++) {
            drawHexagon(canvas, centerX + positions[i][0], centerY + positions[i][1], s, fillPaint, strokePaint);
            if (i == missingIndex) {
                canvas.drawText("?", centerX + positions[i][0], centerY + positions[i][1] + 15, questionPaint);
            } else {
                canvas.drawText(numbers[i], centerX + positions[i][0], centerY + positions[i][1] + 15, textPaint);
            }
        }
    }

    private static void drawHexRing(Canvas canvas, Map<String, String> values) {
        float centerX = WIDTH / 2f;
        float centerY = HEIGHT / 2f;
        float s = 90;
        float h = (float) (s * Math.sqrt(3) / 2);

        float[][] positions = {
                {-1.5f * s, -h}, {0, -2 * h}, {1.5f * s, -h},
                {1.5f * s, h}, {0, 2 * h}, {-1.5f * s, h}
        };

        int missingIndex = Integer.parseInt(Objects.requireNonNull(values.get("MISSING")));
        String[] numbers = Objects.requireNonNull(values.get("NUMBERS")).split(",");

        Paint ringFillPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        ringFillPaint.setColor(Color.rgb(255, 190, 0)); // Orange/Yellow
        ringFillPaint.setStyle(Paint.Style.FILL);

        Paint centerFillPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        centerFillPaint.setColor(Color.BLACK);
        centerFillPaint.setStyle(Paint.Style.FILL);

        Paint strokePaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        strokePaint.setColor(Color.rgb(50, 100, 180));
        strokePaint.setStyle(Paint.Style.STROKE);
        strokePaint.setStrokeWidth(3);

        Paint textPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        textPaint.setColor(Color.WHITE);
        textPaint.setTextSize(45);
        textPaint.setTextAlign(Paint.Align.CENTER);

        Paint questionPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        questionPaint.setColor(Color.RED);
        questionPaint.setTextSize(50);
        questionPaint.setTextAlign(Paint.Align.CENTER);
        questionPaint.setFakeBoldText(true);

        // Center black hexagon
        drawHexagon(canvas, centerX, centerY, s, centerFillPaint, strokePaint);

        for (int i = 0; i < positions.length; i++) {
            drawHexagon(canvas, centerX + positions[i][0], centerY + positions[i][1], s, ringFillPaint, strokePaint);
            if (i == missingIndex) {
                canvas.drawText("?", centerX + positions[i][0], centerY + positions[i][1] + 15, questionPaint);
            } else {
                canvas.drawText(numbers[i], centerX + positions[i][0], centerY + positions[i][1] + 15, textPaint);
            }
        }
    }

    private static void drawZigZag(Canvas canvas, Map<String, String> values) {
        float s = 80;
        float h = (float) (s * Math.sqrt(3) / 2);
        float startX = 200;
        float startY = HEIGHT / 2f;

        int missingIndex = Integer.parseInt(Objects.requireNonNull(values.get("MISSING")));
        String[] numbers = Objects.requireNonNull(values.get("NUMBERS")).split(",");
        int colorInt = Color.parseColor(values.getOrDefault("COLOR", "#FFFF00"));

        Paint fillPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        fillPaint.setColor(colorInt);
        fillPaint.setStyle(Paint.Style.FILL);

        Paint strokePaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        strokePaint.setColor(Color.rgb(50, 100, 180));
        strokePaint.setStyle(Paint.Style.STROKE);
        strokePaint.setStrokeWidth(3);

        Paint textPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        textPaint.setColor(Color.rgb(80, 80, 80));
        textPaint.setTextSize(45);
        textPaint.setTextAlign(Paint.Align.CENTER);

        Paint questionPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        questionPaint.setColor(Color.RED);
        questionPaint.setTextSize(50);
        questionPaint.setTextAlign(Paint.Align.CENTER);
        questionPaint.setFakeBoldText(true);

        for (int i = 0; i < numbers.length; i++) {
            float x = startX + i * 1.5f * s;
            float y = startY + (i % 2 == 0 ? h : -h);
            drawHexagon(canvas, x, y, s, fillPaint, strokePaint);
            if (i == missingIndex) {
                canvas.drawText("?", x, y + 15, questionPaint);
            } else {
                canvas.drawText(numbers[i], x, y + 15, textPaint);
            }
        }
    }

    private static void drawDoubleHoneycomb(Canvas canvas, Map<String, String> values) {
        float s = 60;
        float h = (float) (s * Math.sqrt(3) / 2);

        drawSingleHoneycomb(canvas, 250, HEIGHT / 2f, s, h, values, "1");
        drawSingleHoneycomb(canvas, 750, HEIGHT / 2f, s, h, values, "2");
    }

    private static void drawSingleHoneycomb(Canvas canvas, float centerX, float centerY, float s, float h, Map<String, String> values, String id) {
        float[][] positions = {
                {0, -2 * h}, {1.5f * s, -h}, {1.5f * s, h},
                {0, 2 * h}, {-1.5f * s, h}, {-1.5f * s, -h},
                {0, 0} // Center
        };

        String[] numbers = Objects.requireNonNull(values.get("NUMBERS" + id)).split(",");
        int missingIndex = Integer.parseInt(values.getOrDefault("MISSING" + id, "-1"));

        Paint fillPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        fillPaint.setColor(Color.rgb(180, 230, 140)); // Light green
        fillPaint.setStyle(Paint.Style.FILL);

        Paint strokePaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        strokePaint.setColor(Color.rgb(50, 100, 180));
        strokePaint.setStyle(Paint.Style.STROKE);
        strokePaint.setStrokeWidth(3);

        Paint textPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        textPaint.setColor(Color.WHITE);
        textPaint.setTextSize(35);
        textPaint.setTextAlign(Paint.Align.CENTER);

        Paint centerTextPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        centerTextPaint.setColor(Color.YELLOW);
        centerTextPaint.setTextSize(40);
        centerTextPaint.setTextAlign(Paint.Align.CENTER);
        centerTextPaint.setFakeBoldText(true);

        Paint questionPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        questionPaint.setColor(Color.RED);
        questionPaint.setTextSize(45);
        questionPaint.setTextAlign(Paint.Align.CENTER);
        questionPaint.setFakeBoldText(true);

        for (int i = 0; i < positions.length; i++) {
            drawHexagon(canvas, centerX + positions[i][0], centerY + positions[i][1], s, fillPaint, strokePaint);
            Paint p = (i == 6) ? centerTextPaint : textPaint;
            if (i == missingIndex) {
                canvas.drawText("?", centerX + positions[i][0], centerY + positions[i][1] + 12, questionPaint);
            } else {
                canvas.drawText(numbers[i], centerX + positions[i][0], centerY + positions[i][1] + 12, p);
            }
        }
    }

    private static void drawHexagon(Canvas canvas, float x, float y, float s, Paint fillPaint, Paint strokePaint) {
        Path path = new Path();
        for (int i = 0; i < 6; i++) {
            float angle = (float) (Math.PI / 6 + i * Math.PI / 3);
            float px = (float) (x + s * Math.cos(angle));
            float py = (float) (y + s * Math.sin(angle));
            if (i == 0) path.moveTo(px, py);
            else path.lineTo(px, py);
        }
        path.close();
        canvas.drawPath(path, fillPaint);
        canvas.drawPath(path, strokePaint);
    }
}
