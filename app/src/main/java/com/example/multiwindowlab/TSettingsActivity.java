package com.example.multiwindowlab;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import androidx.appcompat.app.AppCompatActivity;

public class TSettingsActivity extends AppCompatActivity {

    private RadioGroup radioGroupColor;
    private Button btnSave;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.taskactivity_settings);

        // Инициализация элементов
        radioGroupColor = findViewById(R.id.radioGroupColor);
        btnSave = findViewById(R.id.btnSave);

        // Обработчик кнопки "Применить"
        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                applyColorAndReturn();
            }
        });
    }

    // Метод применения выбранного цвета и возврата результата
    private void applyColorAndReturn() {
        int selectedId = radioGroupColor.getCheckedRadioButtonId();

        String colorName = "Белый";
        int colorValue = Color.WHITE;

        // Определяем выбранный цвет
        if (selectedId == R.id.radioWhite) {
            colorName = "Белый";
            colorValue = Color.WHITE;
        } else if (selectedId == R.id.radioRed) {
            colorName = "Красный";
            colorValue = Color.RED;
        } else if (selectedId == R.id.radioGreen) {
            colorName = "Зелёный";
            colorValue = Color.GREEN;
        } else if (selectedId == R.id.radioBlue) {
            colorName = "Синий";
            colorValue = Color.BLUE;
        } else if (selectedId == R.id.radioYellow) {
            colorName = "Жёлтый";
            colorValue = Color.YELLOW;
        } else if (selectedId == R.id.radioCyan) {
            colorName = "Голубой";
            colorValue = Color.CYAN;
        } else if (selectedId == R.id.radioBlack) {
            colorName = "Чёрный";
            colorValue = Color.BLACK;
        }

        // Создаём Intent для возврата данных
        Intent resultIntent = new Intent();
        resultIntent.putExtra("COLOR_NAME", colorName);
        resultIntent.putExtra("COLOR_VALUE", colorValue);

        // Устанавливаем результат и закрываем Activity
        setResult(RESULT_OK, resultIntent);
        finish();
    }
}