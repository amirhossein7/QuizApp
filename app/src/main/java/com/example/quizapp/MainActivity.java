package com.example.quizapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.os.Bundle;
import android.view.View;

import com.example.quizapp.databinding.ActivityMainBinding;
import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;

    private QuestionModel[] questionBank = {
            new QuestionModel("q1", true),
            new QuestionModel("q2", false),
            new QuestionModel("q3", true),
            new QuestionModel("q4", false)
    };

    private int qIndex = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Initial binding variable
        binding = DataBindingUtil.setContentView(this , R.layout.activity_main);

        // Set first question by default
        binding.textView.setText(questionBank[qIndex].getQuestion());

        // Set listeners for buttons
        binding.buttonNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clickNext(view);
            }
        });

        binding.buttonPrevious.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clickPrevious(view);
            }
        });

        binding.buttonTrue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clickTrue(view);
            }
        });

        binding.buttonFalse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clickFalse(view);
            }
        });
    }


    private void clickNext(View view) {
        if (qIndex < questionBank.length-1){
            qIndex += 1;
            setQuestion();
        }
        System.out.println("click next");
    }

    private void clickPrevious(View view) {
        if (qIndex > 0){
            qIndex -= 1;
            setQuestion();
        }
        System.out.println("click previous");
    }

    private void clickTrue(View view) {
        checkAnswer(view, Boolean.TRUE);
        System.out.println("click true");
    }

    private void clickFalse(View view) {
        checkAnswer(view, Boolean.FALSE);
        System.out.println("click false");
    }

    // Update question text view
    private void setQuestion() {
        binding.textView.setText(questionBank[qIndex].getQuestion());
    }
    // Check Answer & show response
    private void checkAnswer(View view, Boolean answer) {
        if (answer == questionBank[qIndex].getAnswer()){
            Snackbar.make(view,R.string.correct_message,Snackbar.LENGTH_LONG).show();
            System.out.println("Correct");
        }else {
            Snackbar.make(view,R.string.wrong_message,Snackbar.LENGTH_LONG).show();
            System.out.println("Wrong");
        }
    }


}