package com.example.demo.Entity.dto;

import java.util.Date;

public class ReceiptDTO {
    private int id;
    private int status;
    private Date date;
    private Double subTotal;
    private Double totalExpense;
    private Long borrowReceiptId;
    private Date returnDate;
    private Long isPaid;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Double getSubTotal() {
        return subTotal;
    }

    public void setSubTotal(Double subTotal) {
        this.subTotal = subTotal;
    }

    public Double getTotalExpense() {
        return totalExpense;
    }

    public void setTotalExpense(Double totalExpense) {
        this.totalExpense = totalExpense;
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
