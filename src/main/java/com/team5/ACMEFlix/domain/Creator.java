package com.team5.ACMEFlix.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.*;
import lombok.experimental.SuperBuilder;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "CREATORS", indexes = {@Index(columnList = "fullname")})
@SequenceGenerator(name = "idGenerator", sequenceName = "CREATORS_SEQ", initialValue = 1, allocationSize = 1)
public class Creator extends BaseModel{
    @NotNull(message = "Creator's name cannot be null")
    @Column(length = 150, nullable = false)
    @Pattern(regexp = "^[A-Za-z0-9\\. ]+$", message="Creator's fullname can only contain alphabetical symbols")
    private String fullname;

    private String imageUrl;

    @JsonBackReference
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @ManyToOne(targetEntity=TVSeries.class, fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name="tvSeries_id")
    private TVSeries tvSeries;
}
