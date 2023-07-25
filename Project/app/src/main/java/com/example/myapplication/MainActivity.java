package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.io.Serializable;
import java.util.List;

public class MainActivity extends AppCompatActivity
         {

    BottomNavigationView bottomNavigationView;

    private Button newWorkoutBtn;
    private Button WorkoutListBtn;
    private Button ExerciseListBtn;


    private AppDatabase ap;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bottomNavigationView = findViewById(R.id.bottomNavigationView);
        bottomNavigationView.setOnItemSelectedListener(item -> {
            int id = item.getItemId();

            //noinspection SimplifiableIfStatement
            if (id == R.id.workoutOption) {
                changeWorkoutList();
            }
            else if (id == R.id.ExerOption) {
                changeExerciseList();

            }
            else if (id == R.id.HomeOption) {

            }

            return super.onOptionsItemSelected(item);
        });

       // insertDataInBackground();
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


             private final ActivityResultLauncher<Intent> newWorkoutActivityResultLauncher = registerForActivityResult(
                     new ActivityResultContracts.StartActivityForResult(),
                     result -> {
                         if (result.getResultCode() == MainActivity.RESULT_OK) {
                             Intent data = result.getData();
                             if (data != null) {

                                 // Extract the Workout object from the intent
                                 Workout workout = (Workout) data.getSerializableExtra("workout");
                                 Workout_Exercise workout_exercise=(Workout_Exercise) data.getSerializableExtra("workout_exercise");
                                 if (workout != null) {
                                     ap=AppDatabase.getInstance(getApplicationContext());
                                     ap.workoutDao().insertWorkout(workout);
                                     List<Workout> l1=ap.workoutDao().getAllWorkouts();
                                     for(Workout we: l1){
                                         Log.d("WorkoutLog", "Workout name: " +we.getWorkoutName() );
                                     }

                                 }
                                 /*if(workout_exercise!=null){
                                     Log.d("Here","yaay hre");
                                     ap=AppDatabase.getInstance(getApplicationContext());
                                     ap.workoutDao().insertWorkout(workout);
                                     List<Workout_Exercise> l1=ap.workout_exerciseDao().getAllWorkout_Exercises();
                                     for(Workout_Exercise w: l1){
                                         Log.d("WorkoutLog", "Workout name: " +w.getName() );
                                     }
                                 }*/
                             }
                         }
                     });
    public void changeNewWorkout (){
    Intent intent = new Intent(this, New_Workout_Activity.class);
        newWorkoutActivityResultLauncher.launch(intent);
    }

    public void changeWorkoutList(){
        ap=AppDatabase.getInstance(getApplicationContext());
        Intent intents = new Intent(this, Workout_Listing_Activity.class);
        List<Workout_Exercise> l1=ap.workout_exerciseDao().getAllWorkout_Exercises();
            intents.putExtra("workout_list", (Serializable) l1);
            startActivity(intents);

    }

    public void changeExerciseList(){
        Intent intenter = new Intent(this, Exercise_Listing_Activity.class);
        startActivity(intenter);

    }

}
