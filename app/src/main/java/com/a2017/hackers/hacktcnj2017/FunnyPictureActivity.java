package com.a2017.hackers.hacktcnj2017;

import android.content.Intent;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

public class FunnyPictureActivity extends AppCompatActivity {
CountDownTimer timer;
    TextView time;
    int currentSecs = 3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.d("TAG", "FUNNY PICTURE SHOWING");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_funny_picture);
        time = (TextView) findViewById( R.id.timeView);



        timer = new CountDownTimer(currentSecs * 1000, 1000) {

            public void onTick(long millisUntilFinished) {
                Log.d("TAG", "TICK  ");
                time.setText(Integer.toString(currentSecs));
                currentSecs-=1;
            }

            public void onFinish() {
                //time.setText(0);
                Log.d("TAG", "TIMER FINISHED");
                Intent i = new Intent(FunnyPictureActivity.this, CheckEventApproveDisapprove.class); // should go to FunnyPictureActivity, currently not working
                startActivity(i);

            }

        }.start();
    }


}
