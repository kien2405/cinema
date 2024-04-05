package com.example.cinema.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.List;

@Entity
@Table(name = "User")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;

    @Column(name = "Point")
    Integer point;

    @Column(name = "Username")
    String username;

    @Column(name = "Email")
    String email;

    @Column(name = "Name")
    String name;

    @Column(name = "PhoneNumber")
    String phoneNumber;

    @Column(name = "Password")
    String password;

    @ManyToOne
    @JoinColumn(name = "RankCustomerId")
    RankCustomerEntity rankCustomer;

    @ManyToOne
    @JoinColumn(name = "UserStatusId")
    UserStatusEntity userStatus;

    @Column(name = "IsActive")
    Boolean isActive;

    @ManyToOne
    @JoinColumn(name = "RoleId")
    RoleEntity role;

    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
    List<RefreshTokenEntity> refreshTokens;

    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
    List<ConfirmEmailEntity> confirmEmails;

    @OneToMany(mappedBy = "customerId", fetch = FetchType.LAZY)
    List<BillEntity> bills;

}
