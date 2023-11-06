package com.example.demo.Controller;

import com.example.demo.BO.HistoryBO;
import com.example.demo.BO.UserBO;
import com.example.demo.DTO.HistoryDTO;
import com.example.demo.DTO.UserDTO;
import com.example.demo.Service.ChessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Map;

@org.springframework.web.bind.annotation.RestController
public class RestControllerImpl implements RestController{
    @Autowired
    ChessService chessService;
    @Override
    public List<UserDTO> doSearch(UserDTO obj) {
        List<UserDTO> data = chessService.doSearch(obj);
        return data;
    }

    @Override
    public UserBO createdAcc(@RequestBody UserDTO obj) {
        return chessService.creatAucount(obj);
    }

    @Override
    public Long checkLogin(UserDTO obj) {
        return chessService.checkLogin(obj);
    }

    @Override
    public String checkRepeat(UserDTO obj) {
        return chessService.checkRepeat(obj);
    }

    @Override
    public List<HistoryDTO> getHistory(UserDTO obj) {
        return chessService.getHistory(obj);
    }

    @Override
    public List<HistoryDTO> update() {
        return null;
    }

    @Override
    public List<HistoryDTO> remove() {
        return null;
    }
}
