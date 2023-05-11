package com.example.healthcare;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class Questionaire extends AppCompatActivity {

    private Question[] questions = new Question[] {
            new Question("Who is the author of 'To Kill a Mockingbird'?", new String[] {"Harper Lee", "Ernest Hemingway", "Mark Twain", "Stephen King"}, 0),
            new Question("What is the capital of France?", new String[] {"London", "Berlin", "Paris", "Rome"}, 2),
            new Question("In what year did World War II end?", new String[] {"1945", "1939", "1950", "1940"}, 0),
            new Question("What is the square root of 144?", new String[] {"10", "12", "14", "16"}, 1),
            new Question("Which planet is known as the Red Planet?", new String[] {"Earth", "Mars", "Jupiter", "Saturn"}, 1)
    };

    private int[] userAnswers = new int[questions.length];
    private int currentQuestionIndex = 0;

    private TextView questionText;
    private RadioGroup optionsGroup;
    private Button nextButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question);

        questionText = findViewById(R.id.question_text);
        optionsGroup = findViewById(R.id.options_group);
        nextButton = findViewById(R.id.next_button);

        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int selectedOptionIndex = optionsGroup.indexOfChild(
                        findViewById(optionsGroup.getCheckedRadioButtonId()));
                userAnswers[currentQuestionIndex] = selectedOptionIndex;

                currentQuestionIndex++;
                if (currentQuestionIndex < questions.length) {
                    showQuestion();
                } else {
                    // Quiz is finished, show results
                    // This could be done by starting a new activity
                }
            }
        });

        showQuestion();
    }
    private void endQuiz() {
        // Calculate the score
        int score = 0;
        for (int i = 0; i < questions.length; i++) {
            if (userAnswers[i] == questions[i].getAnswer()) {
                score++;
            }
        }

        // Create an array of user's answers
        String[] userAnswerStrings = new String[questions.length];
        for (int i = 0; i < questions.length; i++) {
            userAnswerStrings[i] = questions[i].getOptions()[userAnswers[i]];
        }

        // Start the ResultActivity
        Intent intent = new Intent(Questionaire.this, Questresult.class);
        intent.putExtra("score", score);
        intent.putExtra("answers", userAnswerStrings);
        startActivity(intent);
        finish();
    }


    private void showQuestion() {
        Question question = questions[currentQuestionIndex];
        questionText.setText(question.getQuestion());

        optionsGroup.removeAllViews();
        for (int i = 0; i < question.getOptions().length; i++) {
            RadioButton button = new RadioButton(this);
            button.setText(question.getOptions()[i]);
            button.setGravity(Gravity.CENTER_HORIZONTAL); // Center the text
            optionsGroup.addView(button);
        }

        optionsGroup.check(optionsGroup.getChildAt(userAnswers[currentQuestionIndex]).getId());
    }

}
