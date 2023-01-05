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

    @NotNull(message = "Episode's time watched cannot be null")
    private Integer timeWatched;

    @NotNull(message = "Episode's watched date cannot be null")
    private Date watchedEpisodeDate;

    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @ManyToMany(cascade=CascadeType.ALL, targetEntity=Episode.class, fetch = FetchType.LAZY)
    @JoinTable(name="watchedListEpisodes_contents", joinColumns=@JoinColumn(name="content_id"), inverseJoinColumns=@JoinColumn(name="watchedListEpisode_id"))
    private List<Episode> episodes;

}
