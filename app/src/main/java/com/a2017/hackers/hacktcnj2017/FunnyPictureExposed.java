package com.a2017.hackers.hacktcnj2017;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

/**
 * Created by MLH-Admin on 2/26/2017.
 */

public class FunnyPictureExposed extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_funny_picture);
        TextView time = (TextView) findViewById( R.id.timeView);
        time.setText("");
    }

}
