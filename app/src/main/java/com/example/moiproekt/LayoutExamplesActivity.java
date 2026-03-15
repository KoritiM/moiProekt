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

public class LayoutExamplesActivity extends AppCompatActivity {

    private LinearLayout mainContainer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ScrollView scrollView = new ScrollView(this);
        mainContainer = new LinearLayout(this);
        mainContainer.setOrientation(LinearLayout.VERTICAL);
        mainContainer.setPadding(30, 30, 30, 30);

        // 1. LinearLayout
        TextView title1 = new TextView(this);
        title1.setText("1. LinearLayout");
        title1.setTextSize(18);
        title1.setTextColor(Color.BLACK);
        title1.setPadding(0, 30, 0, 10);
        mainContainer.addView(title1);

        LinearLayout linearSimple = new LinearLayout(this);
        linearSimple.setOrientation(LinearLayout.HORIZONTAL);
        linearSimple.setBackgroundColor(Color.parseColor("#E0E0E0"));
        linearSimple.setPadding(20, 20, 20, 20);

        Button btn1 = new Button(this);
        btn1.setText("Кнопка 1");
        Button btn2 = new Button(this);
        btn2.setText("Кнопка 2");

        linearSimple.addView(btn1);
        linearSimple.addView(btn2);
        mainContainer.addView(linearSimple);

        LinearLayout linearWeight = new LinearLayout(this);
        linearWeight.setOrientation(LinearLayout.HORIZONTAL);
        linearWeight.setPadding(20, 20, 20, 20);

        Button btnWeight1 = new Button(this);
        btnWeight1.setText("Вес 1");
        btnWeight1.setBackgroundColor(Color.parseColor("#2196F3"));
        btnWeight1.setTextColor(Color.WHITE);

        Button btnWeight2 = new Button(this);
        btnWeight2.setText("Вес 2");
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

        LinearLayout linearGravity = new LinearLayout(this);
        linearGravity.setOrientation(LinearLayout.VERTICAL);
        linearGravity.setBackgroundColor(Color.LTGRAY);
        linearGravity.setPadding(20, 20, 20, 20);

        Button btnGravity1 = new Button(this);
        btnGravity1.setText("Влево");
        Button btnGravity2 = new Button(this);
        btnGravity2.setText("Центр");
        Button btnGravity3 = new Button(this);
        btnGravity3.setText("Вправо");

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

        linearGravity.addView(btnGravity1, leftParams);
        linearGravity.addView(btnGravity2, centerParams);
        linearGravity.addView(btnGravity3, rightParams);
        mainContainer.addView(linearGravity);

        // 2. RelativeLayout
        TextView title2 = new TextView(this);
        title2.setText("2. RelativeLayout");
        title2.setTextSize(18);
        title2.setTextColor(Color.BLACK);
        title2.setPadding(0, 30, 0, 10);
        mainContainer.addView(title2);

