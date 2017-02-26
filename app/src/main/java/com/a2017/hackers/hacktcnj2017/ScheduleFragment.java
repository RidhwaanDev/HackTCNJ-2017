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
import android.support.v4.widget.TextViewCompat;
import android.support.v7.widget.CardView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.support.v4.app.Fragment;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import org.w3c.dom.Text;

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

    private ArrayList<Event> listOfEvents;
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

        listOfEvents = EventStash.getInstance().sListOfEvents;
        updateUI();






        FloatingActionButton fab = (FloatingActionButton)v.findViewById(R.id.button_add);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i = new Intent(getContext(),AddEventActivity.class);
                startActivityForResult(i,REQUEST_CODE);
            }
        });



        return v;
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {

        Log.d("TEST", "EVENT CREATION CALLED22" + requestCode);

        if(resultCode != Activity.RESULT_OK){

            Log.d("TEST", "EVENT CREATION CALLED2");

            return;
        }

        if(requestCode == REQUEST_CODE && data != null){
            Log.d("TEST", "EVENT CREATION CALLED2");

          //  Event o = (Event) data.getSerializableExtra(AddEventActivity.ARG_EVENT);
           // EventStash.getInstance().addEvent(o);
           // Log.d("TEST","OBJ DATA" + o.getName());
            //updateUI();
        }


    }



    public void updateUI() {
        mEventAdapter = new EventAdapter();
        mRecyclerView.setAdapter(mEventAdapter);
    }


    private class EventHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private CardView cardView;
        private TextView titleText;
        private TextView numberofMembers;




        public EventHolder(View itemView) {
            super(itemView);

            itemView.setOnClickListener(this);
            cardView = (CardView) itemView.findViewById(R.id.card_view_data);
            titleText = (TextView) itemView.findViewById(R.id.event_title);
            numberofMembers = (TextView) itemView.findViewById(R.id.number_of_members);

        }

        public void bindHolder(Event o){
            titleText.setText(o.getName());
        }

        @Override
        public void onClick(View v) {

        }
    }

    private class EventAdapter extends RecyclerView.Adapter<EventHolder> {


        private ArrayList<Event> e;

        public EventAdapter() {

        e = new ArrayList<>();
            e.add(new Event("Hackathon","Lo1c","4"));
            e.add(new Event("Science Fair Project","Loc","4"));
            e.add(new Event("Math project","L22oc","4"));
            e.add(new Event("Hackathon","Lo1c","34"));
            e.add(new Event("Wod","Lo3c","42"));

        }


        @Override
        public EventHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            LayoutInflater inflater = LayoutInflater.from(getActivity());
            View v = inflater.inflate(R.layout.single_user_layout, parent, false);

            return new EventHolder(v);

        }

        @Override
        public void onBindViewHolder(EventHolder holder, int position) {
            Event se =  e.get(position);
            holder.bindHolder(se);
        }

        @Override
        public int getItemCount() {
            return e.size();
        }
    }
}



