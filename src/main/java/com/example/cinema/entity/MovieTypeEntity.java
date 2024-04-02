package com.example.cinema.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.List;

@Entity
@Table(name = "MovieType")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class MovieTypeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;

    @Column(name = "MovieTypeName")
    String movieTypeName;

    @Column(name = "IsActive")
    Boolean isActive;

    @OneToMany(mappedBy = "movieType", fetch = FetchType.LAZY)
    List<MovieEntity> movies;
}
