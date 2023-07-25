package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Workout_Exercise_List_Activity extends AppCompatActivity {

    private ArrayList<Exercise> ExersANameList;
    private RecyclerView RV_ItemD;
    private TextView WorkoutTitle;
    private ArrayList<Workout_Exercise> workoutList;
    private Button Confirm_Complete;

    private AppDatabase ap;
    BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_workout_exercise_list);

        RV_ItemD = findViewById(R.id.WorkExerBridge_List_RecycleV);
        ExersANameList = new ArrayList<>();
        WorkoutTitle = findViewById(R.id.WorkoutName_EL_L);


        bottomNavigationView = findViewById(R.id.bottomNavigationView_WOA);
        bottomNavigationView.setOnItemSelectedListener(item -> {
            int id = item.getItemId();

            //noinspection SimplifiableIfStatement
            if (id == R.id.workoutOption) {
                swaptoWorkoutList();
            }
            else if (id == R.id.ExerOption) {

                swaptoExerList();
            }
            else if (id == R.id.HomeOption) {
                backtoHomeScreen();
            }

            return super.onOptionsItemSelected(item);
        });



        Confirm_Complete = findViewById(R.id.ConfirmWO_Done_WEL);
        Confirm_Complete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                backToMain();//Kick back to three screen home
            }
        });

        setTestingInfosA();
        setWELAdapterA();


    }

    private void swaptoExerList() {
        Intent intenter = new Intent(this, Exercise_Listing_Activity.class);
        startActivity(intenter);

    }

    private void backtoHomeScreen() {

        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    private void swaptoWorkoutList() {
        ap=AppDatabase.getInstance(getApplicationContext());
        Intent intents = new Intent(this, Workout_Listing_Activity.class);
        List<Workout_Exercise> l1=ap.workout_exerciseDao().getAllWorkout_Exercises();
        intents.putExtra("workout_list", (Serializable) l1);
        startActivity(intents);

    }

    public void backToMain(){
        Intent intenters = new Intent(this, MainActivity.class);
        startActivity(intenters);

    }


    private void setWELAdapterA() {
        Workout_Exercise_List_Adapter Adap = new Workout_Exercise_List_Adapter(workoutList);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        RV_ItemD.setLayoutManager(layoutManager);
        RV_ItemD.setItemAnimator(new DefaultItemAnimator());
        RV_ItemD.setAdapter(Adap);
    }

    private void setTestingInfosA() {
        Intent i = getIntent();
        workoutList = (ArrayList<Workout_Exercise>) i.getSerializableExtra("name_list");
        WorkoutTitle.setText(workoutList.get(0).getWorkoutName());

        HashSet<String> uniqueNamesSetX = new HashSet<>();
        List<Workout_Exercise> uniqueWorkoutsList = new ArrayList<>();

      //  Log.d("Check", "Workout items: "+ workoutList.get(0).getName() + workoutList.get(0).getReps() );

/*
        WorkoutTitle.setText("Core Exercise");
        Exercise e1 = new Exercise();
        e1.setExercise("Plank");
        ExersANameList.add(e1);

        Exercise e2 = new Exercise();
        e2.setExercise("Sit-up");
        ExersANameList.add(e2);

        Exercise e3 = new Exercise();
        e3.setExercise("Squat");
        ExersANameList.add(e3);

        Exercise e4 = new Exercise();
        e4.setExercise("Bench Press");
        ExersANameList.add(e4);
*/
    }



}