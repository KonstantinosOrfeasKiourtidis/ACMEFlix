package com.team5.ACMEFlix.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;
import lombok.experimental.SuperBuilder;
import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

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

    @NotNull(message = "Episode's description cannot be null")
    @Column(length = 255, nullable = false)
    private String description;

    @NotNull(message = "Episode's number cannot be null")
    @Min(0)
    private Integer episodeNo;

    @NotNull(message = "Episode's release date cannot be null")
    @Column(length = 20, nullable = false)
    @Pattern(regexp = "^[A-Za-z0-9\\. ]+$", message="Episode's release date can only contain alphanumeric symbols")
    private String releaseDate;

    @JsonBackReference
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @ManyToOne(targetEntity=Season.class, fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name="season_id")
    private Season season;

}
