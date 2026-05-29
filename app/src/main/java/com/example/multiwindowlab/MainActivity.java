package com.example.multiwindowlab;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private static final int REQUEST_CODE_SETTINGS = 1;
    private TextView tvResult;
    private View mainLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnSettings = findViewById(R.id.btnSettings);
        Button btnAbout = findViewById(R.id.btnAbout);
        tvResult = findViewById(R.id.tvResult);
        mainLayout = findViewById(R.id.main); // если задан id для корневого layout

        btnSettings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, SettingsActivity.class);
                startActivityForResult(intent, REQUEST_CODE_SETTINGS);
            }
        });

        btnAbout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, AboutActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_CODE_SETTINGS) {
            if (resultCode == RESULT_OK && data != null) {
                String color = data.getStringExtra("COLOR");
                tvResult.setText("Выбран цвет: " + color);

                // Изменяем цвет фона в зависимости от выбранного цвета
                switch (color) {
                    case "red":
                        mainLayout.setBackgroundColor(getResources().getColor(android.R.color.holo_red_light));
                        break;
                    case "green":
                        mainLayout.setBackgroundColor(getResources().getColor(android.R.color.holo_green_light));
                        break;
                    case "blue":
                        mainLayout.setBackgroundColor(getResources().getColor(android.R.color.holo_blue_light));
                        break;
                }
            }
        }
    }
}