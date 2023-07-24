package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity
        implements BottomNavigationView
        .OnItemSelectedListener  {

    BottomNavigationView bottomNavigationView;

    private Button newWorkoutBtn;
    private Button WorkoutListBtn;
    private Button ExerciseListBtn;

    private Button Testing_Workout_Btn;
    //private WorkoutLAdapter workoutLAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bottomNavigationView
                = findViewById(R.id.bottomNavigationView);

        bottomNavigationView
                .setOnItemSelectedListener(this);
        bottomNavigationView.setSelectedItemId(R.id.bottomNavigationView);

        newWorkoutBtn = findViewById(R.id.NewWorkoutBtn);
        newWorkoutBtn.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Log.i ("info", "Pinged NewWorkout" );

                        changeNewWorkout();

                    }
                }
        );

//        workoutLAdapter = new WorkoutLAdapter(this, database_info);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());


        WorkoutListBtn = findViewById(R.id.WorkoutListBtn);
        WorkoutListBtn.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                        Log.i ("info", "Pinged Workout" );
                        changeWorkoutList();
                    }
                });


        ExerciseListBtn = findViewById(R.id.ExerciseListBtn);
        ExerciseListBtn.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Log.i ("info", "Pinged Exercise" );
                        changeExerciseList();

                    }
                });

        Testing_Workout_Btn = findViewById(R.id.TestsWorkoutActual);
        Testing_Workout_Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                changeWorkoutExerBridge();
            }
        });


    }
    //WorkoutList firstFragment = new WorkoutList();
    //NewWorkout secondFragment = new NewWorkout();
    //ExerciseList thirdFragment = new ExerciseList();

    @Override
    public boolean
    onNavigationItemSelected(@NonNull MenuItem item)
    {
/*
        switch (item.getItemId()) {
            case R.id.Option1:
                getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.flFragment, firstFragment)
                        .commit();
                return true;

            case R.id.home:
                getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.flFragment, secondFragment)
                        .commit();
                return true;

            case R.id.settings:
                getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.flFragment, thirdFragment)
                        .commit();
                return true;
        }
  */      return false;
    }

    public void changeNewWorkout (){
    Intent intent = new Intent(this, New_Workout_Activity.class);
        startActivity(intent);
    }

    public void changeWorkoutList(){

        Intent intents = new Intent(this, Workout_Listing_Activity.class);
        startActivity(intents);

    }

    public void changeExerciseList(){
        Intent intenter = new Intent(this, Exercise_Listing_Activity.class);
        startActivity(intenter);

    }

    public void changeWorkoutExerBridge(){
        Intent intentIt = new Intent(this, Workout_Exercise_List_Activity.class);
        startActivity(intentIt);
    }
}
