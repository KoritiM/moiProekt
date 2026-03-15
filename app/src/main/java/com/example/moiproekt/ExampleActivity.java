package com.example.moiproekt;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class ExampleActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_example);

        // Получаем элементы по ID
        TextView textView = findViewById(R.id.exampleTextView);
        Button button = findViewById(R.id.exampleButton);

        // Управляем элементами
        textView.setText("Текст изменен в коде");
        textView.setTextColor(getResources().getColor(android.R.color.holo_blue_dark));

        button.setOnClickListener(v ->
                Toast.makeText(this, "Кнопка нажата!", Toast.LENGTH_SHORT).show()
        );
    }
}