package com.example.demo.Controller;

import com.example.demo.BO.HistoryBO;
import com.example.demo.BO.UserBO;
import com.example.demo.DTO.HistoryDTO;
import com.example.demo.DTO.UserDTO;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

public interface RestController {
    @RequestMapping(value = "/doSearch", method = RequestMethod.POST)
    public List<UserDTO> doSearch(@RequestBody UserDTO obj);

    @RequestMapping(value = "/createAcc", method = RequestMethod.POST)
    public UserBO createdAcc(@RequestBody UserDTO obj);

    @RequestMapping(value = "/checkLogin", method = RequestMethod.POST)
    public Long checkLogin(@RequestBody UserDTO obj);

    @RequestMapping(value = "/checkRepeat", method = RequestMethod.POST)
    public String checkRepeat(@RequestBody UserDTO obj);

    @RequestMapping(value = "/getHistory", method = RequestMethod.POST)
    public List<HistoryDTO> getHistory(@RequestBody UserDTO obj);

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public List<HistoryDTO> update();

    @RequestMapping(value = "/remove", method = RequestMethod.POST)
    public List<HistoryDTO> remove();

}
