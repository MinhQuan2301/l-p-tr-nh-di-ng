package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private Button mbuttonTrue;
    private Button mbuttonFalse;
    private Button mbuttonNext;
    private TextView Vquest;
    private int bien = 0; // Start at 0 to access first question
    private String[][] array;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mbuttonTrue = findViewById(R.id.button_true);
        mbuttonFalse = findViewById(R.id.button_false);
        Vquest = findViewById(R.id.View);
        mbuttonNext = findViewById(R.id.button_next);

        array = new String[][]{
                {getString(R.string.quiz_name), "True"},
                {getString(R.string.quiz1_name), "False"},
                {getString(R.string.quiz2_name), "True"},
                {getString(R.string.quiz3_name), "False"},
                {getString(R.string.quiz4_name), "True"}
        };

        // Display the first question initially
        Vquest.setText(array[bien][0]);

        mbuttonTrue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checkAnswer("True");
            }
        });

        mbuttonFalse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checkAnswer("False");
            }
        });

        mbuttonNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (bien < array.length - 1) {
                    bien++; // Move to the next question
                    Vquest.setText(array[bien][0]);
                } else {
                    Toast.makeText(MainActivity.this, "No more questions!", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void checkAnswer(String answer) {
        // Check if the current answer matches the correct answer
        String correctAnswer = array[bien][1];
        if (answer.equals(correctAnswer)) {
            Toast.makeText(MainActivity.this, R.string.string_true_name, Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(MainActivity.this, R.string.string_false_name, Toast.LENGTH_SHORT).show();
        }
    }
}