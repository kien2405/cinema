package com.example.cinema.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.Date;
import java.util.List;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Table(name = "Bill")
public class BillEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;

    @Column(name = "Name")
    String name;

    @Column(name = "TotalMoney")
    Double totalMoney;

    @Column(name = "TradingCode")
    String tradingCode;

    @Column(name = "CreateTime")
    Date createTime;
    @ManyToOne
    @JoinColumn(name = "CustomerId")
    UserEntity customerId;

    @Column(name = "UpdateTime")
    Date updateTime;

    @ManyToOne
    @JoinColumn(name = "PromotionId")
    PromotionEntity promotion;

    @ManyToOne
    @JoinColumn(name = "BillStatusId", nullable = false)
    BillStatusEntity billStatus;

    @Column(name = "IsActive")
    Boolean isActive;

    @OneToMany(mappedBy = "bill", fetch = FetchType.LAZY)
    List<BillFoodEntity> billFoods;
}
