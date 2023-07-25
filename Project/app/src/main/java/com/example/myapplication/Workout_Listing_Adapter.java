package com.example.myapplication;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class Workout_Listing_Adapter extends RecyclerView.Adapter<Workout_Listing_Adapter.WOL_viewHolder> {

    private ArrayList<Workout_Exercise> WorkONames;
    public interface OnItemClickListener {
        void onItemClick(Workout_Exercise workoutExercise);
    }
    private OnItemClickListener itemClickListener;
    public Workout_Listing_Adapter(ArrayList<Workout_Exercise> WorkONmItem,OnItemClickListener itemClickListener){
        this.WorkONames = WorkONmItem;
        this.itemClickListener=itemClickListener;
    }

    public class WOL_viewHolder extends RecyclerView.ViewHolder{
        private TextView Workout_Name_Txt;

        public WOL_viewHolder(final View view){
            super(view);
            Workout_Name_Txt = view.findViewById(R.id.WorkoutNmItem_RV);
        }

    }


    @NonNull
    @Override
    public Workout_Listing_Adapter.WOL_viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View WOL_View = LayoutInflater.from(parent.getContext()).inflate(R.layout.workout_listing_view, parent, false);
        WOL_View.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (itemClickListener != null) {
                    int position = (int) v.getTag();
                    if (position != RecyclerView.NO_POSITION) {
                        itemClickListener.onItemClick(WorkONames.get(position));
                    }
                }
            }
        });
        return new WOL_viewHolder(WOL_View);
    }

    @Override
    public void onBindViewHolder(@NonNull Workout_Listing_Adapter.WOL_viewHolder holder, int position) {
        String WorkoutItem = WorkONames.get(position).getWorkoutName();
        holder.Workout_Name_Txt.setText(WorkoutItem);
        holder.itemView.setTag(position);
    }

    @Override
    public int getItemCount() {
        return WorkONames.size();
    }




}
