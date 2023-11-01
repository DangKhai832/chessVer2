package com.example.demo.Service;

import com.example.demo.BO.HistoryBO;
import com.example.demo.BO.UserBO;
import com.example.demo.DTO.UserDTO;
import com.example.demo.Repository.ChessRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
@Slf4j
public class ChessServiceImpl implements ChessService{
    @Autowired
    ChessRepository chessRepository;
    @Override
    public UserBO creatAucount(UserDTO obj) {
        obj.setIsDeleted(0L);
        obj.setElo(0L);
        obj.setCreatedDate(new Date());
        return chessRepository.saveAndFlush(obj.toModel());
    }

    @Override
    public List<UserDTO> doSearch(UserDTO obj) {
        return chessRepository.doSearch(obj);
    }

    @Override
    public UserBO update(UserDTO obj) {
        return chessRepository.update(obj);
    }

    @Override
    public UserBO delete(UserDTO obj) {
        return chessRepository.delete(obj);
    }

    @Override
    public HistoryBO getHistory(HistoryBO obj) {
        return chessRepository.getHistory(obj);
    }

    @Override
    public String checkLogin(UserDTO obj) {
        Long count = chessRepository.checkLogin(obj.getUsername(), obj.getPassword());
        if(count == 1) {
            return "SUCCESS";
        } else {
            return "FAIL";
        }
    }
}
