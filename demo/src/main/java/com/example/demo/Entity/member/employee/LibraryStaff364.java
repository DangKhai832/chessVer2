package com.example.demo.Entity.member.employee;


import javax.persistence.*;

@Entity
@Table(name = "tblLibraryStaff364")
public class LibraryStaff364 {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "libraryStaffId")
    private int libraryStaffId;

    @Column(name = "memberId")
    private int memberId;


    public int getLibraryStaffId() {
        return libraryStaffId;
    }

    public void setLibraryStaffId(int libraryStaffId) {
        this.libraryStaffId = libraryStaffId;
    }

    public int getMemberId() {
        return memberId;
    }

    public void setMemberId(int memberId) {
        this.memberId = memberId;
    }
}
