package com.example.cinema.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.Date;

@Entity
@Table(name = "ConfirmEmail")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ConfirmEmailEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;

    @Column(name = "ExpiredTime")
    Date expiredTime;

    @Column(name = "ConfirmCode")
    String confirmCode;

    @Column(name = "IsConfirm")
    Boolean isConfirm;

    @ManyToOne
    @JoinColumn(name = "UserId")
    UserEntity user;
}
