package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Workout_Listing_Activity extends AppCompatActivity implements Workout_Listing_Adapter.OnItemClickListener{
    private ArrayList<Workout_Exercise> wl;
    private ArrayList<WorkoutNames> WorkoutList;
    private RecyclerView RV_ItemB;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_workout_listing);

        RV_ItemB = findViewById(R.id.WorkoutList_RecycleV);

        setTestingInfo();
        setWOLAdapter();


    }

   private void setTestingInfo() {
        WorkoutList = new ArrayList<>(); // Initialize the WorkoutList ArrayList

        Intent i = getIntent();
        wl = (ArrayList<Workout_Exercise>) i.getSerializableExtra("workout_list");
       HashSet<String> uniqueNamesSet = new HashSet<>();
       List<Workout_Exercise> uniqueWorkoutsList = new ArrayList<>();
       for (Workout_Exercise exercise : wl) {
           String workoutName = exercise.getWorkoutName();
           if (!uniqueNamesSet.contains(workoutName)) {
               uniqueNamesSet.add(workoutName);
               uniqueWorkoutsList.add(exercise);
           }
       }
       wl= (ArrayList<Workout_Exercise>) uniqueWorkoutsList;
    }


    private void setWOLAdapter() {
        Workout_Listing_Adapter Adapts = new Workout_Listing_Adapter(wl,this);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        RV_ItemB.setLayoutManager(layoutManager);
        RV_ItemB.setItemAnimator(new DefaultItemAnimator());
        RV_ItemB.setAdapter(Adapts);
    }
    private AppDatabase ap;
    @Override
    public void onItemClick(Workout_Exercise workoutExercise) {
        Log.d("Log2",workoutExercise.getName() );
        ap=AppDatabase.getInstance(getApplicationContext());
        List<Workout_Exercise> l1=ap.workout_exerciseDao().getWorkout_ExercisesByName(workoutExercise.getName());
        Intent intentIt = new Intent(this, Workout_Exercise_List_Activity.class);
        intentIt.putExtra("name_list", (Serializable) l1);
        startActivity(intentIt);

    }
}