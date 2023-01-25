package com.team5.ACMEFlix.domain;


import lombok.*;
import lombok.experimental.SuperBuilder;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;


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
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "view_id", referencedColumnName = "id")
    private View view;

    @OneToOne
    @JoinColumn(name = "movie_id", referencedColumnName = "id")
    private Movie movie;

}
