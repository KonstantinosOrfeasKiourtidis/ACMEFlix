package com.team5.ACMEFlix.domain;

import com.team5.ACMEFlix.domain.enumeration.ContentType;
import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.util.List;

@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "CONTENTS", indexes = {@Index(columnList = "title")})
@SequenceGenerator(name = "idGenerator", sequenceName = "CONTENTS_SEQ", initialValue = 1, allocationSize = 1)
public class Content extends BaseModel {

    @NotNull(message = "Content's title cannot be null")
    @Column(length = 50, nullable = false, unique = false)
    private String title;

    @NotNull(message = "Content's description cannot be null")
    @Column(length = 255, nullable = false, unique = false)
    private String description;

    @NotNull(message = "Content's language cannot be null")
    @Column(length = 20, nullable = false, unique = false)
    private String spokenLanguage;

    @NotNull(message = "Content's release date cannot be null")
    @Column(length = 20, nullable = false, unique = false)
    private String releaseDate;

    private String imageUrl;
    private String trailerUrl;

    @NotNull(message = "Content's age restriction cannot be null")
    private Boolean isAgeRestricted;

    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "content", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Genre> genres;

    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "content", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Actor> actors;

    @NotNull(message = "Content's type cannot be null")
    @Enumerated(EnumType.STRING)
    @Column(length = 20, nullable = false)
    private ContentType contentType;

    @NotNull(message = "Content's runtime cannot be null")
    @Min(0)
    private Integer runtime;

}
