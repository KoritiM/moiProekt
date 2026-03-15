package com.example.moiproekt;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // ===== ПУНКТ 12: ПРОГРАММНАЯ УСТАНОВКА ОТСТУПОВ В JAVA =====
        // Берем любую кнопку, например O_O
        Button myButton = findViewById(R.id.my_button);

        // Устанавливаем ВНУТРЕННИЕ отступы (PADDING) через Java
        // Числа означают: слева, сверху, справа, снизу
        myButton.setPadding(60, 30, 60, 30);

        // Устанавливаем ВНЕШНИЕ отступы (MARGIN) через Java
        ConstraintLayout.LayoutParams params = (ConstraintLayout.LayoutParams) myButton.getLayoutParams();
        params.setMargins(40, 20, 40, 20);  // слева, сверху, справа, снизу
        myButton.setLayoutParams(params);

        // Теперь кнопка O_O имеет отступы:
        // Padding - текст внутри отодвинут от краев
        // Margin - сама кнопка отодвинута от других элементов
    }

    // Метод для перехода на perehod1
    public void openSecondWindow(View view) {
        Intent intent = new Intent(this, perehod1.class);
        startActivity(intent);
    }

    // Пункт 3: Programmatic UI
    public void openProgrammaticUI(View view) {
        Intent intent = new Intent(this, ProgrammaticUI.class);
        startActivity(intent);
    }

    // Пункт 5: Новый Layout
    public void openNewLayout(View view) {
        Intent intent = new Intent(this, MyNewLayoutActivity.class);
        startActivity(intent);
    }

    // Пункт 7: Размер экрана
    public void openScreenSize(View view) {
        Intent intent = new Intent(this, ScreenSizeActivity.class);
        startActivity(intent);
    }

    // Пункт 13: ConstraintLayout
    public void openConstraintExample(View view) {
        Intent intent = new Intent(this, ConstraintExampleActivity.class);
        startActivity(intent);
    }

    public void openLayoutExamples(View view) {
        startActivity(new Intent(this, LayoutExamplesActivity.class));
    }

    // Пункты 11-12: Отступы (уже показаны в onCreate)
    public void openPaddingMargin(View view) {
        // Можно оставить эту кнопку или удалить
        Toast.makeText(this, "Отступы уже показаны в главном меню на кнопке O_O", Toast.LENGTH_LONG).show();
    }

}