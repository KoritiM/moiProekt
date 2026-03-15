package com.example.moiproekt;

import android.os.Bundle;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import androidx.appcompat.app.AppCompatActivity;

public class ProgrammaticSizeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Button button = new Button(this);
        button.setText("Кнопка с изменяемыми размерами");

        // Устанавливаем LayoutParams
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT
        );

        // Изменяем параметры программно
        params.width = 500; // фиксированная ширина в px
        params.height = 200; // фиксированная высота в px

        button.setLayoutParams(params);
        setContentView(button);
    }
}