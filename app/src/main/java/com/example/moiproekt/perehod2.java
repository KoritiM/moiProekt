package com.example.moiproekt;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class perehod2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_perehod2);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Находим TextView по ID из layout
        TextView messageTextView = findViewById(R.id.message);

        // Получаем данные из Intent
        Bundle arguments = getIntent().getExtras();

        if (arguments != null) {
            String name = arguments.getString("name");
            int age = arguments.getInt("age");
            String group = arguments.getString("group");

            // Устанавливаем текст
            String resultText = "Имя: " + name + "\nВозраст: " + age + "\nГруппа: " + group;
            messageTextView.setText(resultText);

            // Для отладки
            Log.d("perehod2", "Получены данные: " + resultText);
        } else {
            messageTextView.setText("Данные не получены");
            Log.d("perehod2", "Данные не получены");
        }
    }
}