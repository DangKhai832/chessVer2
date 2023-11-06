package com.example.demo.Repository;

import com.example.demo.BO.HistoryBO;
import com.example.demo.BO.UserBO;
import com.example.demo.DTO.HistoryDTO;
import com.example.demo.DTO.UserDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

import java.math.BigInteger;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Repository
public interface ChessRepository extends CrudRepository<UserBO,Long> {
    public default List<UserDTO> doSearch(UserDTO obj) {
        String url = "jdbc:mysql://localhost:3306/project";
        String user = "root";
        String password = "root";

        StringBuilder sb = new StringBuilder();
        sb.append(" Select ");
        sb.append(" c.USER_ID userId, ");
        sb.append(" c.NAME  name, ");
        sb.append(" c.ADDRESS address, ");
        sb.append(" c.PHONE_NUMBER phone_number,  ");
        sb.append(" c.ELO elo,  ");
        sb.append(" c.CREATED_DATE createdDate  ");
        sb.append(" where IS_DELETED=0 ");
        if (StringUtils.hasText(obj.getAddress())) {
            sb.append(" AND upper(c.ADDRESS)  LIKE UPPER(?) escape '&' ");
        }
        if (StringUtils.hasText(obj.getName())) {
            sb.append(" AND upper(c.NAME)  LIKE UPPER(?) escape '&' ");
        }
        if (StringUtils.hasText(obj.getPhoneNumber())) {
            sb.append(" AND upper(c.PHONE_NUMBER)  LIKE UPPER(?) escape '&' ");
        }
        if (obj.getElo() != null) {
            sb.append(" AND c.ELO = ? ");
        }
        sb.append("ORDER BY c.USER_ID DESC ");
        List<UserDTO> results = new ArrayList<>();
        try (Connection connection = DriverManager.getConnection(url, user, password);
             PreparedStatement preparedStatement = connection.prepareStatement(sb.toString())) {

            int parameterIndex = 1;
            if (StringUtils.hasText(obj.getAddress())) {
                preparedStatement.setString(parameterIndex++, obj.getAddress());
            }
            if (StringUtils.hasText(obj.getName())) {
                preparedStatement.setString(parameterIndex++, obj.getName());
            }
            if (StringUtils.hasText(obj.getPhoneNumber())) {
                preparedStatement.setString(parameterIndex++, obj.getPhoneNumber());
            }
            if (obj.getElo() != null) {
                preparedStatement.setLong(parameterIndex, obj.getElo());
            }
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                UserDTO userDTO = new UserDTO();
                userDTO.setUserId(resultSet.getLong("userId"));
                userDTO.setName(resultSet.getString("name"));
                userDTO.setAddress(resultSet.getString("address"));
                userDTO.setPhoneNumber(resultSet.getString("phone_number"));
                userDTO.setElo(resultSet.getLong("elo"));
                userDTO.setCreatedDate(resultSet.getDate("createdDate"));
                results.add(userDTO);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return results;
    }
    @Query(value = "SELECT h.history_id historyId, h.color color, h.result result, h.updated_time updatedTime, h.user_id userId\n" +
            "FROM history h\n" +
            "WHERE h.user_id = :userId AND h.is_deleted = 0\n" +
            "ORDER BY h.history_id DESC;\n", nativeQuery = true)
    List<HistoryDTO> getHistory(@Param("userId") Long userId);

    @Query(value = "SELECT COUNT(*) as count, c.USER_ID as userId FROM CHESS c WHERE c.username = :username AND c.password = :password", nativeQuery = true)
    List<Map<BigInteger, BigInteger>> checkLogin(@Param("username") String username, @Param("password") String password);

    @Query(value = "SELECT COUNT(*) FROM CHESS c WHERE c.username = :username", nativeQuery = true)
    Long checkRepeat(@Param("username") String username);

    @Query(value = "SELECT  c.email email, c.name name, c.address address, c.phone_number phoneNumber FROM CHESS c WHERE c.user_id = :userId", nativeQuery = true)
    List<Object[]> getInfoUser(@Param("userId") Long userId);

    @Modifying
    @Query(value = "UPDATE CHESS c " +
            "SET c.email = CASE WHEN :email IS NOT NULL THEN :email ELSE c.email END, " +
            "c.name = CASE WHEN :name IS NOT NULL THEN :name ELSE c.name END, " +
            "c.address = CASE WHEN :address IS NOT NULL THEN :address ELSE c.address END, " +
            "c.phone_number = CASE WHEN :phoneNumber IS NOT NULL THEN :phoneNumber ELSE c.phone_number END " +
            "WHERE c.user_id = :userId", nativeQuery = true)
    int updateUserInfo(@Param("email") String email, @Param("name") String name, @Param("address") String address, @Param("phoneNumber") String phoneNumber, @Param("userId") Long userId);


    @Modifying
    @Query(value = "UPDATE HISTORY SET is_deleted = 1 WHERE HISTORY_ID = :historyId", nativeQuery = true)
    int softDeleteUser(@Param("historyId") Long historyId);
}