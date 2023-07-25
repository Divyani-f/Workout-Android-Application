package com.example.myapplication;

import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

public interface WorkoutDao {
    @Insert
    void insertWorkout(Workout workout);

    @Query("SELECT * FROM Workout")
    List<Workout> getAllWorkouts();

}
