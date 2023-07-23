package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;

public class New_Workout_Activity extends AppCompatActivity {
    private ArrayList<Exercise> ExerListA;
    private RecyclerView RV_ItemA;
    private EditText WorkoutName;
    private Button Complete;
    private Button AddExer;
    private Button CancelAll;
    String WO_Name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_workout);

        WorkoutName = findViewById(R.id.EditText_WorkoutName_Create);
        Complete = findViewById(R.id.Complete_WO_Create);
        AddExer = findViewById(R.id.AddEx_to_WO_Create);
        CancelAll = findViewById(R.id.Cancel_WO_Create);

        RV_ItemA = findViewById(R.id.NewWorkout_RecycleV);
        ExerListA = new ArrayList<>();
        setTestInfo();
        setNWOAdapter();
        //Create Workout ID for table!!!


        //Grab Workout Name
        WO_Name = WorkoutName.getText().toString();
        //Apply workout name to workout table!!!


        Complete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){
            //Finalize any database calls to ensure the workout, exercise, and bridge are updated!

                BacktoHome(); //Return to the Main Activity (Three Button Home)
            }
        });

        AddExer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Set up switch to the exercise list to add to list
                //Pass workout ID to properly store info with the AddExercise Dialog
                //

            }
        });

        CancelAll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Set up switch to DeleteConfirm Dialog
                //Pass along workout ID to dialog for deletion from workoutlist and bridge tables


                BacktoHome(); //Return to the Main Activity (Three Button Home)
            }
        });

    }

    private void setNWOAdapter() {
        New_Workout_Adapter adapt = new New_Workout_Adapter(ExerListA);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        RV_ItemA.setLayoutManager(layoutManager);
        RV_ItemA.setItemAnimator(new DefaultItemAnimator());
        RV_ItemA.setAdapter(adapt);
    }

    private void setTestInfo() {
        ExerListA.add(new Exercise("Plank"));
        ExerListA.add(new Exercise("Sit-up"));
        ExerListA.add(new Exercise("Squat"));
        ExerListA.add(new Exercise("Bench Press"));
    }


    public void BacktoHome(){
        //Actual call to the Main Activity
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

}