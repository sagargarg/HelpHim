package com.example.sagar.helpthem;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import static android.R.attr.key;
import static android.R.attr.value;

public class FinalPage extends AppCompatActivity {

    public String diagnosisFinal;
    TextView diagnosistv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.final_page);

        diagnosisFinal = QuestionPage.diagnosis;
        diagnosistv = (TextView)findViewById(R.id.diagnosis);

        diagnosistv.setText(diagnosisFinal);

        View v = (View) findViewById(R.id.view);
        v.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(FinalPage.this, ResultsPage.class);
                startActivity(intent);
            }

        });

    }
}
