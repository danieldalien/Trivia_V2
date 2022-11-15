package com.example.trivia_v2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;
import android.os.Bundle;
import android.widget.TextView;

import com.example.trivia_v2.databinding.ActivityMainBinding;
import com.example.trivia_v2.model.Question;
import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding ;
    private int currentQuestionIndex = 0;
    private TextView question_text ;

    private Question[] questionbank = new Question[]{
            new Question(R.string.q_cannabis,  true),
            new Question(R.string.q_feuer   ,  false),
            new Question(R.string.q_danie   , true),
            new Question(R.string.q_iq      , false),
            new Question(R.string.q_eupen   , false),
            new Question(R.string.q_wetter  , true),

    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //question_text = findViewById(R.id.question_text_view);
        //question_text.setText(questionbank[0].getAnswerResId());

        binding = DataBindingUtil.setContentView(this,R.layout.activity_main);
        binding.questionTextView.setText(questionbank[currentQuestionIndex].getAnswerResId());

        binding.nextButton.setOnClickListener(view -> {

            currentQuestionIndex++;
            if (currentQuestionIndex > questionbank.length - 1 ){
                currentQuestionIndex = 0;
            }
            updateQuestion();
        } );

        binding.prevButton.setOnClickListener(view -> {
            currentQuestionIndex--;
            if(currentQuestionIndex < 0){
                currentQuestionIndex = questionbank.length -1 ;
            }
            updateQuestion();
        });

        binding.trueButton.setOnClickListener(view -> {
            checkCorrectAnswer(true);
        });

        binding.falseButton.setOnClickListener(view -> {
            checkCorrectAnswer(false);
        });

        binding.nextPageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this , MainActivity2.class);
                startActivity(intent);
            }
        });


    }
    private void checkCorrectAnswer(boolean userAnswer){
        boolean correctAnswer = questionbank[currentQuestionIndex].isAnswerTrue();
        int messageId;

        if (userAnswer == correctAnswer){
            messageId = R.string.q_correct;
        }else{
            messageId = R.string.q_false;
        }
        Snackbar.make(binding.imageView , messageId , Snackbar.LENGTH_SHORT).show();
    }
    private void updateQuestion() {
        binding.questionTextView.setText(questionbank[currentQuestionIndex].getAnswerResId());
    }
}
