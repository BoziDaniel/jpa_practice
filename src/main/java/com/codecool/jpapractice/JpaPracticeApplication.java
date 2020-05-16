package com.codecool.jpapractice;

import com.codecool.jpapractice.entity.Episode;
import com.codecool.jpapractice.entity.FilmingLocation;
import com.codecool.jpapractice.repository.EpisodeRepository;
import com.codecool.jpapractice.repository.SeasonRepository;
import com.codecool.jpapractice.repository.SeriesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;
import java.util.Arrays;

@SpringBootApplication
public class JpaPracticeApplication {

    public static void main(String[] args) {
        SpringApplication.run(JpaPracticeApplication.class, args);
    }

    @Autowired
    private EpisodeRepository episodeRepository;

    @Autowired
    private SeasonRepository seasonRepository;

    @Autowired
    private SeriesRepository seriesRepository;

    @Profile("production")
    @Bean
    public CommandLineRunner init() {
        return args -> {
        };
    }
}
