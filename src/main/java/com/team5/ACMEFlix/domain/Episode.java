package com.team5.ACMEFlix.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;
import lombok.experimental.SuperBuilder;
import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;


@JsonInclude(JsonInclude.Include.ALWAYS)
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
    @Column(length = 50, nullable = false)
    private String title;

    private String imageUrl;

    private String description;

    @NotNull(message = "Episode's number cannot be null")
    @Min(0)
    private Integer episodeNo;

    @Column(length = 20)
    private String releaseDate;

    @JsonBackReference
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @ManyToOne(targetEntity=Season.class, fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name="season_id")
    private Season season;

}
