package com.example.myapplication;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


public class New_Workout_View extends RecyclerView.ViewHolder {
    TextView ExerName;
    TextView ExerRepsx;
    TextView ExerSetsx;
    TextView ExerWeightx;

    public New_Workout_View(@NonNull View itemView) {
        super(itemView);

        ExerName = itemView.findViewById(R.id.ExerciseName_NWO_RV);
        ExerRepsx = itemView.findViewById(R.id.ExerRep_NWO_RV);
        ExerSetsx = itemView.findViewById(R.id.ExerSet_NWO_RV);
        ExerWeightx = itemView.findViewById(R.id.ExerWeight_NWO_RV);
    }
}
