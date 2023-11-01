package com.example.demo.Service;



import com.example.demo.BO.HistoryBO;
import com.example.demo.BO.UserBO;
import com.example.demo.DTO.HistoryDTO;
import com.example.demo.DTO.UserDTO;

import java.util.List;

public interface ChessService {
    UserBO creatAucount(UserDTO obj);

    List<UserDTO> doSearch(UserDTO obj);

    UserBO update(UserDTO obj);

    UserBO delete(UserDTO obj);

    List<HistoryDTO> getHistory();

    String checkLogin(UserDTO obj);
}
