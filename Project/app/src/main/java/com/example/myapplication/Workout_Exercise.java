package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "Workout_Exercise")
public class Workout_Exercise {
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name="_id")
    private long id;
    @NonNull
    @ColumnInfo(name="exerciseID")
    private String exerciseID;
    @NonNull
    @ColumnInfo(name="workoutID")
    private String workoutID;
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
    public String getExerciseID() {
        return exerciseID;
    }

    public void setExerciseID(@NonNull String exerciseID) {
        this.exerciseID = exerciseID;
    }

    @NonNull
    public String getWorkoutID() {
        return workoutID;
    }

    public void setWorkoutID(@NonNull String workoutID) {
        this.workoutID = workoutID;
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
