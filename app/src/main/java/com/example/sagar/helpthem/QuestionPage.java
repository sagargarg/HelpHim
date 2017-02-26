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
    public int countQuestion;
    public TextView tv;
    public TextView question;

    public static String diagnosis;


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

        res = getResources();
        planets = res.getStringArray(R.array.planets_array);

        Button buttonYES = (Button) findViewById(R.id.buttonYES);
        Button buttonNO = (Button) findViewById(R.id.buttonNO);
        tv = (TextView) findViewById(R.id.number);
        question = (TextView) findViewById(R.id.question);

        String tvValue = tv.getText().toString();
        countQuestion = Integer.parseInt(tvValue);

        buttonYES.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                response = "YES";
                updateQuestion(response);
            }
        });

        buttonNO.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                response = "NO";
                updateQuestion(response);
            }
        });

    }

    private void updateQuestion(String response) {
        // Send value of response to firebase
        countQuestion += 1;
        String newQuestion = planets[countQuestion - 1];

        String lastChar = newQuestion.substring(newQuestion.length() - 1);
        if (lastChar.equals("?")) {
            tv.setText(countQuestion + "");
            question.setText(newQuestion);
        }
        else{
            diagnosis = newQuestion;
            Intent sendStuff = new Intent(this, FinalPage.class);
            sendStuff.putExtra("diagnosis", diagnosis);
            startActivity(sendStuff);
        }
    }
}
