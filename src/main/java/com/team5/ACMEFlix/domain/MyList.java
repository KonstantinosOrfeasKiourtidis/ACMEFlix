package com.team5.ACMEFlix.domain;

import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import java.util.List;

@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "MY_LISTS")
@SequenceGenerator(name = "idGenerator", sequenceName = "MY_LISTS_SEQ", initialValue = 1, allocationSize = 1)
public class MyList extends BaseModel{

    @OneToOne(targetEntity=Profile.class, fetch = FetchType.LAZY)
    @JoinColumn(name = "profile_id", referencedColumnName = "id")
    private Profile profile;

    @ManyToMany(targetEntity=Content.class, fetch = FetchType.LAZY)
    @JoinTable(name="myLists_contents", joinColumns=@JoinColumn(name="content_id"), inverseJoinColumns=@JoinColumn(name="myList_id"))
    private List<Content> contents;
}
