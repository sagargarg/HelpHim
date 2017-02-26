package com.example.sagar.helpthem;

import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import static com.example.sagar.helpthem.QuestionPage.planets;
import static com.example.sagar.helpthem.R.id.diagnosisTitle;
import static com.example.sagar.helpthem.R.id.final_page;
import static com.example.sagar.helpthem.R.id.number;

public class ResultsPage extends AppCompatActivity {

    public String diagnosisFinal;
    Resources res;
    static String[] results_steps;
    public String[] diagnosis_array;
    public TextView diagnose;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.results_page);

        TextView diagnose = (TextView) findViewById(R.id.textView_name);

        res = getResources();
        diagnosisFinal = QuestionPage.diagnosis;

        ListView listView = (ListView)findViewById(R.id.listview_all);

        switch (diagnosisFinal){
            case "Stroke":
                diagnosis_array = getResources().getStringArray(R.array.stroke);
                diagnose.setText("Stroke");
                break;
            case "Seizure":
                diagnosis_array = getResources().getStringArray(R.array.seizure);
                diagnose.setText("Seizure");
                break;
            case "Concussion":
                diagnosis_array = getResources().getStringArray(R.array.concussion);
                diagnose.setText("Concussion");

                break;
            case "Drug OD":
                diagnosis_array = getResources().getStringArray(R.array.drugod);
                diagnose.setText("Drug OD");

            case "Alcohol Poisioning":
                diagnosis_array = getResources().getStringArray(R.array.alcohol);
                diagnose.setText("Alcohol Poisoning");
                break;
            case "Cardiac Arrest":
                diagnosis_array = getResources().getStringArray(R.array.cardiac);
                diagnose.setText("Cardiac Arrest");
                break;
        }
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, diagnosis_array);
        listView.setAdapter(adapter);

    }
}
