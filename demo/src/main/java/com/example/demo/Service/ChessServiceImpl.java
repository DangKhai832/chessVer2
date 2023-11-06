package com.example.demo.Service;

import com.example.demo.BO.HistoryBO;
import com.example.demo.BO.UserBO;
import com.example.demo.DTO.HistoryDTO;
import com.example.demo.DTO.UserDTO;
import com.example.demo.Repository.ChessRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Slf4j
public class ChessServiceImpl implements ChessService{
    @Autowired
    ChessRepository chessRepository;
    @Autowired
    private ConversionService conversionService;

    public HistoryBO convertBigIntegerToHistoryBO(java.math.BigInteger source) {
        HistoryBO historyBO = conversionService.convert(source, HistoryBO.class);
        return historyBO;
    }
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
    public List<HistoryDTO>getHistory(UserDTO obj) {
        return chessRepository.getHistory(obj.getUserId());
    }

    @Override
    public Long checkLogin(UserDTO obj) {
        List<Map<BigInteger, BigInteger>> result = chessRepository.checkLogin(obj.getUsername(), obj.getPassword());

        if (result.size() == 1 && result.get(0).get("userId") != null ) {
            Map<BigInteger, BigInteger> singleResult = result.get(0);
            BigInteger userId = singleResult.get("userId");
            return userId.longValue();
        } else {
            return -1L;
        }
    }

    @Override
    public String checkRepeat(UserDTO obj) {
        Long count = chessRepository.checkRepeat(obj.getUsername());
        if(count == 0) {
            return "SUCCESS";
        } else {
            return "FAIL";
        }
    }
}
