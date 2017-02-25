package com.example.sagar.helpthem;

import android.content.Intent;
import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class QuestionPage extends AppCompatActivity {

    public String response;
    public String questionString;
    public int countQuestion;
    public TextView tv;
    public TextView question;

    //public String[] questions = new String[10];

    //questions[0] = "This is sample question 1";

    public String string2 = "This is sample question 2";
    public String string3 = "This is sample question 3";
    public String string4 = "This is sample question 4";
    public String string5 = "This is sample question 5";

    Resources res;
    static String[] planets;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.question_page);

        Button buttonYES = (Button) findViewById(R.id.buttonYES);
        Button buttonNO = (Button) findViewById(R.id.buttonNO);

        buttonNO.setOnClickListener(buttonClickListener);
        buttonYES.setOnClickListener(buttonClickListener);

        res = getResources();
        planets = res.getStringArray(R.array.planets_array);

        tv = (TextView) findViewById(R.id.number);
        String tvValue = tv.getText().toString();
        countQuestion = Integer.parseInt(tvValue);

        question = (TextView) findViewById(R.id.question);
    }

    private View.OnClickListener buttonClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent = new Intent(QuestionPage.this, QuestionPage.class);
            switch (v.getId()) {
                case R.id.buttonYES:
                    response = "YES";
                    //Toast.makeText(QuestionPage.this, countQuestion + ": Old", Toast.LENGTH_SHORT).show();
                    countQuestion += 1;
                    //Toast.makeText(QuestionPage.this, countQuestion + ": New", Toast.LENGTH_SHORT).show();
                    tv.setText(countQuestion + "");
                    question.setText(planets[countQuestion - 1]);
                    //questionString = planets[countQuestion - 1];
                    //Toast.makeText(QuestionPage.this, "YES", Toast.LENGTH_SHORT).show();
                    startActivity(intent);
                    break;
                case R.id.buttonNO:
                    response = "NO";
                    countQuestion += 1;
                    tv.setText(countQuestion + "");
                    question.setText(planets[countQuestion - 1]);
                    startActivity(intent);
                    break;
            }
        }
    };
}
