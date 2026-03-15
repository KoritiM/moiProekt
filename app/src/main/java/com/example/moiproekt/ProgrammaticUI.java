package com.example.moiproekt;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class ProgrammaticUI extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Создаем корневой контейнер
        LinearLayout mainLayout = new LinearLayout(this);
        mainLayout.setLayoutParams(new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.MATCH_PARENT
        ));
        mainLayout.setOrientation(LinearLayout.VERTICAL);
        mainLayout.setPadding(50, 50, 50, 50);

        // Создаем заголовок
        TextView titleTextView = new TextView(this);
        titleTextView.setLayoutParams(new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
        ));
        titleTextView.setText("Интерфейс, созданный в Java коде");
        titleTextView.setTextSize(24);
        titleTextView.setTextColor(getResources().getColor(android.R.color.holo_blue_dark));
        titleTextView.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
        titleTextView.setPadding(0, 0, 0, 30);

        // Создаем поле ввода имени
        TextView nameLabel = new TextView(this);
        nameLabel.setLayoutParams(new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.WRAP_CONTENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
        ));
        nameLabel.setText("Введите имя:");
        nameLabel.setTextSize(16);

        EditText nameInput = new EditText(this);
        LinearLayout.LayoutParams inputParams = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
        );
        inputParams.setMargins(0, 0, 0, 20);
        nameInput.setLayoutParams(inputParams);
        nameInput.setHint("Например: Иван");

        // Создаем кнопку
        Button actionButton = new Button(this);
        actionButton.setLayoutParams(new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.WRAP_CONTENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
        ));
        actionButton.setText("Показать приветствие");

        actionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = nameInput.getText().toString();
                if (name.isEmpty()) {
                    Toast.makeText(ProgrammaticUI.this, "Введите имя!", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(ProgrammaticUI.this, "Привет, " + name + "!", Toast.LENGTH_LONG).show();
                }
            }
        });

        // Добавляем все элементы в контейнер
        mainLayout.addView(titleTextView);
        mainLayout.addView(nameLabel);
        mainLayout.addView(nameInput);
        mainLayout.addView(actionButton);

        setContentView(mainLayout);
    }
}