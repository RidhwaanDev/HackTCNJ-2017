package com.a2017.hackers.hacktcnj2017;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class CheckEventExposed extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check_event_exposed);
        TextView exposed = (TextView) findViewById(R.id.exposed);
        exposed.setOnClickListener(
                new Button.OnClickListener() {
                    public void onClick(View v) {
                        Intent i = new Intent(CheckEventExposed.this, FunnyPictureExposed.class); // should go to FunnyPictureActivity, currently not working
                        startActivity(i);
                    }
                }
        );
    }
}
