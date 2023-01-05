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

    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "profile_id", referencedColumnName = "id")
    private Profile profile;

    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @ManyToMany(cascade=CascadeType.ALL, targetEntity=Content.class, fetch = FetchType.LAZY)
    @JoinTable(name="myLists_contents", joinColumns=@JoinColumn(name="content_id"), inverseJoinColumns=@JoinColumn(name="myList_id"))
    private List<Content> contents;
}
