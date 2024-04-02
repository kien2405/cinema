package com.example.cinema.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.Date;
import java.util.List;

@Entity
@Table(name = "Promotion")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class PromotionEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;

    @Column(name = "Percent")
    Integer percent;

    @Column(name = "Quantity")
    Integer quantity;

    @Column(name = "Type")
    String type;

    @Column(name = "StartTime")
    Date startTime;

    @Column(name = "EndTime")
    Date endTime;

    @Column(name = "Description")
    String description;

    @Column(name = "Name")
    String name;

    @ManyToOne
    @JoinColumn(name = "RankCustomerId")
    RankCustomerEntity rankCustomer;

    @Column(name = "IsActive")
    Boolean isActive;

    @OneToMany(mappedBy = "promotion", fetch = FetchType.LAZY)
    List<BillEntity> bills;
}
