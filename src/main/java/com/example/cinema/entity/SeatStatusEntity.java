package com.example.cinema.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.List;

@Entity
@Table(name = "SeatStatus")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class SeatStatusEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;

    @Column(name = "Code")
    String code;

    @Column(name = "NameStatus")
    String nameStatus;

    @OneToMany(mappedBy = "seatStatus", fetch = FetchType.LAZY)
    List<SeatEntity> seats;
}
