package com.example.demo.Entity.member.reader;

import javax.persistence.*;

@Entity
@Table(name = "tblReader364")
public class Reader364  {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "readerId")
    private int readerId;

    @Column(name = "memberId")
    private int memberId;

    @Column(name = "createdDate")
    private int createdDate;

    public int getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(int createdDate) {
        this.createdDate = createdDate;
    }

    public int getReaderId() {
        return readerId;
    }

    public void setReaderId(int readerId) {
        this.readerId = readerId;
    }

    public int getMemberId() {
        return memberId;
    }

    public void setMemberId(int memberId) {
        this.memberId = memberId;
    }
}
