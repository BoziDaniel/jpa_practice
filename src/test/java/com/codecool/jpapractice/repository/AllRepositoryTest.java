package com.codecool.jpapractice.repository;

import com.codecool.jpapractice.entity.Episode;
import com.codecool.jpapractice.entity.FilmingLocation;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.*;


@RunWith(SpringRunner.class)
@DataJpaTest
@ActiveProfiles("test")

public class AllRepositoryTest {

    @Autowired
    private EpisodeRepository episodeRepository;

    @Test
    public void testSaveAnEpisode() {
        Episode episode_1 = Episode.builder()
                .actors(Arrays.asList("john", "jane"))
                .description("show starts")
                .location(FilmingLocation.FILMORE)
                .episodeNumberInSeason(1)
                .episodeNumberInSeries(1)
                .build();
        episodeRepository.save(episode_1);
        List<Episode> episodes = episodeRepository.findAll();
        assertThat(episodes).hasSize(1);
    }

}