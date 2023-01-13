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
@Table(name = "WATCHED_LIST_EPISODES")
@SequenceGenerator(name = "idGenerator", sequenceName = "WATCHED_LIST_EPISODE_SEQ", initialValue = 1, allocationSize = 1)
public class WatchedListEpisode extends BaseModel {

    @OneToOne
    @JoinColumn(name = "profile_id", referencedColumnName = "id")
    private Profile profile;

    @NotNull(message = "Episode's time watched cannot be null")
    @Min(1)
    private Integer timeWatchedInSeconds;

    @NotNull(message = "Episode's watched date cannot be null")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd hh:mm:ss.SSS")
    private Date watchedEpisodeDate = new Date();

    @OneToOne
    @JoinColumn(name = "episode_id", referencedColumnName = "id")
    private Episode episode;

}
