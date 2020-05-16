package com.codecool.jpapractice;

import com.codecool.jpapractice.entity.Episode;
import com.codecool.jpapractice.entity.FilmingLocation;
import com.codecool.jpapractice.repository.EpisodeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Arrays;

@SpringBootApplication
public class JpaPracticeApplication {


    public static void main(String[] args) {
        SpringApplication.run(JpaPracticeApplication.class, args);
    }

    @Autowired
    EpisodeRepository episodeRepository;


    @Bean
    public CommandLineRunner init() {
        return args -> {
            Episode episode_1 = Episode.builder()
                    .actors(Arrays.asList("john", "jane"))
                    .description("show starts")
                    .location(FilmingLocation.FILMORE)
                    .episodeNumberInSeason(1)
                    .episodeNumberInSeries(1)
                    .build();
            episodeRepository.save(episode_1);
        };
    }
}
