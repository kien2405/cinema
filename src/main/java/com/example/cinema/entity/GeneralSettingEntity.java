package com.example.cinema.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.Date;

@Entity
@Table(name = "GeneralSetting")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class GeneralSettingEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;

    @Column(name = "BreakTime")
    Date breakTime;

    @Column(name = "BusinessHours")
    Integer businessHours;

    @Column(name = "CloseTime")
    Date closeTime;

    @Column(name = "FixedTicketPrice")
    Double fixedTicketPrice;

    @Column(name = "PercentDay")
    Integer percentDay;

    @Column(name = "PercentWeekend")
    Integer percentWeekend;

    @Column(name = "TimeBeginToChange")
    Date timeBeginToChange;

}
