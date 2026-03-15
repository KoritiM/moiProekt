package com.example.moiproekt;

import android.graphics.Color;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.GridLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class AllLayoutsActivity extends AppCompatActivity {

    private LinearLayout mainContainer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Главный ScrollView для прокрутки всех примеров
        ScrollView scrollView = new ScrollView(this);

        // Основной контейнер
        mainContainer = new LinearLayout(this);
        mainContainer.setOrientation(LinearLayout.VERTICAL);
        mainContainer.setPadding(30, 30, 30, 30);

        // Заголовок
        TextView title = new TextView(this);
        title.setText("ВСЕ СПОСОБЫ РАЗМЕТКИ");
        title.setTextSize(24);
        title.setTextColor(Color.BLACK);
        title.setGravity(Gravity.CENTER);
        title.setPadding(0, 0, 0, 40);
        mainContainer.addView(title);

        // ========== 1. LINEARLAYOUT ==========
        addSectionTitle("1. LinearLayout");

        // Простой LinearLayout
        LinearLayout linearSimple = new LinearLayout(this);
        linearSimple.setOrientation(LinearLayout.HORIZONTAL);
        linearSimple.setBackgroundColor(Color.LTGRAY);
        linearSimple.setPadding(20, 20, 20, 20);

        Button btn1 = new Button(this);
        btn1.setText("Кнопка 1");
        Button btn2 = new Button(this);
        btn2.setText("Кнопка 2");

        linearSimple.addView(btn1);
        linearSimple.addView(btn2);
        mainContainer.addView(linearSimple);

        addNote("LinearLayout: элементы в ряд");

        // LinearLayout с весом элемента
        LinearLayout linearWeight = new LinearLayout(this);
        linearWeight.setOrientation(LinearLayout.HORIZONTAL);
        linearWeight.setPadding(20, 20, 20, 20);

        Button btnWeight1 = new Button(this);
        btnWeight1.setText("Вес 1");
        btnWeight1.setBackgroundColor(Color.parseColor("#2196F3"));
        btnWeight1.setTextColor(Color.WHITE);

        Button btnWeight2 = new Button(this);
        btnWeight2.setText("Вес 2 (места в 2 раза больше)");
        btnWeight2.setBackgroundColor(Color.parseColor("#4CAF50"));
        btnWeight2.setTextColor(Color.WHITE);

        LinearLayout.LayoutParams params1 = new LinearLayout.LayoutParams(
                0, LinearLayout.LayoutParams.WRAP_CONTENT, 1.0f
        );
        LinearLayout.LayoutParams params2 = new LinearLayout.LayoutParams(
                0, LinearLayout.LayoutParams.WRAP_CONTENT, 2.0f
        );

        linearWeight.addView(btnWeight1, params1);
        linearWeight.addView(btnWeight2, params2);
        mainContainer.addView(linearWeight);

        addNote("LinearLayout с весом: вторая кнопка занимает в 2 раза больше места");

        // LinearLayout с layout_gravity
        LinearLayout linearGravity = new LinearLayout(this);
        linearGravity.setOrientation(LinearLayout.VERTICAL);
        linearGravity.setBackgroundColor(Color.LTGRAY);
        linearGravity.setPadding(20, 20, 20, 20);

        Button btnGravityLeft = new Button(this);
        btnGravityLeft.setText("Прижато влево (gravity=LEFT)");

        Button btnGravityCenter = new Button(this);
        btnGravityCenter.setText("По центру (gravity=CENTER)");

        Button btnGravityRight = new Button(this);
        btnGravityRight.setText("Прижато вправо (gravity=RIGHT)");

        LinearLayout.LayoutParams leftParams = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.WRAP_CONTENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
        );
        leftParams.gravity = Gravity.LEFT;

        LinearLayout.LayoutParams centerParams = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.WRAP_CONTENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
        );
        centerParams.gravity = Gravity.CENTER_HORIZONTAL;

        LinearLayout.LayoutParams rightParams = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.WRAP_CONTENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
        );
        rightParams.gravity = Gravity.RIGHT;

        linearGravity.addView(btnGravityLeft, leftParams);
        linearGravity.addView(btnGravityCenter, centerParams);
        linearGravity.addView(btnGravityRight, rightParams);
        mainContainer.addView(linearGravity);

        addNote("LinearLayout с layout_gravity: позиционирование внутри контейнера");

        // ========== 2. RELATIVELAYOUT ==========
        addSectionTitle("2. RelativeLayout");

        RelativeLayout relativeLayout = new RelativeLayout(this);
        relativeLayout.setLayoutParams(new RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.MATCH_PARENT,
                350
        ));
        relativeLayout.setBackgroundColor(Color.parseColor("#E0E0E0"));
        relativeLayout.setPadding(20, 20, 20, 20);

        // Создаем кнопки
        Button btnCenter = new Button(this);
        btnCenter.setId(View.generateViewId());
        btnCenter.setText("В ЦЕНТРЕ");
        btnCenter.setBackgroundColor(Color.parseColor("#2196F3"));
        btnCenter.setTextColor(Color.WHITE);

        Button btnAbove = new Button(this);
        btnAbove.setText("НАД центром");
        btnAbove.setBackgroundColor(Color.parseColor("#FF9800"));

        Button btnBelow = new Button(this);
        btnBelow.setText("ПОД центром");
        btnBelow.setBackgroundColor(Color.parseColor("#4CAF50"));

        Button btnLeft = new Button(this);
        btnLeft.setText("СЛЕВА");
        btnLeft.setBackgroundColor(Color.parseColor("#9C27B0"));
        btnLeft.setTextColor(Color.WHITE);

        Button btnRight = new Button(this);
        btnRight.setText("СПРАВА");
        btnRight.setBackgroundColor(Color.parseColor("#E91E63"));
        btnRight.setTextColor(Color.WHITE);

        // Параметры позиционирования
        RelativeLayout.LayoutParams centerParamsRel = new RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.WRAP_CONTENT,
                RelativeLayout.LayoutParams.WRAP_CONTENT
        );
        centerParamsRel.addRule(RelativeLayout.CENTER_IN_PARENT);

        RelativeLayout.LayoutParams aboveParams = new RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.WRAP_CONTENT,
                RelativeLayout.LayoutParams.WRAP_CONTENT
        );
        aboveParams.addRule(RelativeLayout.ABOVE, btnCenter.getId());
        aboveParams.addRule(RelativeLayout.CENTER_HORIZONTAL);

        RelativeLayout.LayoutParams belowParamsRel = new RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.WRAP_CONTENT,
                RelativeLayout.LayoutParams.WRAP_CONTENT
        );
        belowParamsRel.addRule(RelativeLayout.BELOW, btnCenter.getId());
        belowParamsRel.addRule(RelativeLayout.CENTER_HORIZONTAL);

        RelativeLayout.LayoutParams leftParamsRel = new RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.WRAP_CONTENT,
                RelativeLayout.LayoutParams.WRAP_CONTENT
        );
        leftParamsRel.addRule(RelativeLayout.LEFT_OF, btnCenter.getId());
        leftParamsRel.addRule(RelativeLayout.CENTER_VERTICAL);

        RelativeLayout.LayoutParams rightParamsRel = new RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.WRAP_CONTENT,
                RelativeLayout.LayoutParams.WRAP_CONTENT
        );
        rightParamsRel.addRule(RelativeLayout.RIGHT_OF, btnCenter.getId());
        rightParamsRel.addRule(RelativeLayout.CENTER_VERTICAL);

        relativeLayout.addView(btnCenter, centerParamsRel);
        relativeLayout.addView(btnAbove, aboveParams);
        relativeLayout.addView(btnBelow, belowParamsRel);
        relativeLayout.addView(btnLeft, leftParamsRel);
        relativeLayout.addView(btnRight, rightParamsRel);
        mainContainer.addView(relativeLayout);

        addNote("RelativeLayout: элементы располагаются относительно друг друга");

        // ========== 3. TABLELAYOUT ==========
        addSectionTitle("3. TableLayout");

        TableLayout tableLayout = new TableLayout(this);
        tableLayout.setLayoutParams(new TableLayout.LayoutParams(
                TableLayout.LayoutParams.MATCH_PARENT,
                TableLayout.LayoutParams.WRAP_CONTENT
        ));
        tableLayout.setBackgroundColor(Color.parseColor("#F5F5F5"));
        tableLayout.setPadding(20, 20, 20, 20);

        // Строка 1
        TableRow row1 = new TableRow(this);

        TextView cell1 = new TextView(this);
        cell1.setText("Ячейка 1");
        cell1.setPadding(20, 20, 20, 20);
        cell1.setBackgroundColor(Color.WHITE);

        TextView cell2 = new TextView(this);
        cell2.setText("Ячейка 2");
        cell2.setPadding(20, 20, 20, 20);
        cell2.setBackgroundColor(Color.WHITE);

        row1.addView(cell1);
        row1.addView(cell2);

        // Строка 2 с объединением ячеек (layout_span)
        TableRow row2 = new TableRow(this);

        Button spanButton = new Button(this);
        spanButton.setText("Эта кнопка занимает 2 ячейки (layout_span=2)");

        TableRow.LayoutParams spanParams = new TableRow.LayoutParams(
                TableRow.LayoutParams.MATCH_PARENT,
                TableRow.LayoutParams.WRAP_CONTENT
        );
        spanParams.span = 2;

        row2.addView(spanButton, spanParams);

        tableLayout.addView(row1);
        tableLayout.addView(row2);
        mainContainer.addView(tableLayout);

        addNote("TableLayout: таблица, TableRow - ряд, layout_span - объединение ячеек");

        // ========== 4. FRAMELAYOUT ==========
        addSectionTitle("4. FrameLayout");

        FrameLayout frameLayout = new FrameLayout(this);
        frameLayout.setLayoutParams(new FrameLayout.LayoutParams(400, 400));
        frameLayout.setBackgroundColor(Color.parseColor("#E0E0E0"));

        // Красный квадрат (задний план)
        View redSquare = new View(this);
        redSquare.setBackgroundColor(Color.RED);
        FrameLayout.LayoutParams redParams = new FrameLayout.LayoutParams(300, 300);
        redParams.gravity = Gravity.CENTER;

        // Синий квадрат (передний план)
        View blueSquare = new View(this);
        blueSquare.setBackgroundColor(Color.BLUE);
        FrameLayout.LayoutParams blueParams = new FrameLayout.LayoutParams(150, 150);
        blueParams.gravity = Gravity.CENTER;

        // Кнопка в углу
        Button frameBtn = new Button(this);
        frameBtn.setText("Кнопка");
        FrameLayout.LayoutParams btnParams = new FrameLayout.LayoutParams(
                FrameLayout.LayoutParams.WRAP_CONTENT,
                FrameLayout.LayoutParams.WRAP_CONTENT
        );
        btnParams.gravity = Gravity.BOTTOM | Gravity.RIGHT;

        frameLayout.addView(redSquare, redParams);
        frameLayout.addView(blueSquare, blueParams);
        frameLayout.addView(frameBtn, btnParams);
        mainContainer.addView(frameLayout);

        addNote("FrameLayout: элементы кладутся друг на друга, layout_gravity - позиция");

        // ========== 5. GRIDLAYOUT ==========
        addSectionTitle("5. GridLayout");

        GridLayout gridLayout = new GridLayout(this);
        gridLayout.setRowCount(3);
        gridLayout.setColumnCount(3);
        gridLayout.setBackgroundColor(Color.parseColor("#F0F0F0"));
        gridLayout.setPadding(20, 20, 20, 20);

        // Заполняем сетку кнопками
        for (int i = 0; i < 5; i++) {
            Button gridBtn = new Button(this);
            gridBtn.setText("Кн " + (i + 1));

            GridLayout.LayoutParams gridParams = new GridLayout.LayoutParams();
            gridParams.columnSpec = GridLayout.spec(i % 3);
            gridParams.rowSpec = GridLayout.spec(i / 3);
            gridParams.setMargins(5, 5, 5, 5);
            gridParams.width = 150;
            gridParams.height = 100;

            gridLayout.addView(gridBtn, gridParams);
        }

        // Кнопка, объединяющая 2 колонки (layout_columnSpan)
        Button spanGridBtn = new Button(this);
        spanGridBtn.setText("Объединяет 2 колонки");
        spanGridBtn.setBackgroundColor(Color.parseColor("#FF9800"));

        GridLayout.LayoutParams spanGridParams = new GridLayout.LayoutParams();
        spanGridParams.columnSpec = GridLayout.spec(0, 2);
        spanGridParams.rowSpec = GridLayout.spec(2);
        spanGridParams.setMargins(5, 5, 5, 5);
        spanGridParams.width = 0;
        spanGridParams.height = 100;

        gridLayout.addView(spanGridBtn, spanGridParams);
        mainContainer.addView(gridLayout);

        addNote("GridLayout: сетка, rowCount/columnCount, columnSpan/rowSpan");

        // ========== 6. ВЛОЖЕННЫЕ LAYOUT ==========
        addSectionTitle("6. Вложенные layout (include)");

        // Внешний layout
        LinearLayout outerLayout = new LinearLayout(this);
        outerLayout.setOrientation(LinearLayout.VERTICAL);
        outerLayout.setBackgroundColor(Color.parseColor("#FF9800"));
        outerLayout.setPadding(30, 30, 30, 30);

        // Внутренний layout (как будто включен через include)
        LinearLayout innerLayout = new LinearLayout(this);
        innerLayout.setOrientation(LinearLayout.VERTICAL);
        innerLayout.setBackgroundColor(Color.WHITE);
        innerLayout.setPadding(20, 20, 20, 20);

        TextView includeText = new TextView(this);
        includeText.setText("Это как include - вложенный layout");
        includeText.setTextColor(Color.BLACK);
        includeText.setPadding(10, 10, 10, 10);

        Button includeBtn = new Button(this);
        includeBtn.setText("Кнопка внутри include");

        innerLayout.addView(includeText);
        innerLayout.addView(includeBtn);

        outerLayout.addView(innerLayout);
        mainContainer.addView(outerLayout);

        addNote("Вложенные layout: один контейнер внутри другого");

        // ========== 7. GRAVITY ==========
        addSectionTitle("7. Gravity - позиционирование внутри элемента");

        LinearLayout gravityLayout = new LinearLayout(this);
        gravityLayout.setOrientation(LinearLayout.VERTICAL);
        gravityLayout.setBackgroundColor(Color.parseColor("#F5F5F5"));
        gravityLayout.setPadding(20, 20, 20, 20);

        TextView gravityLeft = new TextView(this);
        gravityLeft.setText("Текст прижат к левому краю (Gravity.LEFT)");
        gravityLeft.setGravity(Gravity.LEFT);
        gravityLeft.setBackgroundColor(Color.WHITE);
        gravityLeft.setPadding(20, 20, 20, 20);

        TextView gravityCenter = new TextView(this);
        gravityCenter.setText("Текст по центру (Gravity.CENTER)");
        gravityCenter.setGravity(Gravity.CENTER);
        gravityCenter.setBackgroundColor(Color.WHITE);
        gravityCenter.setPadding(20, 20, 20, 20);

        TextView gravityRight = new TextView(this);
        gravityRight.setText("Текст прижат к правому краю (Gravity.RIGHT)");
        gravityRight.setGravity(Gravity.RIGHT);
        gravityRight.setBackgroundColor(Color.WHITE);
        gravityRight.setPadding(20, 20, 20, 20);

        TextView gravityBottom = new TextView(this);
        gravityBottom.setText("Текст внизу (Gravity.BOTTOM)");
        gravityBottom.setGravity(Gravity.BOTTOM | Gravity.CENTER_HORIZONTAL);
        gravityBottom.setBackgroundColor(Color.WHITE);
        gravityBottom.setPadding(20, 50, 20, 50);

        gravityLayout.addView(gravityLeft);
        gravityLayout.addView(gravityCenter);
        gravityLayout.addView(gravityRight);
        gravityLayout.addView(gravityBottom);
        mainContainer.addView(gravityLayout);

        addNote("Gravity: расположение содержимого внутри элемента");

        // Финальный текст
        TextView finalText = new TextView(this);
        finalText.setText("✓ Все примеры разметки выполнены");
        finalText.setTextSize(18);
        finalText.setTextColor(Color.GREEN);
        finalText.setGravity(Gravity.CENTER);
        finalText.setPadding(0, 50, 0, 50);
        mainContainer.addView(finalText);

        scrollView.addView(mainContainer);
        setContentView(scrollView);
    }

    // Метод для добавления заголовков разделов
    private void addSectionTitle(String title) {
        TextView sectionTitle = new TextView(this);
        sectionTitle.setText(title);
        sectionTitle.setTextSize(20);
        sectionTitle.setTextColor(Color.BLACK);
        sectionTitle.setTypeface(null, android.graphics.Typeface.BOLD);
        sectionTitle.setPadding(0, 40, 0, 10);
        mainContainer.addView(sectionTitle);
    }

    // Метод для добавления пояснений
    private void addNote(String note) {
        TextView noteView = new TextView(this);
        noteView.setText("  " + note);
        noteView.setTextSize(14);
        noteView.setTextColor(Color.DKGRAY);
        noteView.setPadding(20, 5, 20, 20);
        mainContainer.addView(noteView);
    }
}