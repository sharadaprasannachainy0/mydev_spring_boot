package com.sharada.springcoredemo.common;

import org.springframework.stereotype.Component;

// Marking Track Coach as @lazy
@Component
public class TrackCoach implements Coach{

    public TrackCoach(){
        System.out.println("In constructor: "+ getClass().getSimpleName());
    }

    @Override
    public String getDailyWorkout() {
        return "Run hard 5k";
    }
}
