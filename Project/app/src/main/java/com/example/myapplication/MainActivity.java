package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.ExerciseList;
import com.example.myapplication.NewWorkout;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity
        implements BottomNavigationView
        .OnItemSelectedListener  {

    BottomNavigationView bottomNavigationView;

    private Button newWorkoutBtn;
    private Button WorkoutListBtn;
    private Button ExerciseListBtn;

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


    }

    public void changeExerciseList(){


    }

}
