package com.team5.ACMEFlix.domain;

import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
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

    @OneToOne
    @JoinColumn(name = "profile_id", referencedColumnName = "id")
    private Profile profile;

//    @OneToOne
//    @JoinColumn(name = "movie_id", referencedColumnName = "id")
//    private Movie movie;

    @NotNull(message = "Movie's watched date cannot be null")
    private Date watchedMovieDate;

    @ManyToMany(cascade=CascadeType.ALL)
    @JoinTable(name="watchedListMovies_contents", joinColumns=@JoinColumn(name="content_id"), inverseJoinColumns=@JoinColumn(name="watchedListMovie_id"))
    private List<Content> contents;

}
