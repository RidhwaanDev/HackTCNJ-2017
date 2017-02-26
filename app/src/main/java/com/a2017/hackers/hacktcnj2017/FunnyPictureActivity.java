package com.a2017.hackers.hacktcnj2017;

import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

public class FunnyPictureActivity extends AppCompatActivity {
CountDownTimer timer;
    TextView time;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_funny_picture);
        time = (TextView) findViewById( R.id.timeView);

        final int currentSecs = 3;

        timer = new CountDownTimer(currentSecs * 1000, 1000) {

            public void onTick(long millisUntilFinished) {
                Log.d("TAG", "TICK  ");
                time.setText(Integer.toString(currentSecs));

            }

            public void onFinish() {
                Log.d("TAG", "TIMER FINISHED");
                finish();

            }

        }.start();
    }


}
