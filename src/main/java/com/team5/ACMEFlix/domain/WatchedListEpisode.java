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
@Table(name = "WATCHED_LIST_EPISODES")
@SequenceGenerator(name = "idGenerator", sequenceName = "WATCHED_LIST_EPISODE_SEQ", initialValue = 1, allocationSize = 1)
public class WatchedListEpisode extends BaseModel {

    @OneToOne
    @JoinColumn(name = "profile_id", referencedColumnName = "id")
    private Profile profile;

//    @OneToOne
//    @JoinColumn(name = "episode_id", referencedColumnName = "id")
//    private Episode episode;

    @NotNull(message = "Episode's watched date cannot be null")
    private Date watchedEpisodeDate;

    @ManyToMany(cascade=CascadeType.ALL)
    @JoinTable(name="watchedListEpisodes_contents", joinColumns=@JoinColumn(name="content_id"), inverseJoinColumns=@JoinColumn(name="watchedListEpisode_id"))
    private List<Content> contents;

}
