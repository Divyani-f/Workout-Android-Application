package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "Workout")
public class Workout {
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @NonNull
    public String getWorkoutName() {
        return workoutName;
    }

    public void setWorkoutName(@NonNull String workoutName) {
        this.workoutName = workoutName;
    }

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name="_id")
    private long id;
    @NonNull
    @ColumnInfo(name="name")
    private String workoutName;
}
