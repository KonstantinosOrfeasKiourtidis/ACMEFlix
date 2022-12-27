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
@Table(name = "WRITERS", indexes = {@Index(columnList = "fullname")})
@SequenceGenerator(name = "idGenerator", sequenceName = "WRITERS_SEQ", initialValue = 1, allocationSize = 1)
public class Writer extends BaseModel{

    @NotNull(message = "Writer's name cannot be null")
    @Column(length = 150, nullable = false, unique = false)
    private String fullname;

    private String imageUrl;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    private Movie movie;
}
