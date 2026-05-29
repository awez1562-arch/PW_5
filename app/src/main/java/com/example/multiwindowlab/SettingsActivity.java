package com.example.multiwindowlab;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import androidx.appcompat.app.AppCompatActivity;

public class SettingsActivity extends AppCompatActivity {

    private RadioGroup radioGroupColor;
    private Button btnSave;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        radioGroupColor = findViewById(R.id.radioGroupColor);
        btnSave = findViewById(R.id.btnSave);

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int selectedId = radioGroupColor.getCheckedRadioButtonId();
                String selectedColor = "red"; // по умолчанию

                if (selectedId == R.id.radioGreen) {
                    selectedColor = "green";
                } else if (selectedId == R.id.radioBlue) {
                    selectedColor = "blue";
                }

                Intent resultIntent = new Intent();
                resultIntent.putExtra("COLOR", selectedColor);
                setResult(RESULT_OK, resultIntent);
                finish(); // закрываем SettingsActivity и возвращаемся к MainActivity
            }
        });
    }
}
