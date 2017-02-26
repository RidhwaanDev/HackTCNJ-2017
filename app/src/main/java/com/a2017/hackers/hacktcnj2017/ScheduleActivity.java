package com.a2017.hackers.hacktcnj2017;

import android.content.Context;
import android.content.Intent;
import android.support.v4.app.Fragment;

/**
 * Created by user on 2/25/2017.
 */
public class ScheduleActivity extends SingleFragmentActivity {



    @Override
    public Fragment createFragment() {
        return new ScheduleFragment();

    }

    public static Intent newInstance(Context packageContext, String email ){

        Intent intent = new Intent(packageContext,ScheduleActivity.class);
        intent.putExtra("KEY",email);
        return intent;
    }
}
