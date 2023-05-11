package com.example.healthcare;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class Questresult extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_questresult);

        TextView resultTextView = findViewById(R.id.result_text);
        ListView answerListView = findViewById(R.id.answer_list);

        // Get the score and answers from the intent
        int score = getIntent().getIntExtra("score", 0);
        String[] userAnswers = getIntent().getStringArrayExtra("answers");

        // Display the score
        resultTextView.setText("Your score: " + score + "/5");

        // Create an adapter for the ListView
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, userAnswers);

        // Set the adapter to the ListView
        answerListView.setAdapter(adapter);
    }
}
