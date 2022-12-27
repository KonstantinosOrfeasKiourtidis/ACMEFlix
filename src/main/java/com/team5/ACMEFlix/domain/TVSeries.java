package com.team5.ACMEFlix.domain;

import com.team5.ACMEFlix.domain.enumeration.TVSeriesStatusType;
import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "TV_SERIES")
@SequenceGenerator(name = "idGenerator", sequenceName = "TV_SERIES_SEQ", initialValue = 1, allocationSize = 1)
public class TVSeries extends BaseModel {

    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "tvSeries", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Season> seasons;

    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "tvSeries", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Creator> creators;

    @NotNull(message = "TV Series status type cannot be null")
    @Enumerated(EnumType.STRING)
    @Column(length = 20, nullable = false)
    private TVSeriesStatusType tvSeriesStatusType;

    @OneToOne
    @JoinColumn(name = "content_id", referencedColumnName = "id")
    private Content content;
}
