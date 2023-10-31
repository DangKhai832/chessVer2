package com.example.demo.Repository;

import com.example.demo.BO.UserBO;
import com.example.demo.DTO.UserDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Repository
public interface ChessRepository extends JpaRepository<UserBO,Long> {
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

    public default UserBO update(UserDTO obj){
        String url = "jdbc:mysql://localhost:3306/project";
        String user = "root";
        String password = "root";

        StringBuilder sb = new StringBuilder();
        sb.append(" UPDATE `chess ` SET `NAME`=?," +
                "`ADDRESS`=?," +
                "`PHONE_NUMBER`=?," +
                "`ELO`=?" +
                " WHERE ? ");
        UserBO userDTO = new UserBO();
        try (Connection connection = DriverManager.getConnection(url, user, password);
             PreparedStatement preparedStatement = connection.prepareStatement(sb.toString())) {

            ResultSet resultSet = preparedStatement.executeQuery();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return userDTO;
    };

    public default UserBO delete(UserDTO obj){
        String url = "jdbc:mysql://localhost:3306/project";
        String user = "root";
        String password = "root";

        StringBuilder sb = new StringBuilder();
        sb.append(" UPDATE `chess ` SET `IS_DELETE`= 1," +
                " WHERE ? ");
        UserBO userDTO = new UserBO();
        try (Connection connection = DriverManager.getConnection(url, user, password);
             PreparedStatement preparedStatement = connection.prepareStatement(sb.toString())) {

            ResultSet resultSet = preparedStatement.executeQuery();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return userDTO;
    };

//    public default UserBO detail(UserDTO obj){
//        String url = "jdbc:mysql://localhost:3306/project";
//        String user = "root";
//        String password = "root";
//
//        StringBuilder sb = new StringBuilder();
//        sb.append(" UPDATE `chess ` SET `IS_DELETE`= 1," +
//                " WHERE ? ");
//        UserBO userDTO = new UserBO();
//        try (Connection connection = DriverManager.getConnection(url, user, password);
//             PreparedStatement preparedStatement = connection.prepareStatement(sb.toString())) {
//
//            int parameterIndex = 1;
//            preparedStatement.setLong(parameterIndex, obj.getUserId());
//            ResultSet resultSet = preparedStatement.executeQuery();
//            userDTO.setUserId(resultSet.getLong("userId"));
//            userDTO.setName(resultSet.getString("name"));
//            userDTO.setAddress(resultSet.getString("address"));
//            userDTO.setPhoneNumber(resultSet.getString("phone_number"));
//            userDTO.setElo(resultSet.getLong("elo"));
//            userDTO.setCreatedDate(resultSet.getDate("createdDate"));
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        }
//        return userDTO;
//    };
}