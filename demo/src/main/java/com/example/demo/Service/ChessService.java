package com.example.demo.Service;

import com.example.demo.BO.UserBO;
import com.example.demo.DTO.HistoryDTO;
import com.example.demo.DTO.UserDTO;

import java.util.List;
import java.util.Map;

public interface ChessService {
    UserBO creatAucount(UserDTO obj);

    List<UserDTO> doSearch(UserDTO obj);

    List<HistoryDTO> getHistory(UserDTO obj);

    Long checkLogin(UserDTO obj);

    String checkRepeat(UserDTO obj);
}
