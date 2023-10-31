package com.example.demo.Controller;

import com.example.demo.BO.UserBO;
import com.example.demo.DTO.UserDTO;
import com.example.demo.Service.ChessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

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
    public UserBO update(UserDTO obj) {
        return chessService.update(obj);
    }

    @Override
    public UserBO delete(UserDTO obj) {
        return chessService.delete(obj);
    }
}