        RelativeLayout relativeLayout = new RelativeLayout(this);
        relativeLayout.setLayoutParams(new RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.MATCH_PARENT,
                300
        ));
        relativeLayout.setBackgroundColor(Color.parseColor("#E0E0E0"));
        relativeLayout.setPadding(20, 20, 20, 20);

        Button btnCenter = new Button(this);
        btnCenter.setId(View.generateViewId());
        btnCenter.setText("Центр");
        Button btnAbove = new Button(this);
        btnAbove.setText("Над");
        Button btnBelow = new Button(this);
        btnBelow.setText("Под");
        Button btnLeft = new Button(this);
        btnLeft.setText("Лево");
        Button btnRight = new Button(this);
        btnRight.setText("Право");

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

        // 3. TableLayout
        TextView title3 = new TextView(this);
        title3.setText("3. TableLayout");
        title3.setTextSize(18);
        title3.setTextColor(Color.BLACK);
        title3.setPadding(0, 30, 0, 10);
        mainContainer.addView(title3);

        TableLayout tableLayout = new TableLayout(this);
        tableLayout.setLayoutParams(new TableLayout.LayoutParams(
                TableLayout.LayoutParams.MATCH_PARENT,
                TableLayout.LayoutParams.WRAP_CONTENT
        ));
        tableLayout.setBackgroundColor(Color.parseColor("#F5F5F5"));
        tableLayout.setPadding(20, 20, 20, 20);

        TableRow row1 = new TableRow(this);
        TextView tv1 = new TextView(this);
        tv1.setText("Ячейка 1");
        tv1.setPadding(10, 10, 10, 10);
        tv1.setBackgroundColor(Color.WHITE);
        TextView tv2 = new TextView(this);
        tv2.setText("Ячейка 2");
        tv2.setPadding(10, 10, 10, 10);
        tv2.setBackgroundColor(Color.WHITE);
        row1.addView(tv1);
        row1.addView(tv2);

        TableRow row2 = new TableRow(this);
        Button spanButton = new Button(this);
        spanButton.setText("Объединение ячеек");
        TableRow.LayoutParams spanParams = new TableRow.LayoutParams(
                TableRow.LayoutParams.MATCH_PARENT,
                TableRow.LayoutParams.WRAP_CONTENT
        );
        spanParams.span = 2;
        row2.addView(spanButton, spanParams);

        tableLayout.addView(row1);
        tableLayout.addView(row2);
        mainContainer.addView(tableLayout);

        // 4. FrameLayout
        TextView title4 = new TextView(this);
        title4.setText("4. FrameLayout");
        title4.setTextSize(18);
        title4.setTextColor(Color.BLACK);
        title4.setPadding(0, 30, 0, 10);
        mainContainer.addView(title4);

        FrameLayout frameLayout = new FrameLayout(this);
        frameLayout.setLayoutParams(new FrameLayout.LayoutParams(400, 400));
        frameLayout.setBackgroundColor(Color.parseColor("#E0E0E0"));

        View redSquare = new View(this);
        redSquare.setBackgroundColor(Color.RED);
        FrameLayout.LayoutParams redParams = new FrameLayout.LayoutParams(300, 300);
        redParams.gravity = Gravity.CENTER;

        View blueSquare = new View(this);
        blueSquare.setBackgroundColor(Color.BLUE);
        FrameLayout.LayoutParams blueParams = new FrameLayout.LayoutParams(150, 150);
        blueParams.gravity = Gravity.CENTER;

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

        // 5. GridLayout
        TextView title5 = new TextView(this);
        title5.setText("5. GridLayout");
        title5.setTextSize(18);
        title5.setTextColor(Color.BLACK);
        title5.setPadding(0, 30, 0, 10);
        mainContainer.addView(title5);

        GridLayout gridLayout = new GridLayout(this);
        gridLayout.setRowCount(3);
        gridLayout.setColumnCount(3);
        gridLayout.setBackgroundColor(Color.parseColor("#F0F0F0"));
        gridLayout.setPadding(20, 20, 20, 20);

        for (int i = 0; i < 5; i++) {
            Button gridBtn = new Button(this);
            gridBtn.setText(String.valueOf(i + 1));
            GridLayout.LayoutParams gridParams = new GridLayout.LayoutParams();
            gridParams.columnSpec = GridLayout.spec(i % 3);
            gridParams.rowSpec = GridLayout.spec(i / 3);
            gridParams.setMargins(5, 5, 5, 5);
            gridParams.width = 150;
            gridParams.height = 100;
            gridLayout.addView(gridBtn, gridParams);
        }

        Button spanGridBtn = new Button(this);
        spanGridBtn.setText("2 колонки");
        GridLayout.LayoutParams spanGridParams = new GridLayout.LayoutParams();
        spanGridParams.columnSpec = GridLayout.spec(0, 2);
        spanGridParams.rowSpec = GridLayout.spec(2);
        spanGridParams.setMargins(5, 5, 5, 5);
        spanGridParams.width = 0;
        spanGridParams.height = 100;
        gridLayout.addView(spanGridBtn, spanGridParams);
        mainContainer.addView(gridLayout);

        // 6. Вложенные layout
        TextView title6 = new TextView(this);
        title6.setText("6. Вложенные layout");
        title6.setTextSize(18);
        title6.setTextColor(Color.BLACK);
        title6.setPadding(0, 30, 0, 10);
        mainContainer.addView(title6);

        LinearLayout outerLayout = new LinearLayout(this);
        outerLayout.setOrientation(LinearLayout.VERTICAL);
        outerLayout.setBackgroundColor(Color.parseColor("#FF9800"));
        outerLayout.setPadding(30, 30, 30, 30);

        LinearLayout innerLayout = new LinearLayout(this);
        innerLayout.setOrientation(LinearLayout.VERTICAL);
        innerLayout.setBackgroundColor(Color.WHITE);
        innerLayout.setPadding(20, 20, 20, 20);

        Button innerBtn1 = new Button(this);
        innerBtn1.setText("Кнопка 1");
        Button innerBtn2 = new Button(this);
        innerBtn2.setText("Кнопка 2");

        innerLayout.addView(innerBtn1);
        innerLayout.addView(innerBtn2);
        outerLayout.addView(innerLayout);
        mainContainer.addView(outerLayout);

        // 7. Gravity
        TextView title7 = new TextView(this);
        title7.setText("7. Gravity");
        title7.setTextSize(18);
        title7.setTextColor(Color.BLACK);
        title7.setPadding(0, 30, 0, 10);
        mainContainer.addView(title7);

        LinearLayout gravityLayout = new LinearLayout(this);
        gravityLayout.setOrientation(LinearLayout.VERTICAL);
        gravityLayout.setBackgroundColor(Color.parseColor("#F5F5F5"));
        gravityLayout.setPadding(20, 20, 20, 20);

        TextView textLeft = new TextView(this);
        textLeft.setText("Влево");
        textLeft.setGravity(Gravity.LEFT);
        textLeft.setBackgroundColor(Color.WHITE);
        textLeft.setPadding(20, 20, 20, 20);

        TextView textCenter = new TextView(this);
        textCenter.setText("Центр");
        textCenter.setGravity(Gravity.CENTER);
        textCenter.setBackgroundColor(Color.WHITE);
        textCenter.setPadding(20, 20, 20, 20);

        TextView textRight = new TextView(this);
        textRight.setText("Вправо");
        textRight.setGravity(Gravity.RIGHT);
        textRight.setBackgroundColor(Color.WHITE);
        textRight.setPadding(20, 20, 20, 20);

        TextView textBottom = new TextView(this);
        textBottom.setText("Внизу");
        textBottom.setGravity(Gravity.BOTTOM | Gravity.CENTER_HORIZONTAL);
        textBottom.setBackgroundColor(Color.WHITE);
        textBottom.setPadding(20, 50, 20, 50);

        gravityLayout.addView(textLeft);
        gravityLayout.addView(textCenter);
        gravityLayout.addView(textRight);
        gravityLayout.addView(textBottom);
        mainContainer.addView(gravityLayout);

        scrollView.addView(mainContainer);
        setContentView(scrollView);
    }
}