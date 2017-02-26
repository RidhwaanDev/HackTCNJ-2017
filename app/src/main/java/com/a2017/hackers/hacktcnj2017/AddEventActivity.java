package com.a2017.hackers.hacktcnj2017;

import android.content.Context;
import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.widget.ContentLoadingProgressBar;

import java.io.Serializable;

/**
 * Created by user on 2/25/2017.
 */

public class AddEventActivity extends SingleFragmentActivity {
    public static final String ARG_EVENT = AddEventActivity.class.getCanonicalName();

    @Override
    public Fragment createFragment() {
        return new AddEvent();

    }


    public static Intent newInstance(Context packageContext,Event e){

        Intent i = new Intent(packageContext,AddEventActivity.class);
        i.putExtra(ARG_EVENT, e);
        return i;




    }
}



