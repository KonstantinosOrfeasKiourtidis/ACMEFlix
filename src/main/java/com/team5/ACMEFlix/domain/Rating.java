package com.team5.ACMEFlix.domain;


import lombok.*;
import lombok.experimental.SuperBuilder;
import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

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
    @Max(100)
    private Float rating;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    private Profile profile;

    @OneToOne
    @JoinColumn(name = "content_id", referencedColumnName = "id")
    private Content content;
}
