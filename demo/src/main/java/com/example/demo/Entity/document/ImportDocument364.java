package com.example.demo.Entity.document;


import javax.persistence.*;

@Entity
@Table(name = "tblImportDocument364")
public class ImportDocument364 {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "importDocumentId")
    private int importDocumentId;

    @Column(name = "documentId")
    private int documentId;

    @Column(name = "cost")
    private int cost;


    public int getId() {
        return importDocumentId;
    }

    public void setId(int id) {
        this.importDocumentId = importDocumentId;
    }

    public int getDocumentId() {
        return documentId;
    }

    public void setDocumentId(int documentId) {
        this.documentId = documentId;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }
}
