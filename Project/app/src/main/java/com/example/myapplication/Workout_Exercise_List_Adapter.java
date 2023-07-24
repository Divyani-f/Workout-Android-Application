package com.example.myapplication;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class Workout_Exercise_List_Adapter extends RecyclerView.Adapter<Workout_Exercise_List_Adapter.WEL_viewHolder> {

    private ArrayList<Exercise> WO_ExerNmList;

    public Workout_Exercise_List_Adapter(ArrayList<Exercise> ExerXNmItem){
        this.WO_ExerNmList = ExerXNmItem;
    }



    public class WEL_viewHolder extends RecyclerView.ViewHolder {

        private TextView ExerciseX_Name_Txt;

        public WEL_viewHolder(final View view) {
            super(view);
            ExerciseX_Name_Txt = view.findViewById(R.id.ExerName_WOEB_RV);
        }
    }

    @NonNull
    @Override
    public Workout_Exercise_List_Adapter.WEL_viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View WEL_Views = LayoutInflater.from(parent.getContext()).inflate(R.layout.workout_view, parent, false);
        return new Workout_Exercise_List_Adapter.WEL_viewHolder(WEL_Views);
    }

    @Override
    public void onBindViewHolder(@NonNull Workout_Exercise_List_Adapter.WEL_viewHolder holder, int position) {
        String ExerciseItem = WO_ExerNmList.get(position).getExercise();
        holder.ExerciseX_Name_Txt.setText(ExerciseItem);
    }

    @Override
    public int getItemCount() {
        return WO_ExerNmList.size();
    }
}
