package com.example.moiproekt;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class perehod1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_perehod1);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    // ЭТО ЕДИНСТВЕННЫЙ МЕТОД ДЛЯ ПЕРЕХОДА
    public void openSecondWindow(View view) {
        try {
            // Получаем значения из полей ввода
            EditText namet = findViewById(R.id.name);
            EditText aget = findViewById(R.id.age);
            EditText groupt = findViewById(R.id.group);

            String name = namet.getText().toString().trim();
            String ageStr = aget.getText().toString().trim();
            String group = groupt.getText().toString().trim();

            Log.d("TEST", "Name: '" + name + "'");
            Log.d("TEST", "Age: '" + ageStr + "'");
            Log.d("TEST", "Group: '" + group + "'");

            // Проверяем, что поля не пустые
            if (name.isEmpty() || ageStr.isEmpty() || group.isEmpty()) {
                Toast.makeText(this, "Заполните все поля", Toast.LENGTH_SHORT).show();
                return;
            }

            // Создаем Intent для перехода
            Intent intent = new Intent(this, perehod2.class);

            // Передаем данные
            intent.putExtra("name", name);
            intent.putExtra("age", Integer.parseInt(ageStr));
            intent.putExtra("group", group);

            Log.d("TEST", "Отправляем данные в perehod2");

            // Запускаем новую активность
            startActivity(intent);

        } catch (NumberFormatException e) {
            Toast.makeText(this, "Введите корректный возраст (число)", Toast.LENGTH_SHORT).show();
            Log.d("TEST", "Ошибка возраста: " + e.getMessage());
        }
    }

    @Override
    protected void onStart(){
        super.onStart();
        Log.i("logstart", "onStart: a");
    }

    @Override
    protected void onResume(){
        super.onResume();
        Log.i("logresum", "onResume: a");
    }

    @Override
    protected void onPause(){
        super.onPause();
        Log.i("logpause", "onPause: a");
    }

    @Override
    protected void onStop(){
        super.onStop();
        Log.i("logstop", "onStop: a");
    }

    @Override
    protected void onDestroy(){
        super.onDestroy();
        Log.i("logdestr", "onDestroy: a");
    }
}