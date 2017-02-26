package com.a2017.hackers.hacktcnj2017;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;

public class CheckEvent extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check_event);
    }

    // Goes to funny picture

    public void onClick(){
        Intent i = new Intent(this, FunnyPictureActivity.class);
        startActivity(i);
    }

}
