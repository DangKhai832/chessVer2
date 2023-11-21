package com.example.demo.Service;

import com.example.demo.Entity.document.BorrowDocument364;
import com.example.demo.Entity.document.Document364;
import com.example.demo.Entity.document.DocumentsByTimeBorrow364;
import com.example.demo.Entity.dto.LoginResultDTO;
import com.example.demo.Entity.member.Account364;
import com.example.demo.Entity.member.Member364;
import com.example.demo.Repository.DocumentsByTimeBorrowDAO364;
import com.example.demo.Repository.RegisterDAO364;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.Map;

@Service
public class ServiceLibman {
    @Autowired
    RegisterDAO364 messageRepository;

    @Autowired
    DocumentsByTimeBorrowDAO364 documentsByTimeBorrowDAO364;

    public String getNameMember(int id) {
        String mess = messageRepository.getNameMember(id);
        return mess;
    }

    public ResponseEntity<LoginResultDTO> checkLogin(Account364 obj) {
        List<Map<String, Object>> result = messageRepository.checkLogin(obj.getUsername(), obj.getPassword());

        LoginResultDTO loginResult = new LoginResultDTO();

        if (result.size() == 1 && result.get(0).get("memberId") != null) {
            Map<String, Object> singleResult = result.get(0);
            Integer memberId = (Integer) singleResult.get("memberId");
            loginResult.setMemberId(memberId != null ? memberId : -1);

            // Kiểm tra loại (type) của memberId
            if (isManager(memberId)) {
                loginResult.setType(1); // Manager
            } else {
                loginResult.setType(2); // Reader
            }
        } else {
            loginResult.setMemberId(-1);
            loginResult.setType(0); // Not Found
        }

        return new ResponseEntity<>(loginResult, HttpStatus.OK);
    }

    private boolean isManager(Integer memberId) {
        if ("Manager".equals(messageRepository.getMemberType(memberId))) {
            return true;
        } else {
            return false;
        }

    }

    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public void readerCardRegister(Member364 member) {
        String query = "UPDATE tbl_member364 " +
                "SET fullname = :fullname, dob = :dob, email = :email, " +
                "phone_number = :phone_number, address = :address " +
                "WHERE id = :id";

        entityManager.createNativeQuery(query)
                .setParameter("fullname", member.getFullname())
                .setParameter("dob", member.getDob())
                .setParameter("email", member.getEmail())
                .setParameter("phone_number", member.getPhoneNumber())
                .setParameter("address", member.getAddress())
                .setParameter("id", member.getId())
                .executeUpdate();

        String createCardQuery = "INSERT INTO tbl_reader_card364 " +
                "(created_card_date, time_expired_date, memberId) " +
                "VALUES (:created_card_date, :time_expired_date, :memberId)";

        // Ngày hôm nay
        LocalDate today = LocalDate.now();

        // Ngày hết hạn là 3 năm sau ngày hôm nay
        LocalDate expirationDate = today.plus(3, ChronoUnit.YEARS);

        entityManager.createNativeQuery(createCardQuery)
                .setParameter("created_card_date", today)
                .setParameter("time_expired_date", expirationDate)
                .setParameter("memberId", member.getId())
                .executeUpdate();
    }

    public List<Document364> viewDocumentsFromDateToDate(DocumentsByTimeBorrow364 obj) {
        return documentsByTimeBorrowDAO364.getDocumentByTimeBorrow(obj.getFromDate(), obj.getToDate());
    }

    public List<BorrowDocument364> getDocumentTransactions(DocumentsByTimeBorrow364 obj) {
        return documentsByTimeBorrowDAO364.getDocumentTransactions(obj.getFromDate(), obj.getToDate(), obj.getDocumentId());
    }
}
