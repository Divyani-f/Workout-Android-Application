package com.example.myapplication;
//This is a holder class for array testing on the recycler views!!
//Might need to replace when database is installed!

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;
import java.io.Serializable;
@Entity(tableName = "Exercise")
public class Exercise implements Serializable{
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name="_id")
    private long id;
    @NonNull
    @ColumnInfo(name="name")
    private String exerciseName;
    @NonNull
    @ColumnInfo(name="description")
    private String description;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @NonNull
    public String getExerciseName() {
        return exerciseName;
    }

    public void setExerciseName(@NonNull String exerciseName) {
        this.exerciseName = exerciseName;
    }

    @NonNull
    public String getDescription() {
        return description;
    }

    public void setDescription(@NonNull String description) {
        this.description = description;
    }
    private String Exercise;



    public String getExercise(){
        return Exercise;
    }

    public void setExercise(String Exercise){
        this.Exercise = Exercise;
    }
}
