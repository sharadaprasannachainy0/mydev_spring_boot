package com.sharada.springcoredemo;

import org.springframework.stereotype.Component;

// @Component annotation marks the class as a Spring Bean and also makes it available for dependency injection.
@Component
public class CricketCoach implements Coach {

    @Override
    public String getDailyWorkout() {
        return "Practice fast bowling for 15 minutes.";
    }
}
