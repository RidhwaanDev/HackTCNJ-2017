package com.a2017.hackers.hacktcnj2017;

import android.app.Activity;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.content.Intent;

import java.util.ArrayList;

import static com.a2017.hackers.hacktcnj2017.LoginActivity.user;

public class AddEventFragment extends Fragment {
    public static final String ARG_EVENT_OBJ = AddEventFragment.class.getCanonicalName();


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


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {


        setHasOptionsMenu(true);

        View v = inflater.inflate(R.layout.activity_add_event,container,false);
        mEventNameEditText = (EditText)v. findViewById(R.id.eventName);
        mLocationAddressEditText = (EditText)v. findViewById(R.id.locationAddress);
        mDateEditText = (EditText)v. findViewById(R.id.date);
        mTimeEditText = (EditText) v.findViewById(R.id.time);
        mEmail1 = (EditText)v. findViewById(R.id.email1);
        mEmail2 = (EditText)v. findViewById(R.id.email2);
        mEmail3 = (EditText) v.findViewById(R.id.email3);
        Button createEvent = (Button) v.findViewById(R.id.createEvent);



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

                    event = new Event(eventName, locationAddress, time);
                    getFinalzedIntent(event);

                }
            }
        );


        return v;
    }


        public void getFinalzedIntent(Event o){
            Log.d("TEST", "EVENT CREATION CALLED");
                  Intent data = new Intent();
               data.putExtra(ARG_EVENT_OBJ,o);
               getActivity().setResult(Activity.RESULT_OK,data);
               getActivity().finish();
        }


}
