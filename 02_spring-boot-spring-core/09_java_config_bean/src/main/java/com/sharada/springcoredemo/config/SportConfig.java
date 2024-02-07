package com.sharada.springcoredemo.config;

import com.sharada.springcoredemo.common.Coach;
import com.sharada.springcoredemo.common.SwimCoach;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SportConfig {

    @Bean("aquatic") // We can also set the custom bean ID.
    public Coach swimCoach(){
        return new SwimCoach();
    }
}
