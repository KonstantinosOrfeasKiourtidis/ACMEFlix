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
@Table(name = "ACTORS", indexes = {@Index(columnList = "fullname")})
@SequenceGenerator(name = "idGenerator", sequenceName = "ACTORS_SEQ", initialValue = 1, allocationSize = 1)
public class Actor extends BaseModel{
    @NotNull(message = "Actor's name cannot be null")
    @Column(length = 150, nullable = false, unique = false)
    private String fullname;

    private String imageUrl;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    private Content content;


}
