package com.example.cinema.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.Date;
import java.util.List;

@Entity
@Table(name = "Movie")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class MovieEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;

    @Column(name = "MovieDuration")
    Integer movieDuration;

    @Column(name = "EndTime")
    Date endTime;

    @Column(name = "PremiereDate")
    Date premiereDate;

    @Column(name = "Description")
    String description;

    @Column(name = "Director")
    String director;

    @Column(name = "Image")
    String image;

    @Column(name = "HeroImage")
    String heroImage;

    @Column(name = "Language")
    String language;

    @ManyToOne
    @JoinColumn(name = "MovieTypeId")
    MovieTypeEntity movieType;

    @ManyToOne
    @JoinColumn(name = "RateId")
    RateEntity rate;

    @Column(name = "Name")
    String name;

    @Column(name = "Trailer")
    String trailer;

    @Column(name = "IsActive")
    Boolean isActive;

    @OneToMany(mappedBy = "movie", fetch = FetchType.LAZY)
    List<ScheduleEntity> schedules;
}
