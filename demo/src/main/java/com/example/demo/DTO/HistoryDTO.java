package com.example.demo.DTO;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDateTime;

public interface HistoryDTO {
    Long getHistoryId();
    Long getColor();
    Long getResult();
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy HH:mm:ss")
    LocalDateTime getUpdatedTime();
    Long getUserId();
    Long isDeleted();
}
