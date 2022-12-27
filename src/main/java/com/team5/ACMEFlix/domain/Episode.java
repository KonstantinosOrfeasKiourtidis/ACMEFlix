package com.team5.ACMEFlix.domain;

import lombok.*;
import lombok.experimental.SuperBuilder;
import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "EPISODES", indexes = {@Index(columnList = "title")})
@SequenceGenerator(name = "idGenerator", sequenceName = "EPISODES_SEQ", initialValue = 1, allocationSize = 1)
public class Episode extends BaseModel{

    @NotNull(message = "Episode's title cannot be null")
    @Column(length = 50, nullable = false, unique = false)
    private String title;

    private String imageUrl;

    @NotNull(message = "Episode's description cannot be null")
    @Column(length = 255, nullable = false, unique = false)
    private String description;

    @NotNull(message = "Episode's number cannot be null")
    @Min(1)
    private Integer episodeNo;

    @NotNull(message = "Episode's release date cannot be null")
    @Column(length = 20, nullable = false, unique = false)
    private String releaseDate;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    private Season season;

}
