package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EdgeEffect;
import android.widget.TextView;

import com.google.android.material.internal.EdgeToEdgeUtils;

public class CheatActivity extends AppCompatActivity {
    private TextView mTextViewAnswer;
    private Button mButtonShow;
    private static final String EXTRA_SWER ="Minh.Quan";
    private boolean mAnswer;
    public static Intent newIntent(Context pakageContext, boolean answer){
        Intent i = new Intent(pakageContext, CheatActivity.class);
        i.putExtra(EXTRA_SWER, answer);
        return i;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cheat);

        mAnswer = getIntent().getBooleanExtra(EXTRA_SWER, false);
        mTextViewAnswer = findViewById(R.id.mTextViewAnswer);
    }
}