package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class Workout_Exercise_List_Activity extends AppCompatActivity {

    private ArrayList<Exercise> ExersANameList;
    private RecyclerView RV_ItemD;
    private TextView WorkoutTitle;

    private Button Confirm_Complete;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_workout_exercise_list);

        RV_ItemD = findViewById(R.id.WorkExerBridge_List_RecycleV);
        ExersANameList = new ArrayList<>();
        WorkoutTitle = findViewById(R.id.WorkoutName_EL_L);
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

    public void backToMain(){
        Intent intenters = new Intent(this, MainActivity.class);
        startActivity(intenters);

    }


    private void setWELAdapterA() {
        Workout_Exercise_List_Adapter Adap = new Workout_Exercise_List_Adapter(ExersANameList);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        RV_ItemD.setLayoutManager(layoutManager);
        RV_ItemD.setItemAnimator(new DefaultItemAnimator());
        RV_ItemD.setAdapter(Adap);
    }

    private void setTestingInfosA() {
        WorkoutTitle.setText("Core Exercise");
        ExersANameList.add(new Exercise("Plank"));
        ExersANameList.add(new Exercise("Sit-up"));
        ExersANameList.add(new Exercise("Squat"));
        ExersANameList.add(new Exercise("Bench Press"));
    }


}