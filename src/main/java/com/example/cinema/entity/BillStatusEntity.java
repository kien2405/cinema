package com.example.cinema.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.List;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "BillStatus")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class BillStatusEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;

    @Column(name = "Name")
    String name;

    @OneToMany(mappedBy = "billStatus", fetch = FetchType.LAZY)
    List<BillEntity> bills;

}
