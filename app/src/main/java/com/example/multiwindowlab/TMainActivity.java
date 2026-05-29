package com.example.multiwindowlab;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class TMainActivity extends AppCompatActivity {

    private static final int REQUEST_CODE_SETTINGS = 1;

    private LinearLayout mainLayout;
    private TextView tvInfo;
    private Button btnSettings;
    private Button btnAbout;

    private String currentColorName = "Белый";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.taskactivity_main);

        // Инициализация элементов
        mainLayout = findViewById(R.id.mainLayout);
        tvInfo = findViewById(R.id.tvInfo);
        btnSettings = findViewById(R.id.btnSettings);
        btnAbout = findViewById(R.id.btnAbout);

        // Обработчик кнопки "Настройки"
        btnSettings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Запускаем Activity настроек с ожиданием результата
                Intent intent = new Intent(TMainActivity.this, TSettingsActivity.class);
                startActivityForResult(intent, REQUEST_CODE_SETTINGS);
            }
        });

        // Обработчик кнопки "Об авторе"
        btnAbout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Запускаем Activity "Об авторе" без ожидания результата
                Intent intent = new Intent(TMainActivity.this, AboutActivity.class);
                startActivity(intent);
            }
        });
    }

    // Обработка результата из SettingsActivity
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == REQUEST_CODE_SETTINGS) {
            if (resultCode == RESULT_OK && data != null) {
                // Получаем данные из результата
                String colorName = data.getStringExtra("COLOR_NAME");
                int colorValue = data.getIntExtra("COLOR_VALUE", Color.WHITE);

                // Применяем цвет фона
                mainLayout.setBackgroundColor(colorValue);
                currentColorName = colorName;

                // Обновляем информацию
                tvInfo.setText("Текущий цвет фона: " + colorName);
            }
        }
    }
}