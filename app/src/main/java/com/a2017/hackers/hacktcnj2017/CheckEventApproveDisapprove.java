package com.a2017.hackers.hacktcnj2017;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.content.Intent;

public class CheckEventApproveDisapprove extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check_event_approve_disapprove);
        Button approve = (Button) findViewById(R.id.approve);
        approve.setOnClickListener(
                new Button.OnClickListener() {
                    public void onClick(View v) {
                        Intent i = new Intent(CheckEventApproveDisapprove.this, CheckEventApproved.class);
                        startActivity(i);
                    }
                }
        );
    }
}
