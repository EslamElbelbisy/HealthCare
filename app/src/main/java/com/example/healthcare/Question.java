package com.example.healthcare;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class Question extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question);


    }


        private String[] options;
        private int answerIndex;
        private final String question;

        public Question(String question, String[] options, int answerIndex) {
            this.question = question;
            this.options = options;
            this.answerIndex = answerIndex;
        }

        public String getQuestion() {
            return question;
        }

        public String[] getOptions() {
            return options;
        }

        public int getAnswerIndex() {
            return answerIndex;
        }
    private Question[] questions;

    {

    }


    public int getAnswer() {
        return 0;
    }
}

