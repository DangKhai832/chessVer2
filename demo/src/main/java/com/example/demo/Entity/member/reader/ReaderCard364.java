package com.example.demo.Entity.member.reader;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "tblReaderCard364")
public class ReaderCard364 {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "readerCardId")
    private int readerCardId;

    @Column(name = "memberId")
    private int memberId;

    @Column(name = "timeExpiredDate")
    private Date timeExpiredDate;

    @Column(name = "createdCardDate")
    private Date createdCardDate;

    public int getMemberId() {
        return memberId;
    }

    public void setMemberId(int memberId) {
        this.memberId = memberId;
    }

    public int getReaderCardId() {
        return readerCardId;
    }

    public void setReaderCardId(int readerCardId) {
        this.readerCardId = readerCardId;
    }

    public Date getTimeExpiredDate() {
        return timeExpiredDate;
    }

    public void setTimeExpiredDate(Date timeExpiredDate) {
        this.timeExpiredDate = timeExpiredDate;
    }

    public Date getCreatedCardDate() {
        return createdCardDate;
    }

    public void setCreatedCardDate(Date createdCardDate) {
        this.createdCardDate = createdCardDate;
    }
}
