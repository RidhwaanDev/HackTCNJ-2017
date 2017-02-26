package com.a2017.hackers.hacktcnj2017;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by user on 2/25/2017.
 */


public class EventStash {

    private DatabaseReference mRootDataBaseReference;

    private static EventStash ourInstance = new EventStash();

    public ArrayList<Event> sListOfEvents = new ArrayList<>();


    public static EventStash getInstance() {

        return ourInstance;
    }

    private EventStash() {

        mRootDataBaseReference = FirebaseDatabase.getInstance().getReference();


    }

    public void addUserToDatabase(User userObj){
        HashMap<String,User> map = new HashMap<>();
        map.put(userObj.getEmail(),userObj);
        mRootDataBaseReference.child("Users").setValue(map);
    }

    public void addEvent(Event o){
        sListOfEvents.add(o);
    }





}