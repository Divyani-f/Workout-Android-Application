package com.example.myapplication;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class Workout_Exercise_List_Adapter extends RecyclerView.Adapter<Workout_Exercise_List_Adapter.WEL_viewHolder> {

    private ArrayList<Workout_Exercise> WO_ExerNmList;

    public Workout_Exercise_List_Adapter(ArrayList<Workout_Exercise> ExerXNmItem){
        this.WO_ExerNmList = ExerXNmItem;
    }



    public class WEL_viewHolder extends RecyclerView.ViewHolder {

        private TextView ExerciseX_Name_Txt;

        private TextView ExerX_Reps_Txt;

        private TextView ExerX_Sets_Txt;

        private TextView ExerX_Weight_Txt;
        public WEL_viewHolder(final View view) {
            super(view);
            ExerciseX_Name_Txt = view.findViewById(R.id.ExerName_WOEB_RV);
            ExerX_Reps_Txt = view.findViewById(R.id.ExerReps_WOEB_RV);
            ExerX_Sets_Txt = view.findViewById(R.id.ExerSets_WOEB_RV);
            ExerX_Weight_Txt = view.findViewById(R.id.ExerWeight_WOEB_RV);

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
        holder.ExerciseX_Name_Txt.setText(WO_ExerNmList.get(position).getName());
        holder.ExerX_Reps_Txt.setText(WO_ExerNmList.get(position).getReps());
        holder.ExerX_Sets_Txt.setText(WO_ExerNmList.get(position).getSet());
        holder.ExerX_Weight_Txt.setText(WO_ExerNmList.get(position).getWeights());

    }

    @Override
    public int getItemCount() {
        return WO_ExerNmList.size();
    }
}
