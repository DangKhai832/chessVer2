package com.example.demo.Entity.receipt;

import javax.persistence.*;

@Entity
@Table(name = "tblImportReceipt364")
public class ImportReceipt364 {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "importBorrowId")
    private Long importBorrowId;

    @Column(name = "receiptId")
    private Long receiptId;

    @Column(name = "wayPay")
    private String wayPay;

    @Column(name = "tranpostation")
    private String tranpostation;

    public Long getReceiptId() {
        return receiptId;
    }

    public void setReceiptId(Long receiptId) {
        this.receiptId = receiptId;
    }

    public Long getImportBorrowId() {
        return importBorrowId;
    }

    public void setImportBorrowId(Long importBorrowId) {
        this.importBorrowId = importBorrowId;
    }

    public String getWayPay() {
        return wayPay;
    }

    public void setWayPay(String wayPay) {
        this.wayPay = wayPay;
    }

    public String getTranpostation() {
        return tranpostation;
    }

    public void setTranpostation(String tranpostation) {
        this.tranpostation = tranpostation;
    }
}
