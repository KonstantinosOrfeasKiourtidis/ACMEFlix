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
@Table(name = "GENRES", indexes = {@Index(columnList = "name")})
@SequenceGenerator(name = "idGenerator", sequenceName = "GENRES_SEQ", initialValue = 1, allocationSize = 1)
public class Genre extends BaseModel{
    @NotNull(message = "Genre's name cannot be null")
    @Column(length = 20, nullable = false)
    private String name;

    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @ManyToOne(targetEntity=Content.class, fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name="content_id")
    private Content content;
}
