package com.team5.ACMEFlix.domain;

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

    @NotNull(message = "Director's name cannot be null")
    @Column(length = 150, nullable = false, unique = false)
    private String fullname;

    private String imageUrl;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    private Movie movie;
}
