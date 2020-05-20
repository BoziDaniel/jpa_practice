package com.codecool.jpapractice.repository;

import com.codecool.jpapractice.entity.Episode;
import com.codecool.jpapractice.entity.FilmingLocation;
import com.codecool.jpapractice.entity.Season;
import com.codecool.jpapractice.entity.Series;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import java.beans.Transient;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.as;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.*;


@RunWith(SpringRunner.class)
@DataJpaTest
@ActiveProfiles("test")

public class AllRepositoryTest {
    @Autowired
    private TestEntityManager entityManager;
    @Autowired
    private EpisodeRepository episodeRepository;
    @Autowired
    private SeriesRepository seriesRepository;

    @Test
    public void testSaveAnEpisode() {
        Episode episode_1 = Episode.builder()
                .actors(Arrays.asList("john", "jane"))
                .description("show starts")
                .location(FilmingLocation.FILMORE)
                .episodeNumberInSeason(1)
                .build();
        episodeRepository.save(episode_1);
        List<Episode> episodes = episodeRepository.findAll();
        assertThat(episodes).hasSize(1);
    }

//    @Test
//    public void testTransientIsNotSaved() {
//        Episode episode_1 = Episode.builder()
//                .actors(Arrays.asList("john", "jane"))
//                .description("show starts")
//                .location(FilmingLocation.FILMORE)
//                .episodeNumberInSeason(1)
//                .title("s01e01")
//                .build();
//        Episode episode_2 = Episode.builder()
//                .actors(Arrays.asList("john", "jane"))
//                .description("show builds up")
//                .location(FilmingLocation.PASADENA)
//                .episodeNumberInSeason(2)
//                .title("s01e02")
//                .build();
//        Episode episode_3 = Episode.builder()
//                .actors(Arrays.asList("john", "jane"))
//                .description("show goes on")
//                .location(FilmingLocation.PASADENA)
//                .episodeNumberInSeason(1)
//                .title("s02e01")
//                .build();
//        Season season_1 = Season.builder()
//                .seasonNumber(1)
//                .episodes(Arrays.asList(episode_1, episode_2))
//                .build();
//        Season season_2 = Season.builder()
//                .seasonNumber(2)
//                .episode(episode_3)
//                .build();
//
//        episode_1.setSeason(season_1);
//        episode_2.setSeason(season_1);
//        episode_3.setSeason(season_2);
//
//
//        Series Jericho = Series.builder()
//                .name("Jericho")
//                .seasons(Arrays.asList(season_1, season_2))
//                .build();
//        season_1.setSeries(Jericho);
//        season_2.setSeries(Jericho);
//        Jericho.countNumberOfSeasons();
//        System.out.println(Jericho.getNumberOfSeasons());
//        assertThat(Jericho.getNumberOfSeasons()).isEqualTo(2);
//        seriesRepository.save(Jericho);
//        entityManager.clear();

        // toString is not working!
    

}