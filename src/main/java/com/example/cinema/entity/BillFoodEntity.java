package com.example.cinema.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "BillFood")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class BillFoodEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;

    @Column(name = "Quantity")
    Integer quantity;

    @ManyToOne
    @JoinColumn(name = "BillId", nullable = false)
    BillEntity bill;

    @ManyToOne
    @JoinColumn(name = "FoodId")
    FoodEntity food;
}
