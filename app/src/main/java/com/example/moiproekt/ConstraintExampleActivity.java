package com.example.moiproekt;

import android.os.Bundle;
import android.view.View;  // ВАЖНО: этот импорт нужен для generateViewId()
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;

public class ConstraintExampleActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        try {
            // Создаем ConstraintLayout
            ConstraintLayout constraintLayout = new ConstraintLayout(this);
            constraintLayout.setLayoutParams(new ConstraintLayout.LayoutParams(
                    ConstraintLayout.LayoutParams.MATCH_PARENT,
                    ConstraintLayout.LayoutParams.MATCH_PARENT
            ));

            // Создаем TextView 1 - теперь View.generateViewId() работает, потому что импортирован
            TextView textView1 = new TextView(this);
            textView1.setId(View.generateViewId());
            textView1.setText("Элемент 1");
            textView1.setTextSize(18);
            textView1.setPadding(20, 20, 20, 20);
            textView1.setBackgroundColor(0xFF2196F3); // Синий цвет
            textView1.setTextColor(0xFFFFFFFF); // Белый текст

            // Создаем TextView 2
            TextView textView2 = new TextView(this);
            textView2.setId(View.generateViewId());
            textView2.setText("Элемент 2");
            textView2.setTextSize(18);
            textView2.setPadding(20, 20, 20, 20);
            textView2.setBackgroundColor(0xFF4CAF50); // Зеленый цвет
            textView2.setTextColor(0xFFFFFFFF); // Белый текст

            // Создаем кнопку
            Button button = new Button(this);
            button.setId(View.generateViewId());
            button.setText("Нажми меня");

            // Добавляем элементы в layout
            constraintLayout.addView(textView1);
            constraintLayout.addView(textView2);
            constraintLayout.addView(button);

            // Настраиваем позиции элементов
            ConstraintSet constraintSet = new ConstraintSet();
            constraintSet.clone(constraintLayout);

            // Привязываем textView1 к верхнему левому углу
            constraintSet.connect(textView1.getId(), ConstraintSet.TOP, ConstraintSet.PARENT_ID, ConstraintSet.TOP, 100);
            constraintSet.connect(textView1.getId(), ConstraintSet.START, ConstraintSet.PARENT_ID, ConstraintSet.START, 50);

            // Привязываем textView2 к textView1 (справа от него)
            constraintSet.connect(textView2.getId(), ConstraintSet.TOP, textView1.getId(), ConstraintSet.TOP);
            constraintSet.connect(textView2.getId(), ConstraintSet.START, textView1.getId(), ConstraintSet.END, 50);
            constraintSet.connect(textView2.getId(), ConstraintSet.END, ConstraintSet.PARENT_ID, ConstraintSet.END, 50);

            // Привязываем кнопку к нижней части экрана
            constraintSet.connect(button.getId(), ConstraintSet.BOTTOM, ConstraintSet.PARENT_ID, ConstraintSet.BOTTOM, 100);
            constraintSet.connect(button.getId(), ConstraintSet.START, ConstraintSet.PARENT_ID, ConstraintSet.START);
            constraintSet.connect(button.getId(), ConstraintSet.END, ConstraintSet.PARENT_ID, ConstraintSet.END);

            // Применяем настройки
            constraintSet.applyTo(constraintLayout);

            // Обработчик кнопки
            button.setOnClickListener(v ->
                    Toast.makeText(ConstraintExampleActivity.this, "ConstraintLayout работает!", Toast.LENGTH_SHORT).show()
            );

            setContentView(constraintLayout);

        } catch (Exception e) {
            e.printStackTrace();
            // Если что-то пошло не так, показываем простой TextView
            TextView errorView = new TextView(this);
            errorView.setText("Ошибка: " + e.getMessage());
            errorView.setPadding(50, 50, 50, 50);
            setContentView(errorView);
        }
    }
}