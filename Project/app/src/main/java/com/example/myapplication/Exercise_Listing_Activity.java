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
        ExersNameList.add(new Exercise("Plank"));
        ExersNameList.add(new Exercise("Sit-up"));
        ExersNameList.add(new Exercise("Squat"));
        ExersNameList.add(new Exercise("Bench Press"));

    }
}