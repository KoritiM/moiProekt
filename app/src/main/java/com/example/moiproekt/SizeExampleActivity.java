package com.example.moiproekt;

import android.os.Bundle;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import androidx.appcompat.app.AppCompatActivity;

public class SizeExampleActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        LinearLayout layout = new LinearLayout(this);
        layout.setOrientation(LinearLayout.VERTICAL);

        // Кнопка с фиксированными размерами в пикселях
        Button button1 = new Button(this);
        button1.setLayoutParams(new LinearLayout.LayoutParams(300, 150));
        button1.setText("300x150 px");

        // Кнопка с размерами в dp (конвертируем)
        Button button2 = new Button(this);
        int widthDp = 200;
        int heightDp = 80;
        float density = getResources().getDisplayMetrics().density;
        int widthPx = (int)(widthDp * density);
        int heightPx = (int)(heightDp * density);

        button2.setLayoutParams(new LinearLayout.LayoutParams(widthPx, heightPx));
        button2.setText(widthDp + "x" + heightDp + " dp");

        layout.addView(button1);
        layout.addView(button2);

        setContentView(layout);
    }
}