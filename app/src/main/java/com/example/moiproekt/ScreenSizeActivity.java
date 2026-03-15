package com.example.moiproekt;

import android.os.Bundle;
import android.util.DisplayMetrics;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class ScreenSizeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        TextView textView = new TextView(this);
        textView.setPadding(20, 20, 20, 20);

        // Получаем размеры экрана
        DisplayMetrics displayMetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);

        int width = displayMetrics.widthPixels;
        int height = displayMetrics.heightPixels;
        float density = displayMetrics.density;
        float dpWidth = width / density;
        float dpHeight = height / density;

        String info = "Размеры экрана:\n" +
                "Ширина (px): " + width + "px\n" +
                "Высота (px): " + height + "px\n" +
                "Плотность: " + density + "\n" +
                "Ширина (dp): " + dpWidth + "dp\n" +
                "Высота (dp): " + dpHeight + "dp";

        textView.setText(info);
        setContentView(textView);
    }
}