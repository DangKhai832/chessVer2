package com.example.demo.Entity.member.employee;


import javax.persistence.*;

@Entity
@Table(name = "tblManager364")
public class Manager364  {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "managerId")
    private int managerId;

    @Column(name = "memberId")
    private int memberId;

    public int getManagerId() {
        return managerId;
    }

    public void setManagerId(int managerId) {
        this.managerId = managerId;
    }

    public int getMemberId() {
        return memberId;
    }

    public void setMemberId(int memberId) {
        this.memberId = memberId;
    }
}
