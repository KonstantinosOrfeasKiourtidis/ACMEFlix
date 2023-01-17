package com.team5.ACMEFlix.domain;


import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;


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
    @JoinColumn(name = "view_id", referencedColumnName = "id")
    private View view;

    @OneToOne
    @JoinColumn(name = "episode_id", referencedColumnName = "id")
    private Episode episode;

}
