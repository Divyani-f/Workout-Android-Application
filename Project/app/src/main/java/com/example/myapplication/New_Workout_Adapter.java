package com.example.myapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class New_Workout_Adapter extends RecyclerView.Adapter<New_Workout_Adapter.NWO_viewHolder> {

    private ArrayList<Exercise> ExerList;

    public New_Workout_Adapter(ArrayList<Exercise> ExerSList){
        this.ExerList = ExerSList;
    }

    public class NWO_viewHolder extends RecyclerView.ViewHolder{
        private TextView ExerName;
        private TextView ExerRepsx;
        private TextView ExerSetsx;
        private TextView ExerWeightx;
        public NWO_viewHolder(final View view){
            super(view);
            ExerName = view.findViewById(R.id.ExerciseName_NWO_RV);
            ExerRepsx = view.findViewById(R.id.ExerRep_NWO_RV);
            ExerSetsx = view.findViewById(R.id.ExerSet_NWO_RV);
            ExerWeightx = view.findViewById(R.id.ExerWeight_NWO_RV);
        }

    }

    @NonNull
    @Override
    public New_Workout_Adapter.NWO_viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View NWO_View = LayoutInflater.from(parent.getContext()).inflate(R.layout.new_workout_view, parent, false);
        return new NWO_viewHolder(NWO_View);

    }

    @Override
    public void onBindViewHolder(@NonNull New_Workout_Adapter.NWO_viewHolder holder, int position) {
        String ExersNameX = ExerList.get(position).getExercise();
        holder.ExerName.setText(ExersNameX);
    }

    @Override
    public int getItemCount() {
        return ExerList.size();
    }
}
