package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {
    private Button mbuttonTrue;
    private  Button mbuttonFalse;
    private Button mbuttonNext;
    private TextView Vquest;
    private int bien = 1;
    private String anser= "True";
    private String [][] array;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mbuttonTrue = findViewById(R.id.button_true);
        mbuttonFalse = findViewById(R.id.button_false);

        array = new String[][]{
                {getString(R.string.quiz_name), ("True")},
                {getString(R.string.quiz1_name), ("False")},
                {getString(R.string.quiz2_name),("True")},
                {getString(R.string.quiz3_name),("False")},
                {getString(R.string.quiz4_name),("True")}};
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

        Vquest = findViewById(R.id.View);
        mbuttonNext = findViewById(R.id.button_next);
        mbuttonNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(bien < array.length){
                    String s = array[bien][0];
                    Vquest.setText(s);
                    bien++;
                } else{
                    Vquest.setText(R.string.name);
                }

            }
        });
    }
    private void checkAnswer( String answer){
         String a = array[bien][1];
        if (answer.equals(a)) {
            Toast.makeText(MainActivity.this, R.string.string_true_name, Toast.LENGTH_LONG).show();
        } else {
            Toast.makeText(MainActivity.this, R.string.string_false_name, Toast.LENGTH_LONG).show();
        }
    }
}