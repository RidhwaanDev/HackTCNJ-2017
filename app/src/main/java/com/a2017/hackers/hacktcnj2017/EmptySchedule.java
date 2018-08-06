package com.a2017.hackers.hacktcnj2017;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class EmptySchedule extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_empty_schedule);
        Button addEvent = (Button) findViewById(R.id.addEvent);
        addEvent.setOnClickListener(
                new Button.OnClickListener() {
                    public void onClick(View v) {
                        Intent i = new Intent(EmptySchedule.this, AddEvent.class);
                        startActivity(i);
                    }
                }
        );
    }
}
