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

    @Singular
    @EqualsAndHashCode.Exclude
    @OneToMany(mappedBy = "series", cascade = {CascadeType.PERSIST})
    private List<Season> seasons;
}
