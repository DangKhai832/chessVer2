package com.example.demo.BO;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "HISTORY")
public class HistoryBO {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "HISTORY_ID")
    private Long historyId;

    @Column(name = "COLOR")
    private String color;

    @Column(name = "RESULT")
    private String result;

    @Column(name = "UPDATED_TIME")
    private LocalDateTime updatedTime;

    @Column(name = "USER_ID")
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
}
