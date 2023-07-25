package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class Exercise_Listing_Activity extends AppCompatActivity {

    private ArrayList<Exercise> ExersNameList;
    private RecyclerView RV_ItemC;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercise_listing);

        RV_ItemC = findViewById(R.id.ExerciseList_RecycleV);
        ExersNameList = new ArrayList<>();
        setTestingInfos();
        setELAdapter();

    }

    private void setELAdapter() {
        Exercise_Listing_Adapter AdaptsIt = new Exercise_Listing_Adapter(ExersNameList);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        RV_ItemC.setLayoutManager(layoutManager);
        RV_ItemC.setItemAnimator(new DefaultItemAnimator());
        RV_ItemC.setAdapter(AdaptsIt);

    }

    private void setTestingInfos() {
        Exercise e1 = new Exercise();
        e1.setExercise("Plank");
        ExersNameList.add(e1);

        Exercise e2 = new Exercise();
        e2.setExercise("Sit-up");
        ExersNameList.add(e2);

        Exercise e3 = new Exercise();
        e3.setExercise("Squat");
        ExersNameList.add(e3);

        Exercise e4 = new Exercise();
        e4.setExercise("Bench Press");
        ExersNameList.add(e4);
    }
}