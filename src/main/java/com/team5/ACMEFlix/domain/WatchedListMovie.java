package com.team5.ACMEFlix.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;

@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "WATCHED_LIST_MOVIES")
@SequenceGenerator(name = "idGenerator", sequenceName = "WATCHED_LIST_MOVIE_SEQ", initialValue = 1, allocationSize = 1)
public class WatchedListMovie extends BaseModel {

    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "profile_id", referencedColumnName = "id")
    private Profile profile;

    @NotNull(message = "Movie's time watched cannot be null")
    @Min(1)
    private Integer timeWatchedInSeconds;

    @NotNull(message = "Movie's watched date cannot be null")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd hh:mm:ss.SSS")
    private Date watchedMovieDate = new Date();

    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @ManyToMany(cascade=CascadeType.ALL, targetEntity=Movie.class, fetch = FetchType.LAZY)
    @JoinTable(name="watchedListMovies_contents", joinColumns=@JoinColumn(name="content_id"), inverseJoinColumns=@JoinColumn(name="watchedListMovie_id"))
    private List<Movie> movies;

}
