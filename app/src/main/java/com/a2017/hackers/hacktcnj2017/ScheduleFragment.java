package com.a2017.hackers.hacktcnj2017;

/**
 * Created by user on 2/25/2017.
 */

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.FragmentManager;
import android.support.v7.widget.CardView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.support.v4.app.Fragment;
import android.widget.Button;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import java.util.ArrayList;
import java.util.Date;


/**
 * Created by user on 2/25/2017.
 */

public class ScheduleFragment extends Fragment {

    public static final String ARGS_DATE_PICKER = ScheduleFragment.class.getCanonicalName();
    public static final String DIALOG_ID = "1";
    public static final String RESULT_ID = "2";


    private DatabaseReference mDataBase, mDataBaseEventReference;

    private ArrayList<User> listOfEvents = new ArrayList<>();
    private static final int REQUEST_CODE = 1;
    private RecyclerView mRecyclerView;
    private EventAdapter mEventAdapter;

    private static final String sUSERNAME = "Bob";
    private Button actionBUtton;
    private Event mEvent;

    private Date date;




    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.schedule_list_fragment, container, false);

        mDataBase = FirebaseDatabase.getInstance().getReference();

        mRecyclerView = (RecyclerView) v.findViewById(R.id.recycler_view_id);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));


        updateUI();

        mDataBase.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });




        FloatingActionButton fab = (FloatingActionButton)v.findViewById(R.id.button_add);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i = new Intent(getContext(),AddEventActivity.class);
                startActivity(i);
            }
        });



        return v;
    }


  /*  public void createDateDialog(){
        Date date = Utils.getCurrentDate();

        FragmentManager fg = getFragmentManager();
        DatePickerDialog datePicker = DatePickerDialog.newInstance(date);
        datePicker.setTargetFragment(ScheduleFragment.this,REQUEST_CODE);
        datePicker.show(fg,DIALOG_ID);

    }*/




    public void updateUI() {

        mEventAdapter = new EventAdapter();
        mRecyclerView.setAdapter(mEventAdapter);
    }


    private class EventHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private CardView cardView;


        public EventHolder(View itemView) {
            super(itemView);
            cardView = (CardView) itemView.findViewById(R.id.card_view_data);

        }

        @Override
        public void onClick(View v) {

        }
    }

    private class EventAdapter extends RecyclerView.Adapter<EventHolder> {


        private ArrayList<Event> e;

        public EventAdapter() {


            e = new ArrayList<>();


        }


        @Override
        public EventHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            LayoutInflater inflater = LayoutInflater.from(getActivity());
            View v = inflater.inflate(R.layout.single_user_layout, parent, false);

            return new EventHolder(v);

        }

        @Override
        public void onBindViewHolder(EventHolder holder, int position) {

        }

        @Override
        public int getItemCount() {
            return e.size();
        }
    }
}



