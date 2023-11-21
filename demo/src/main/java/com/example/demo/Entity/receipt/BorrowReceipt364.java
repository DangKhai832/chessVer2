package com.example.demo.Entity.receipt;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "tblBorrowReceipt364")
public class BorrowReceipt364 {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "borrowReceiptId")
    private Long borrowReceiptId;

    @Column(name = "returnDate")
    private Date returnDate;

    @Column(name = "isPaid")
    private Long isPaid;

    @Column(name = "receiptId")
    private Long receiptId;


    public Long getReceiptId() {
        return receiptId;
    }

    public void setReceiptId(Long receiptId) {
        this.receiptId = receiptId;
    }

    public Long getBorrowReceiptId() {
        return borrowReceiptId;
    }

    public void setBorrowReceiptId(Long borrowReceiptId) {
        this.borrowReceiptId = borrowReceiptId;
    }

    public Date getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(Date returnDate) {
        this.returnDate = returnDate;
    }

    public Long getIsPaid() {
        return isPaid;
    }

    public void setIsPaid(Long isPaid) {
        this.isPaid = isPaid;
    }
}
