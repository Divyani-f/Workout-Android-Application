package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.io.Serializable;

@Entity(tableName = "Workout_Exercise")
public class Workout_Exercise implements Serializable {
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name="_id")
    private long id;

    @NonNull
    public String getName() {
        return name;
    }

    public void setName(@NonNull String name) {
        this.name = name;
    }

    @NonNull
    public String getWorkoutName() {
        return WorkoutName;
    }

    public void setWorkoutName(@NonNull String workoutName) {
        WorkoutName = workoutName;
    }

    @NonNull
    @ColumnInfo(name="workout_name")
    private String WorkoutName;
    @NonNull
    @ColumnInfo(name="name")
    private String name;
    @NonNull
    @ColumnInfo(name="reps")
    private String reps;
    @NonNull
    @ColumnInfo(name="weights")
    private String weights;
    @NonNull
    @ColumnInfo(name="set")
    private String set;
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }



    @NonNull
    public String getReps() {
        return reps;
    }

    public void setReps(@NonNull String reps) {
        this.reps = reps;
    }

    @NonNull
    public String getWeights() {
        return weights;
    }

    public void setWeights(@NonNull String weights) {
        this.weights = weights;
    }

    @NonNull
    public String getSet() {
        return set;
    }

    public void setSet(@NonNull String set) {
        this.set = set;
    }


}
