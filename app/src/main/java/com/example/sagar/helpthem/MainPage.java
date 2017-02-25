package com.example.sagar.helpthem;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;

public class MainPage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_page);

        RelativeLayout rlayout = (RelativeLayout) findViewById(R.id.main_page);
        rlayout.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainPage.this, QuestionPage.class);
                startActivity(intent);
            }

        });
    }

    public void openAbout(View v) {
        Intent intent = new Intent(MainPage.this, AboutPage.class);
        startActivity(intent);
    }

}
