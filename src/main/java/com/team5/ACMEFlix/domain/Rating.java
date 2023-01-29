package com.team5.ACMEFlix.domain;

import lombok.*;
import lombok.experimental.SuperBuilder;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "RATINGS", indexes = {@Index(columnList = "rating")})
@SequenceGenerator(name = "idGenerator", sequenceName = "RATINGS_SEQ", initialValue = 1, allocationSize = 1)
public class Rating extends BaseModel {
    @Min(0)
    @Max(10)
    @NotNull(message = "Rating cannot be null")
    private Double rating;

    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @OnDelete(action = OnDeleteAction.CASCADE)
    @ManyToOne(targetEntity=Profile.class, fetch = FetchType.LAZY,  optional = false)
    @JoinColumn(name="profile_id")
    private Profile profile;

    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @ManyToOne(targetEntity=Content.class, fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name="content_id")
    private Content content;
}
