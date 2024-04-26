package com.example.ThucTapLTS.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.time.LocalDateTime;

@Entity
@Table(name = "confirm_email")
public class ConfirmEmailEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "expired_time")
    private LocalDateTime expiredTime;

    @Column(name = "confirm_code")
    private String confirmCode;

    @Column(name = "is_confirm")
    private boolean isConfirm;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserEntity userEntity;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public LocalDateTime getExpiredTime() {
        return expiredTime;
    }

    public void setExpiredTime(LocalDateTime expiredTime) {
        this.expiredTime = expiredTime;
    }

    public String getConfirmCode() {
        return confirmCode;
    }

    public void setConfirmCode(String confirmCode) {
        this.confirmCode = confirmCode;
    }

    public boolean isConfirm() {
        return isConfirm;
    }

    public void setConfirm(boolean confirm) {
        isConfirm = confirm;
    }

    public UserEntity getUserEntity() {
        return userEntity;
    }

    public void setUserEntity(UserEntity userEntity) {
        this.userEntity = userEntity;
    }
}
