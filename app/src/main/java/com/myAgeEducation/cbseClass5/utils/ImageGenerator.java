package com.myAgeEducation.cbseClass5.utils;


import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.View;

public class ImageGenerator {
    private static final int IMAGE_WIDTH = 900;
    private static final int IMAGE_HEIGHT = 900;

    public static Bitmap generate(Context context, String imageCode) {
        String[] parts = imageCode.split(";");
        if(parts.length < 2)
        {
            return null;
        }

        imageCode = parts[1];

        int resourceIdentifier = context.getResources().getIdentifier(imageCode, "drawable", context.getPackageName());

        Bitmap bitmap = null;

        if (resourceIdentifier != 0) {
            bitmap = BitmapFactory.decodeResource(context.getResources(), resourceIdentifier);
        }

        return bitmap;
    }
}
