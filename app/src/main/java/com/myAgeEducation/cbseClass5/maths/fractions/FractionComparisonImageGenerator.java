package com.myAgeEducation.cbseClass5.maths.fractions;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Typeface;

public class FractionComparisonImageGenerator {

    public static Bitmap generate(String imageCode) {
        String[] parts = imageCode.split("_");
        // Format: FRAC-COMP_W1_N1_D1_OP_W2_N2_D2
        if (parts.length < 8) return null;

        int w1 = Integer.parseInt(parts[1]);
        int n1 = Integer.parseInt(parts[2]);
        int d1 = Integer.parseInt(parts[3]);
        int opType = Integer.parseInt(parts[4]); // 0: blank, 1: <, 2: >, 3: =
        int w2 = Integer.parseInt(parts[5]);
        int n2 = Integer.parseInt(parts[6]);
        int d2 = Integer.parseInt(parts[7]);

        int width = 900;
        int height = 500;

        Bitmap bitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmap);
        canvas.drawColor(Color.WHITE);

        Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
        paint.setColor(Color.BLACK);
        paint.setTextAlign(Paint.Align.CENTER);
        paint.setTypeface(Typeface.DEFAULT_BOLD);

        // Draw First Fraction
        drawFraction(canvas, 250, 250, w1, n1, d1, paint);

        // Draw Operator or Blank
        String opStr = "";
        switch (opType) {
            case 1: opStr = "<"; break;
            case 2: opStr = ">"; break;
            case 3: opStr = "="; break;
            default: opStr = " "; break;
        }

        paint.setTextSize(120);
        paint.setColor(Color.BLACK);
        canvas.drawText(opStr, 450, 285, paint);
        if (opType == 0) {
            // Draw a small box for blank
            paint.setStyle(Paint.Style.STROKE);
            paint.setStrokeWidth(4);
            canvas.drawRect(410, 220, 490, 310, paint);
            paint.setStyle(Paint.Style.FILL);
        }

        // Draw Second Fraction
        paint.setColor(Color.BLACK);
        drawFraction(canvas, 650, 250, w2, n2, d2, paint);

        return bitmap;
    }

    private static void drawFraction(Canvas canvas, float centerX, float centerY, int w, int n, int d, Paint paint) {
        paint.setTextSize(140);
        String wStr = w > 0 ? String.valueOf(w) : "";
        float wWidth = w > 0 ? paint.measureText(wStr) : 0;

        paint.setTextSize(90);
        String nStr = String.valueOf(n);
        String dStr = String.valueOf(d);
        float nWidth = paint.measureText(nStr);
        float dWidth = paint.measureText(dStr);
        float maxFracWidth = Math.max(nWidth, dWidth);
        
        float spacing = 15;
        float totalWidth = wWidth + (w > 0 ? spacing : 0) + maxFracWidth;
        
        float startX = centerX - totalWidth / 2;
        
        // Draw whole number
        if (w > 0) {
            paint.setTextSize(140);
            canvas.drawText(wStr, startX + wWidth / 2, centerY + 50, paint);
        }
        
        // Draw fraction
        float fracCenterX = startX + (w > 0 ? wWidth + spacing : 0) + maxFracWidth / 2;
        paint.setTextSize(90);
        // Numerator
        canvas.drawText(nStr, fracCenterX, centerY - 20, paint);
        // Line
        float lineW = maxFracWidth + 20;
        paint.setStrokeWidth(6);
        canvas.drawLine(fracCenterX - lineW/2, centerY, fracCenterX + lineW/2, centerY, paint);
        // Denominator
        canvas.drawText(dStr, fracCenterX, centerY + 85, paint);
    }
}
