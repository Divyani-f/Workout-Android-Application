package com.example.myapplication;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class Exercise_Listing_Adapter extends RecyclerView.Adapter<Exercise_Listing_Adapter.EL_viewHolder> {

    private ArrayList<Exercise> ExerNmList;

    public Exercise_Listing_Adapter(ArrayList<Exercise> ExerXNmItem){
        this.ExerNmList = ExerXNmItem;
    }

    public class EL_viewHolder extends RecyclerView.ViewHolder {

        private TextView Exercise_Name_Txt;

        public EL_viewHolder(final View view) {
            super(view);
            Exercise_Name_Txt = view.findViewById(R.id.ExerciseName_EL_RV);
        }
    }

    @NonNull
    @Override
    public Exercise_Listing_Adapter.EL_viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View EL_View = LayoutInflater.from(parent.getContext()).inflate(R.layout.exercise_list_view, parent, false);
        return new Exercise_Listing_Adapter.EL_viewHolder(EL_View);
    }

    @Override
    public void onBindViewHolder(@NonNull Exercise_Listing_Adapter.EL_viewHolder holder, int position) {
        String WorkoutItem = ExerNmList.get(position).getExercise();
        holder.Exercise_Name_Txt.setText(WorkoutItem);
    }

    @Override
    public int getItemCount() {
        return ExerNmList.size();
    }
}
