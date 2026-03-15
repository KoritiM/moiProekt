package com.example.moiproekt;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class MyNewLayoutActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_new_layout);

        // Получаем доступ к элементам из layout
        TextView textView = findViewById(R.id.textView);
        Button button = findViewById(R.id.button);

        // Устанавливаем текст
        if (textView != null) {
            textView.setText("Нажми чтобы получать рассылку");
        }

        // Обработчик кнопки
        if (button != null) {
            button.setOnClickListener(v ->
                    Toast.makeText(this, "Рассылка получена!", Toast.LENGTH_SHORT).show()
            );
        }
    }
}