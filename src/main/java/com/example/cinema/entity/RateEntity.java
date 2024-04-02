package com.example.cinema.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.List;

@Entity
@Table(name = "Rate")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class RateEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;

    @Column(name = "Description")
    String description;

    @Column(name = "Code")
    String code;

    @OneToMany(mappedBy = "rate", fetch = FetchType.LAZY)
    List<MovieEntity> movies;

}
