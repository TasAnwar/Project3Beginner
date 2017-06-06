package com.example.android.quizapp;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;
public class SolutionActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_solution);
        Intent solutionIntent = getIntent();
        String message = solutionIntent.getStringExtra(MainActivity.EXTRA_MESSAGE);
        TextView solText = (TextView) findViewById(R.id.solution_text);
        solText.setText(message);
    }
}
