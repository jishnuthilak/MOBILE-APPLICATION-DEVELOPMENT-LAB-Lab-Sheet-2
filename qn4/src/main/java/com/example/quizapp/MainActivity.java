package com.example.quizapp;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    CheckBox checkboxJava, checkboxPython, checkboxHtml;
    RadioGroup radioGroup;
    RadioButton radioParis;
    Button submitButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize views
        checkboxJava = findViewById(R.id.checkbox_java);
        checkboxPython = findViewById(R.id.checkbox_python);
        checkboxHtml = findViewById(R.id.checkbox_html);
        radioGroup = findViewById(R.id.radioGroup);
        radioParis = findViewById(R.id.radio_paris);
        submitButton = findViewById(R.id.submit_button);

        // Set onClickListener for Submit Button
        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int score = 0;

                // Check answers for Question 1 (CheckBox)
                if (checkboxJava.isChecked()) {
                    score += 1;
                }
                if (checkboxPython.isChecked()) {
                    score += 1;
                }
                if (checkboxHtml.isChecked()) {
                    // Incorrect answer, do not add points
                }

                // Check answer for Question 2 (RadioButton)
                if (radioParis.isChecked()) {
                    score += 1;
                }

                // Display the score using a Toast
                Toast.makeText(MainActivity.this, "Your score: " + score + "/3", Toast.LENGTH_LONG).show();
            }
        });
    }
}
