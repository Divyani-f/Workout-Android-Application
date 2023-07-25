package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class New_WorkoutExerciseActivity extends AppCompatActivity {
    private Button done;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_workout_exercise);
        done = findViewById(R.id.Complete_WE_Create);
        done.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){
                Intent i = getIntent();
                Workout_Exercise we= new Workout_Exercise();
                String wname= i.getStringExtra("workout_name");
                String name = ((EditText) findViewById(R.id.EditText_WorkoutExerciseName_Create)).getText().toString();
                String weights = ((EditText) findViewById(R.id.EditText_weights)).getText().toString();
                String reps = ((EditText) findViewById(R.id.EditReps)).getText().toString();
                String sets = ((EditText) findViewById(R.id.EditSets)).getText().toString();
                we.setWorkoutName(wname);
                we.setName(name);
                we.setReps(reps);
                we.setWeights(weights);
                we.setSet(sets);
                Intent resultInten = new Intent();
                resultInten.putExtra("workout_exercise", we);
                setResult(RESULT_OK, resultInten);
                finish();
            }
        });
    }

}