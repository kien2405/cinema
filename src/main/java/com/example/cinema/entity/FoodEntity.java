package com.example.cinema.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.List;

@Entity
@Table(name = "Food")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class FoodEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;

    @Column(name = "Price")
    Double price;

    @Column(name = "Description")
    String description;

    @Column(name = "Image")
    String image;

    @Column(name = "NameOfFood")
    String nameOfFood;

    @Column(name = "IsActive")
    Boolean isActive;

    @OneToMany(mappedBy = "food", fetch = FetchType.LAZY)
    List<BillFoodEntity> billFoods;
}
