package com.example.myapplication;

import java.util.ArrayList;
import java.util.List;

public class AddExercise {
    public static List<Exercise> AllExercises(){
    List<Exercise> e=new ArrayList<Exercise>() ;
    Exercise e1= new Exercise();
    e1.setExerciseName("Push-ups");
    e1.setDescription("A bodyweight exercise that strengthens the chest, shoulders, triceps, and core. Start in a plank position, lower your body by bending your elbows, and push back up.");
    e.add(e1);
    Exercise e2= new Exercise();
    e2.setExerciseName("Squats");
    e2.setDescription("A lower body exercise that targets the quadriceps, hamstrings, glutes, and core. Stand with feet shoulder-width apart, bend your knees, and lower your hips as if sitting in a chair. Keep your back straight and chest up.");
        e.add(e2);
    return e;
    }
}
