package com.codecool.jpapractice.entity;


import lombok.*;

import javax.persistence.*;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Season {
    @Id
    @GeneratedValue
    private Long id;

    private int seasonNumber;

    @ManyToOne
    private Series series;

    @Singular
    @EqualsAndHashCode.Exclude
    @OneToMany(mappedBy = "season", cascade ={ CascadeType.PERSIST})
    private List<Episode> episodes;
}
