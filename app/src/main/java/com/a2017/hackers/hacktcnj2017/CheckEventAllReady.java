package com.a2017.hackers.hacktcnj2017;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class CheckEventAllReady extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check_event_all_ready);
        Button refresh = (Button) findViewById(R.id.refresh);
        refresh.setOnClickListener(
                new Button.OnClickListener() {
                    public void onClick(View v) {
                        Intent i = new Intent(CheckEventAllReady.this, CheckEventExposed.class);
                        startActivity(i);
                    }
                }
        );
    }
}
