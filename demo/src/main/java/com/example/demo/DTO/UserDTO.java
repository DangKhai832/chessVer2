package com.example.demo.DTO;

import com.example.demo.BO.UserBO;

import java.util.Date;

public class UserDTO {
    private Long userId;
    private String name;
    private String email;
    private String address;
    private String phoneNumber;
    private Long elo;
    private Date createdDate;
    private Long isDeleted;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Long getElo() {
        return elo;
    }

    public void setElo(Long elo) {
        this.elo = elo;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public Long getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(Long isDeleted) {
        this.isDeleted = isDeleted;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public UserBO toModel () {
        UserBO bo = new UserBO();
        bo.setUserId(this.userId);
        bo.setName(this.name);
        bo.setAddress(this.address);
        bo.setPhoneNumber(this.address);
        bo.setElo(this.elo);
        bo.setCreatedDate(this.createdDate);
        bo.setIsDeleted(this.isDeleted);
        bo.setEmail(this.email);
        return bo;
    }
}
