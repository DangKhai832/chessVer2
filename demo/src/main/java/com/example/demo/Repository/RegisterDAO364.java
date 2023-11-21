package com.example.demo.Repository;

import com.example.demo.Entity.member.Member364;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface RegisterDAO364 extends JpaRepository<Member364, Long> {
    @Query(value = "SELECT mb.fullname FROM tbl_Member364 mb WHERE mb.id = :id", nativeQuery = true)
    String getNameMember(@Param("id") int id);

    @Query(value = "SELECT COUNT(*) as count, c.memberId as memberId FROM tbl_account364 c WHERE c.username = :username AND c.password = :password", nativeQuery = true)
    List<Map<String, Object>> checkLogin(@Param("username") String username, @Param("password") String password);

    @Query(value = "SELECT 'Manager' as memberType FROM tbl_manager364 WHERE memberId = :id " +
            "UNION " +
            "SELECT 'Reader' as memberType FROM tbl_reader364 WHERE memberId = :id", nativeQuery = true)
    String getMemberType(@Param("id") Integer id);

}
