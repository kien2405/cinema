package com.example.ThucTapLTS.entity;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "user")
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "point")
    private int point;

    @Column(name = "username")
    private String username;

    @Column(name = "email")
    private String email;

    @Column(name = "name")
    private String name;

    @Column(name = "phone_number")
    private String phoneNumber;

    @Column(name = "password")
    private String password;

    @Column(name = "is_active")
    private boolean isActive;

    @ManyToOne
    @JoinColumn(name = "rank_customer_id")
    private RankCustomerEntity rankCustomerEntity;

    @ManyToOne
    @JoinColumn(name = "role_id")
    private RoleEntity roleEntity;

    @ManyToOne
    @JoinColumn(name = "user_status_id")
    private UserStatusEntity userStatusEntity;

    @OneToMany(mappedBy = "userEntity")
    List<BillEntity> billEntityList;

    @OneToMany(mappedBy = "userEntity")
    List<ConfirmEmailEntity> confirmEmailEntityList;

    @OneToMany(mappedBy = "userEntity")
    List<RefreshTokenEntity> refreshTokenEntityList;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getPoint() {
        return point;
    }

    public void setPoint(int point) {
        this.point = point;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public RankCustomerEntity getRankCustomerEntity() {
        return rankCustomerEntity;
    }

    public void setRankCustomerEntity(RankCustomerEntity rankCustomerEntity) {
        this.rankCustomerEntity = rankCustomerEntity;
    }

    public RoleEntity getRoleEntity() {
        return roleEntity;
    }

    public void setRoleEntity(RoleEntity roleEntity) {
        this.roleEntity = roleEntity;
    }

    public UserStatusEntity getUserStatusEntity() {
        return userStatusEntity;
    }

    public void setUserStatusEntity(UserStatusEntity userStatusEntity) {
        this.userStatusEntity = userStatusEntity;
    }

    public List<BillEntity> getBillEntityList() {
        return billEntityList;
    }

    public void setBillEntityList(List<BillEntity> billEntityList) {
        this.billEntityList = billEntityList;
    }

    public List<ConfirmEmailEntity> getConfirmEmailEntityList() {
        return confirmEmailEntityList;
    }

    public void setConfirmEmailEntityList(List<ConfirmEmailEntity> confirmEmailEntityList) {
        this.confirmEmailEntityList = confirmEmailEntityList;
    }

    public List<RefreshTokenEntity> getRefreshTokenEntityList() {
        return refreshTokenEntityList;
    }

    public void setRefreshTokenEntityList(List<RefreshTokenEntity> refreshTokenEntityList) {
        this.refreshTokenEntityList = refreshTokenEntityList;
    }
}
