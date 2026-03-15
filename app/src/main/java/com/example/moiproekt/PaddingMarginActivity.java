package com.example.moiproekt;

import android.graphics.Color;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class PaddingMarginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Главный контейнер
        LinearLayout mainLayout = new LinearLayout(this);
        mainLayout.setLayoutParams(new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.MATCH_PARENT
        ));
        mainLayout.setOrientation(LinearLayout.VERTICAL);
        mainLayout.setPadding(30, 50, 30, 30);
        mainLayout.setBackgroundColor(Color.parseColor("#F5F5F5")); // Светло-серый фон

        // ===== ЗАГОЛОВОК =====
        TextView title = new TextView(this);
        title.setText("Демонстрация отступов");
        title.setTextSize(24);
        title.setTextColor(Color.BLACK);
        title.setGravity(Gravity.CENTER);
        title.setPadding(0, 0, 0, 40);
        mainLayout.addView(title);

        // ===== ПРИМЕР 1: PADDING (внутренние отступы) =====
        TextView paddingTitle = new TextView(this);
        paddingTitle.setText("1. PADDING - внутренние отступы");
        paddingTitle.setTextSize(18);
        paddingTitle.setTextColor(Color.BLUE);
        paddingTitle.setPadding(0, 20, 0, 10);
        mainLayout.addView(paddingTitle);

        // Контейнер для наглядности
        LinearLayout paddingContainer = new LinearLayout(this);
        paddingContainer.setBackgroundColor(Color.LTGRAY);
        paddingContainer.setPadding(20, 20, 20, 20);

        // Кнопка с PADDING (текст отодвинут от краев)
        Button btnPadding = new Button(this);
        btnPadding.setText("Кнопка с PADDING 50px");
        btnPadding.setPadding(50, 50, 50, 50); // Внутренние отступы
        btnPadding.setBackgroundColor(Color.parseColor("#2196F3"));
        btnPadding.setTextColor(Color.WHITE);
        btnPadding.setOnClickListener(v ->
                Toast.makeText(this, "Padding: 50px со всех сторон", Toast.LENGTH_SHORT).show()
        );

        LinearLayout.LayoutParams params1 = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
        );
        btnPadding.setLayoutParams(params1);
        paddingContainer.addView(btnPadding);
        mainLayout.addView(paddingContainer);

        // Пояснение
        TextView paddingDesc = new TextView(this);
        paddingDesc.setText("   • Текст отодвинут от краев кнопки на 50px\n   • Зона внутри кнопки увеличена");
        paddingDesc.setTextColor(Color.DKGRAY);
        paddingDesc.setPadding(20, 10, 20, 30);
        mainLayout.addView(paddingDesc);

        // ===== ПРИМЕР 2: MARGIN (внешние отступы) =====
        TextView marginTitle = new TextView(this);
        marginTitle.setText("2. MARGIN - внешние отступы");
        marginTitle.setTextSize(18);
        marginTitle.setTextColor(Color.BLUE);
        marginTitle.setPadding(0, 20, 0, 10);
        mainLayout.addView(marginTitle);

        // Первая кнопка (без margin для сравнения)
        Button btnNormal = new Button(this);
        btnNormal.setText("Кнопка без отступов");
        btnNormal.setBackgroundColor(Color.parseColor("#9C27B0"));
        btnNormal.setTextColor(Color.WHITE);
        LinearLayout.LayoutParams paramsNormal = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
        );
        btnNormal.setLayoutParams(paramsNormal);
        mainLayout.addView(btnNormal);

        // Вторая кнопка с MARGIN
        Button btnMargin = new Button(this);
        btnMargin.setText("Кнопка с MARGIN 50px");
        btnMargin.setBackgroundColor(Color.parseColor("#FF9800"));
        btnMargin.setTextColor(Color.WHITE);

        LinearLayout.LayoutParams paramsMargin = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
        );
        paramsMargin.setMargins(50, 50, 50, 50); // Внешние отступы
        btnMargin.setLayoutParams(paramsMargin);
        btnMargin.setOnClickListener(v ->
                Toast.makeText(this, "Margin: 50px со всех сторон", Toast.LENGTH_SHORT).show()
        );
        mainLayout.addView(btnMargin);

        // Пояснение
        TextView marginDesc = new TextView(this);
        marginDesc.setText("   • Кнопка отодвинута от других элементов на 50px\n   • Видно расстояние по краям");
        marginDesc.setTextColor(Color.DKGRAY);
        marginDesc.setPadding(20, 10, 20, 30);
        mainLayout.addView(marginDesc);

        // ===== ПРИМЕР 3: PADDING + MARGIN ВМЕСТЕ =====
        TextView bothTitle = new TextView(this);
        bothTitle.setText("3. PADDING + MARGIN вместе");
        bothTitle.setTextSize(18);
        bothTitle.setTextColor(Color.BLUE);
        bothTitle.setPadding(0, 20, 0, 10);
        mainLayout.addView(bothTitle);

        Button btnBoth = new Button(this);
        btnBoth.setText("Padding 30px + Margin 30px");
        btnBoth.setPadding(30, 30, 30, 30); // Внутренние

        LinearLayout.LayoutParams paramsBoth = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
        );
        paramsBoth.setMargins(30, 30, 30, 30); // Внешние
        btnBoth.setLayoutParams(paramsBoth);

        btnBoth.setBackgroundColor(Color.parseColor("#E91E63"));
        btnBoth.setTextColor(Color.WHITE);
        btnBoth.setOnClickListener(v ->
                Toast.makeText(this, "Padding и Margin по 30px", Toast.LENGTH_SHORT).show()
        );
        mainLayout.addView(btnBoth);

        // Пояснение
        TextView bothDesc = new TextView(this);
        bothDesc.setText("   • Padding: текст отодвинут от краев\n   • Margin: кнопка отодвинута от соседей");
        bothDesc.setTextColor(Color.DKGRAY);
        bothDesc.setPadding(20, 10, 20, 30);
        mainLayout.addView(bothDesc);

        // ===== ИТОГ =====
        TextView summary = new TextView(this);
        summary.setText("ИТОГ:\n• Padding - расстояние ОТ границы ДО содержимого (внутри)\n• Margin - расстояние ОТ границы ДО других элементов (снаружи)");
        summary.setTextSize(16);
        summary.setTextColor(Color.BLACK);
        summary.setBackgroundColor(Color.WHITE);
        summary.setPadding(30, 30, 30, 30);
        summary.setGravity(Gravity.CENTER);

        LinearLayout.LayoutParams summaryParams = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
        );
        summaryParams.setMargins(0, 30, 0, 30);
        summary.setLayoutParams(summaryParams);
        mainLayout.addView(summary);

        setContentView(mainLayout);
    }
}