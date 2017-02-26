package com.a2017.hackers.hacktcnj2017;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class CheckEvent extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check_event);
        TextView uploaded = (TextView) findViewById(R.id.uploadedButton);
        uploaded.setOnClickListener(
                new Button.OnClickListener() {
                    public void onClick(View v) {
                        Intent i = new Intent(CheckEvent.this, FunnyPictureActivity.class); // should go to FunnyPictureActivity, currently not working
                       // Intent i = new Intent(CheckEvent.this, CheckEventApproveDisapprove.class);
                        startActivity(i);
                    }
                }
        );
    }


}
