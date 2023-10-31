package com.example.demo.Service;

import com.example.demo.BO.UserBO;
import com.example.demo.DTO.UserDTO;
import com.example.demo.Repository.ChessRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
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
        log.info(obj.getName());
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
}
