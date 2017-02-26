package com.example.sagar.helpthem;

import android.content.Intent;
import android.content.res.Resources;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.appindexing.Thing;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.location.LocationListener;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationServices;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

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

    FirebaseDatabase database;
    DatabaseReference myRef;

    private static final String TAG = "Questions";

    Resources res;
    static String[] planets;
    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client;

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

        database = FirebaseDatabase.getInstance();
        myRef = database.getReference("message");

        myRef.setValue("Hello, World!");

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();
    }

    private void updateQuestion(String response) {
        // Read from the database

        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                String value = dataSnapshot.getValue(String.class);
                Log.d(TAG, "Value is: " + value);
            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                Log.w(TAG, "Failed to read value.", error.toException());
            }
        });
        // Send value of response to firebase
        countQuestion += 1;
        String newQuestion = planets[countQuestion - 1];

        String lastChar = newQuestion.substring(newQuestion.length() - 1);
        if (lastChar.equals("?")) {
            tv.setText(countQuestion + "");
            question.setText(newQuestion);
        } else {
            diagnosis = newQuestion;
            Intent sendStuff = new Intent(this, FinalPage.class);
            sendStuff.putExtra("diagnosis", diagnosis);
            startActivity(sendStuff);
        }
    }

    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    public Action getIndexApiAction() {
        Thing object = new Thing.Builder()
                .setName("QuestionPage Page") // TODO: Define a title for the content shown.
                // TODO: Make sure this auto-generated URL is correct.
                .setUrl(Uri.parse("http://[ENTER-YOUR-URL-HERE]"))
                .build();
        return new Action.Builder(Action.TYPE_VIEW)
                .setObject(object)
                .setActionStatus(Action.STATUS_TYPE_COMPLETED)
                .build();
    }

    @Override
    public void onStart() {
        super.onStart();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client.connect();
        AppIndex.AppIndexApi.start(client, getIndexApiAction());
    }

    @Override
    public void onStop() {
        super.onStop();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        AppIndex.AppIndexApi.end(client, getIndexApiAction());
        client.disconnect();
    }
}
