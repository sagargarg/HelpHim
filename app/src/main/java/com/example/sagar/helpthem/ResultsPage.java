package com.example.sagar.helpthem;

import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import static com.example.sagar.helpthem.QuestionPage.planets;
import static com.example.sagar.helpthem.R.id.number;

public class ResultsPage extends AppCompatActivity {

    public String diagnosisFinal;
    Resources res;
    static String[] results_steps;
    public String[] diagnosis_array;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.results_page);

        res = getResources();
        diagnosisFinal = QuestionPage.diagnosis;

        ListView listView = (ListView)findViewById(R.id.listview_all);

        switch (diagnosisFinal){
            case "Stroke":
                diagnosis_array = getResources().getStringArray(R.array.stroke);
                break;
            case "Seizure":
                diagnosis_array = getResources().getStringArray(R.array.seizure);
                break;
            case "Concussion":
                diagnosis_array = getResources().getStringArray(R.array.concussion);
                break;
            case "Drug OD":
                diagnosis_array = getResources().getStringArray(R.array.drugod);
                break;
            case "Alcohol Poisioning":
                diagnosis_array = getResources().getStringArray(R.array.alcohol);
                break;
            case "Cardiac Arrest":
                diagnosis_array = getResources().getStringArray(R.array.cardiac);
                break;
        }
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, diagnosis_array);
        listView.setAdapter(adapter);

    }
}
