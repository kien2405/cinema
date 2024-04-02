package com.example.cinema.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.List;

@Entity
@Table(name = "RankCustomer")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class RankCustomerEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;

    @Column(name = "Point")
    Integer point;

    @Column(name = "Description")
    String description;

    @Column(name = "Name")
    String name;

    @Column(name = "IsActive")
    Boolean isActive;

    @OneToMany(mappedBy = "rankCustomer", fetch = FetchType.LAZY)
    List<PromotionEntity> promotions;

    @OneToMany(mappedBy = "rankCustomer", fetch = FetchType.LAZY)
    List<UserEntity> users;
}
