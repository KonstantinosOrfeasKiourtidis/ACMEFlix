package com.team5.ACMEFlix.domain;

import lombok.*;
import lombok.experimental.SuperBuilder;
import javax.persistence.*;
import java.util.List;

@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "MOVIES")
@SequenceGenerator(name = "idGenerator", sequenceName = "MOVIES_SEQ", initialValue = 1, allocationSize = 1)
public class Movie extends Content {

    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @OneToMany(targetEntity=Writer.class, fetch = FetchType.LAZY, mappedBy = "movie", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Writer> writers;

    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @OneToMany(targetEntity=Director.class, fetch = FetchType.LAZY, mappedBy = "movie", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Director> directors;

}
