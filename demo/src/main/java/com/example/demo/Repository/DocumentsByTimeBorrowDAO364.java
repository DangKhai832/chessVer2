package com.example.demo.Repository;

import com.example.demo.Entity.document.BorrowDocument364;
import com.example.demo.Entity.document.Document364;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.util.List;

@Repository
public interface DocumentsByTimeBorrowDAO364 extends CrudRepository<Document364, Long> {

    @Query(value = "SELECT * FROM tbl_Document364 d INNER JOIN tbl_Borrow_Document364 bd ON d.id = bd.document_id WHERE bd.date >= :fromDate AND bd.date <= :toDate", nativeQuery = true)
    List<Document364> getDocumentByTimeBorrow(@Param("fromDate") Date fromDate, @Param("toDate") Date toDate);

    @Query(value = "SELECT bd.* FROM tbl_Borrow_Document364 bd WHERE bd.document_id = :documentId AND bd.date BETWEEN :fromDate AND :toDate", nativeQuery = true)
    List<BorrowDocument364> getDocumentTransactions(
            @Param("fromDate") Date fromDate,
            @Param("toDate") Date toDate,
            @Param("documentId") int documentId
    );
}

