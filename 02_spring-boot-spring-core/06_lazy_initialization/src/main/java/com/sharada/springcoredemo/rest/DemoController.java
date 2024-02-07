package com.sharada.springcoredemo.rest;

import com.sharada.springcoredemo.common.Coach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

    // Define a private field for the dependency
    private Coach myCoach;

// Define a constructor for dependency injection
    // When multiple class has implement the same interface then, use @Qualifier annotation to specify the class for dependency injection.
        // Adding a Diagnostic print statement.

    @Autowired
    public DemoController(@Qualifier("cricketCoach") Coach theCoach) {
        System.out.println("In constructor: "+ getClass().getSimpleName());
        myCoach = theCoach;
    }

/*
    // Define setter method for dependency injection
    @Autowired
    public void setCoach(Coach theCoach) {
        myCoach = theCoach;
    }
*/

    @GetMapping("/dailyworkout")
    public String getDailyWorkout() {
        return myCoach.getDailyWorkout();
    }
}
