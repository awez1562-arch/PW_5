package com.example.multiwindowlab;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class TAboutActivity extends AppCompatActivity {

    private Button btnBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);

        // Инициализация кнопки
        btnBack = findViewById(R.id.btnBack);

        // Обработчик кнопки "Назад"
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Просто закрываем Activity и возвращаемся к предыдущей
                finish();
            }
        });
    }
}