package com.example.myapplication;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.DialogFragment;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.List;

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
                Workout w= new Workout();
                WorkoutName = findViewById(R.id.EditText_WorkoutName_Create);
                WO_Name = WorkoutName.getText().toString();
                w.setWorkoutName(WO_Name);
                Intent resultIntent = new Intent();
                resultIntent.putExtra("workout", w);
                setResult(RESULT_OK, resultIntent);
                finish();
            }
        });

        AddExer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Set up switch to the exercise list to add to list
                //Pass workout ID to properly store info with the AddExercise Dialog
                //
                Intent intentIt = new Intent(getApplicationContext(), New_WorkoutExerciseActivity.class);
                WorkoutName = findViewById(R.id.EditText_WorkoutName_Create);
                WO_Name = WorkoutName.getText().toString();
                intentIt.putExtra("workout_name", WO_Name);
                newWorkoutActivityResultLauncher.launch(intentIt); // Use the launcher to start the activity

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
  /*      Exercise e1 = new Exercise();
        e1.setExercise("Plank");
        ExerListA.add(e1);

        Exercise e2 = new Exercise();
        e2.setExercise("Sit-up");
        ExerListA.add(e2);

        Exercise e3 = new Exercise();
        e3.setExercise("Squat");
        ExerListA.add(e3);

        Exercise e4 = new Exercise();
        e4.setExercise("Bench Press");
        ExerListA.add(e4);
*/
    }


    public void BacktoHome(){
        //Actual call to the Main Activity
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
    private AppDatabase ap;
    private final ActivityResultLauncher<Intent> newWorkoutActivityResultLauncher = registerForActivityResult(
            new ActivityResultContracts.StartActivityForResult(),
            result -> {
                Log.d("Here2","yaay hre");
                if (result.getResultCode() == RESULT_OK) {

                    Intent data = result.getData();
                    if (data != null) {

                        // Extract the Workout object from the intent

                        Workout_Exercise workout_exercise=(Workout_Exercise) data.getSerializableExtra("workout_exercise");

                        if(workout_exercise!=null){
                            Log.d("Here","yaay hre");
                            ap=AppDatabase.getInstance(getApplicationContext());
                            ap.workout_exerciseDao().insert_Workout_Exercise(workout_exercise);
                            List<Workout_Exercise> l1=ap.workout_exerciseDao().getAllWorkout_Exercises();
                            for(Workout_Exercise w: l1){
                                Log.d("WorkoutLog", "Workout name: " +w.getName() );
                            }

                        }
                    }
                }
            });
}