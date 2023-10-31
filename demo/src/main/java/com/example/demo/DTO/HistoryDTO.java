package com.example.demo.DTO;

import com.example.demo.BO.HistoryBO;
import com.example.demo.BO.UserBO;

import java.time.LocalDateTime;

public class HistoryDTO {
    private Long historyId;
    private String color;
    private String result;
    private LocalDateTime updatedTime;
    private Long userId;

    public Long getHistoryId() {
        return historyId;
    }

    public void setHistoryId(Long historyId) {
        this.historyId = historyId;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public LocalDateTime getUpdatedTime() {
        return updatedTime;
    }

    public void setUpdatedTime(LocalDateTime updatedTime) {
        this.updatedTime = updatedTime;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
    public HistoryBO toModel () {
        HistoryBO bo = new HistoryBO();
        bo.setHistoryId(this.historyId);
        bo.setColor(this.color);
        bo.setResult(this.result);
        bo.setUpdatedTime(this.updatedTime);
        bo.setUserId(this.userId);
        return bo;
    }
}
