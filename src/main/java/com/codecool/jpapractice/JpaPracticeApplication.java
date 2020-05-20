package com.codecool.jpapractice;

import com.codecool.jpapractice.entity.Episode;
import com.codecool.jpapractice.entity.FilmingLocation;
import com.codecool.jpapractice.entity.Season;
import com.codecool.jpapractice.entity.Series;
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
            Episode episode_1 = Episode.builder()
                    .actors(Arrays.asList("john", "jane"))
                    .description("show starts")
                    .location(FilmingLocation.FILMORE)
                    .episodeNumberInSeason(1)
                    .title("s01e01")
                    .build();
            Episode episode_2 = Episode.builder()
                    .actors(Arrays.asList("john", "jane"))
                    .description("show builds up")
                    .location(FilmingLocation.PASADENA)
                    .episodeNumberInSeason(2)
                    .title("s01e02")
                    .build();
            Episode episode_3 = Episode.builder()
                    .actors(Arrays.asList("john", "jane"))
                    .description("show goes on")
                    .location(FilmingLocation.PASADENA)
                    .episodeNumberInSeason(1)
                    .title("s02e01")
                    .build();
            Season season_1 = Season.builder()
                    .seasonNumber(1)
                    .episodes(Arrays.asList(episode_1, episode_2))
                    .build();
            Season season_2 = Season.builder()
                    .seasonNumber(2)
                    .episode(episode_3)
                    .build();

            episode_1.setSeason(season_1);
            episode_2.setSeason(season_1);
            episode_3.setSeason(season_2);


            Series Jericho = Series.builder()
                    .name("Jericho")
                    .seasons(Arrays.asList(season_1,season_2))
                    .build();

            season_1.setSeries(Jericho);
            season_2.setSeries(Jericho);
            seriesRepository.save(Jericho);

        };
    }
}
