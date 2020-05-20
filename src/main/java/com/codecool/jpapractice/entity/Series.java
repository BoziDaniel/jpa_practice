package com.codecool.jpapractice.entity;


import lombok.*;

import javax.persistence.*;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Series {
    @Id
    @GeneratedValue
    private Long id;

    private String name;

    @Transient
    private int numberOfSeasons;

    @Singular
    @EqualsAndHashCode.Exclude
    @OneToMany(mappedBy = "series", cascade = {CascadeType.PERSIST})
    private List<Season> seasons;


    public void countNumberOfSeasons() {
        this.numberOfSeasons = seasons.size();
    }
}
