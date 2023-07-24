package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class Workout_Listing_Activity extends AppCompatActivity {

    private ArrayList<WorkoutNames> WorkoutList;
    private RecyclerView RV_ItemB;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_workout_listing);

        RV_ItemB = findViewById(R.id.WorkoutList_RecycleV);
        WorkoutList = new ArrayList<>();
        setTestingInfo();
        setWOLAdapter();


    }

    private void setTestingInfo() {
        WorkoutList.add(new WorkoutNames("Core Workout"));
        WorkoutList.add(new WorkoutNames("Upper-Body Workout"));
        WorkoutList.add(new WorkoutNames("Endurance"));
    }

    private void setWOLAdapter() {
        Workout_Listing_Adapter Adapts = new Workout_Listing_Adapter(WorkoutList);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        RV_ItemB.setLayoutManager(layoutManager);
        RV_ItemB.setItemAnimator(new DefaultItemAnimator());
        RV_ItemB.setAdapter(Adapts);
    }
}