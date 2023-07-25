package com.example.myapplication;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;
@Dao
public interface Workout_ExerciseDao {
    @Insert
    void insert_Workout_Exercise(Workout_Exercise workout_exercise);

    @Query("SELECT * FROM Workout_Exercise")
    List<Workout_Exercise> getAllWorkout_Exercises();
    @Query("SELECT * FROM Workout_Exercise WHERE name = :exerciseName")
    List<Workout_Exercise> getWorkout_ExercisesByName(String exerciseName);
}
