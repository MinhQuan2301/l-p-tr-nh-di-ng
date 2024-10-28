package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.nfc.Tag;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private Button mbuttonTrue;
    private Button mbuttonFalse;
    private ImageButton mbuttonNext;
    private Button mbuttonCheat;
    private TextView Vquest;
    private int bien = 0; // Start at 0 to access first question
    private Question[] array;
    private static final String KEY_INDEX = "index";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mbuttonTrue = findViewById(R.id.button_true);
        mbuttonFalse = findViewById(R.id.button_false);
        mbuttonCheat = findViewById(R.id.button_cheat);
        Vquest = findViewById(R.id.View);
        mbuttonNext = findViewById(R.id.button_next);

        array = new Question[]{
                new Question(getString(R.string.quiz_name), true),
                new Question(getString(R.string.quiz1_name), false),
                new Question(getString(R.string.quiz2_name), true),
                new Question(getString(R.string.quiz3_name), false),
                new Question(getString(R.string.quiz4_name), true)
        };

        // Display the first question initially
        Vquest.setText(array[bien].getQuestionText());

        mbuttonTrue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checkAnswer(true);
            }
        });

        mbuttonFalse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checkAnswer(false);
            }
        });

        mbuttonNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (bien < array.length - 1) {
                    bien++; // Move to the next question
                    Vquest.setText(array[bien].getQuestionText());
                } else {
                    Toast.makeText(MainActivity.this, "No more questions!", Toast.LENGTH_SHORT).show();
                }
            }
        });
        mbuttonCheat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, CheatActivity.class);
                startActivity(i);
            }
        });

        mbuttonCheat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boolean answer = array[bien].isAnswerTrue();
                Intent i = CheatActivity.newIntent(MainActivity.this, answer);
                startActivity(i);
            }
        });
    }

    private void checkAnswer(boolean answer) {
        // Check if the current answer matches the correct answer
        boolean correctAnswer = array[bien].isAnswerTrue();
        if (answer == correctAnswer) {
            Toast.makeText(MainActivity.this, R.string.string_true_name, Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(MainActivity.this, R.string.string_false_name, Toast.LENGTH_SHORT).show();
        }
    }
}