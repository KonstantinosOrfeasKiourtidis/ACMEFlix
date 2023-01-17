package com.team5.ACMEFlix.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "DIRECTORS", indexes = {@Index(columnList = "fullname")})
@SequenceGenerator(name = "idGenerator", sequenceName = "DIRECTORS_SEQ", initialValue = 1, allocationSize = 1)
public class Director extends BaseModel{

    @NotNull(message = "Director's fullname cannot be null")
    @Column(length = 150, nullable = false)
    private String fullname;

    private String imageUrl;

    @JsonBackReference
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @ManyToOne(targetEntity=Movie.class, fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name="movie_id")
    private Movie movie;
}
