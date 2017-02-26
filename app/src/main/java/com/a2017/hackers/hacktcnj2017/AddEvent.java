package com.a2017.hackers.hacktcnj2017;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;

import static com.a2017.hackers.hacktcnj2017.LoginActivity.user;

public class AddEvent extends AppCompatActivity {
    private EditText mEventNameEditText;
    private EditText mLocationAddressEditText;
    private EditText mDateEditText;
    private EditText mTimeEditText;
    private EditText mEmail1;
    private EditText mEmail2;
    private EditText mEmail3;
    private String eventName;
    private String locationAddress;
    private String date;
    private String time;
    private String email1;
    private String email2;
    private String email3;
    private ArrayList<User> users;
    private Event event;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_event);
        mEventNameEditText = (EditText) findViewById(R.id.eventName);
        mLocationAddressEditText = (EditText) findViewById(R.id.locationAddress);
        mDateEditText = (EditText) findViewById(R.id.date);
        mTimeEditText = (EditText) findViewById(R.id.time);
        mEmail1 = (EditText) findViewById(R.id.email1);
        mEmail2 = (EditText) findViewById(R.id.email2);
        mEmail3 = (EditText) findViewById(R.id.email3);
        Button createEvent = (Button) findViewById(R.id.createEvent);
        createEvent.setOnClickListener(
                new Button.OnClickListener() {
                    public void onClick(View v) {
                        eventName = mEventNameEditText.getText().toString().trim();
                        locationAddress = mLocationAddressEditText.getText().toString().trim();
                        date = mDateEditText.getText().toString().trim();
                        time = mTimeEditText.getText().toString().trim();
                        email1 = mEmail1.getText().toString().trim();
                        email2 = mEmail2.getText().toString().trim();
                        email3 = mEmail3.getText().toString().trim();
                        users.add(user);
                        if (email1 != null)
                            users.add(new User(email1));
                        if (email2 != null)
                            users.add(new User(email2));
                        if (email3 != null)
                            users.add(new User(email3));
                        event = new Event(eventName, locationAddress, time, users);
                    }
                }
        );
    }
}