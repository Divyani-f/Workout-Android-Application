package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Exercise_Listing_Activity extends AppCompatActivity {

    private ArrayList<Exercise> ExersNameList;
    private RecyclerView RV_ItemC;

    private AppDatabase ap;
    private ArrayList<Exercise> exerciseList;
    BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercise_listing);

        RV_ItemC = findViewById(R.id.ExerciseList_RecycleV);
        ExersNameList = new ArrayList<>();

        bottomNavigationView = findViewById(R.id.bottomNavigationView_EL);
        bottomNavigationView.setOnItemSelectedListener(item -> {
            int id = item.getItemId();

            //noinspection SimplifiableIfStatement
            if (id == R.id.workoutOption) {
                swaptoWorkoutList();
            }
            else if (id == R.id.ExerOption) {


            }
            else if (id == R.id.HomeOption) {
                backtoHomeScreen();
            }

            return super.onOptionsItemSelected(item);
        });


        setTestingInfos();
        setELAdapter();

    }

    private void swaptoWorkoutList() {
        ap=AppDatabase.getInstance(getApplicationContext());
        Intent intents = new Intent(this, Workout_Listing_Activity.class);
        List<Workout_Exercise> l1=ap.workout_exerciseDao().getAllWorkout_Exercises();
        intents.putExtra("workout_list", (Serializable) l1);
        startActivity(intents);

    }

    private void backtoHomeScreen() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    private void setELAdapter() {
        Exercise_Listing_Adapter AdaptsIt = new Exercise_Listing_Adapter(exerciseList);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        RV_ItemC.setLayoutManager(layoutManager);
        RV_ItemC.setItemAnimator(new DefaultItemAnimator());
        RV_ItemC.setAdapter(AdaptsIt);

    }

    private void setTestingInfos() {
        Intent i = getIntent();
        exerciseList = (ArrayList<Exercise>) i.getSerializableExtra("exerciseList");
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