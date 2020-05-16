package com.codecool.jpapractice.entity;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Episode {
    @Id
    @GeneratedValue
    private Long id;

    private String Title;

    @ElementCollection
    private List<String> actors;

    private int episodeNumberInSeason;

  //  private Season season;
    private String description;

    @Enumerated(EnumType.STRING)
    private FilmingLocation location;

    @Transient
    private int episodeNumberInSeries;
}
