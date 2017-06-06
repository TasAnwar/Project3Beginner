package com.example.android.quizapp;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
public class MainActivity extends AppCompatActivity {
    public static final String EXTRA_MESSAGE = "com.example.android.quizapp.MESSAGE";
    String message = "";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button submitButton = (Button) findViewById(R.id.submit_button);
        //Intent to open the solution activity
        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String totMessage;
                int scoreData = scoreCalculator();
                if (scoreData == 7) {
                    totMessage = "Awesome! You got all right!";
                } else {
                    totMessage = "Your score is  " + Integer.toString(scoreData);
                    totMessage = totMessage + "\n" + message;
                }
                Intent solutionIntent = new Intent(MainActivity.this, SolutionActivity.class);
                solutionIntent.putExtra(EXTRA_MESSAGE, totMessage);
                startActivity(solutionIntent);
            }
        });
    }
    public int scoreCalculator() {
        int score = 0;
        message = "";
        //checks answer 1
        RadioButton ventricle = (RadioButton) findViewById(R.id.ventricle_button);
        if (ventricle.isChecked()) {
            score = score + 1;
        } //updates score if right answer
        //solution for the question
        else {
            message = message + "\n" + "The right answer for question 1 is Ventricles.";
        }
        //checks answer2
        EditText answer2 = (EditText) findViewById(R.id.answer2_field);
        String ans2 = answer2.getText().toString().trim();
        String correctAns2 = "Skin";
        if (ans2.equalsIgnoreCase(correctAns2)) {
            score = score + 1;
        }//updates score if right answer
        else {
            message = message + "\n" + "The right answer for question 2 is Skin.";
        }
        //checks answer3
        EditText answer3 = (EditText) findViewById(R.id.answer3_field);
        String ans3 = answer3.getText().toString().trim();
        String correctAns3 = "Larynx";
        if (ans3.equalsIgnoreCase(correctAns3)) {
            score = score + 1;
        }//updates score if right answer
        else {
            message = message + "\n" + "The right answer for question 3 is Larynx.";
        }
        //checks answer4
        RadioButton ribs = (RadioButton) findViewById(R.id.ribs_button);
        Boolean ribsCheck = ribs.isChecked();
        if (ribsCheck) {
            score = score + 1;
        }//updates score if right answer
        else {
            message = message + "\n" + "The right answer for question 4 is Ribs.";
        }
        //checks answer5
        CheckBox hearing = (CheckBox) findViewById(R.id.hearing_box);
        Boolean hearingCheck = hearing.isChecked();
        CheckBox balancing = (CheckBox) findViewById(R.id.balancing_box);
        Boolean balancingCheck = balancing.isChecked();
        CheckBox circulation = (CheckBox) findViewById(R.id.circulation_box);
        Boolean circulationCheck = circulation.isChecked();
        if (hearingCheck && balancingCheck && !circulationCheck) {
            score = score + 1;
        } else {
            message = message + "\n" + "The right answer for question 5 is Hearing,Balancing.";
        }//updates score if right answer
        //checks answer6
        RadioButton vertebrae = (RadioButton) findViewById(R.id.vertebrae_button);
        Boolean vertebraeCheck = vertebrae.isChecked();
        if (vertebraeCheck) {
            score = score + 1;
        } else {
            message = message + "\n" + "The right answer for question 6 is Vertebrae.";
        }//updates score if right answer
        //checks answer5
        RadioButton dhelix = (RadioButton) findViewById(R.id.dh_button);
        Boolean dhelixCheck = dhelix.isChecked();
        if (dhelixCheck) {
            score = score + 1;
        }//updates score if right answer
        else {
            message = message + "\n" + "The right answer for question 7 is Double Helix.";
        }
        return score;
    }
}

