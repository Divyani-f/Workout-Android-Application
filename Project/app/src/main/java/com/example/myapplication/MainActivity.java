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

import java.util.List;

public class MainActivity extends AppCompatActivity
         {

    BottomNavigationView bottomNavigationView;

    private Button newWorkoutBtn;
    private Button WorkoutListBtn;
    private Button ExerciseListBtn;

    private Button Testing_Workout_Btn;
    private AppDatabase ap;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bottomNavigationView
                = findViewById(R.id.bottomNavigationView);


        bottomNavigationView.setOnItemSelectedListener(item -> {
            int id = item.getItemId();

            //noinspection SimplifiableIfStatement
            if (id == R.id.workoutOption) {
                changeWorkoutList();
            }
            else if (id == R.id.newOption) {
                changeNewWorkout();

            }
            else if (id == R.id.exerciseOption) {
                changeExerciseList();

            }

            return super.onOptionsItemSelected(item);
        });
        insertDataInBackground();
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


             private void insertDataInBackground() {
                 Log.d("ExerciseLog2", "Here ----");
                 new Thread(new Runnable() {
                     @Override
                     public void run() {
                         // Create an instance of ExerciseDao
                         AppDatabase db=AppDatabase.getInstance(getApplicationContext());
                         Exercise sampleExercise = new Exercise();
                         sampleExercise.setExerciseName("Push-ups");
                         sampleExercise.setDescription("Perform 3 sets of 10 push-ups");
                         Log.d("ExerciseLog2", "Here ----");
                         // Insert the sample Exercise object into the database
                         db.exerciseDao().insertExercise(sampleExercise);
                         List<Exercise> l1=db.exerciseDao().getAllExercises();
                         for(Exercise e : l1){
                             Log.d("ExerciseLog", "Exercise ID: " + e.getExerciseName());
                         }
                     }
                 }).start();
             }

             public void addContact (Workout w) {
                 ap.workoutDao().insertWorkout(w);
                 List<Workout> l1=ap.workoutDao().getAllWorkouts();
                 for(Workout we: l1){
                     Log.d("WorkoutLog", "Workout name: " +we.getWorkoutName() );
                 }
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
