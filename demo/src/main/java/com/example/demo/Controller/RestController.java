package com.example.demo.Controller;

import com.example.demo.BO.HistoryBO;
import com.example.demo.BO.UserBO;
import com.example.demo.DTO.UserDTO;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public interface RestController {
    @RequestMapping(value = "/doSearch", method = RequestMethod.POST)
    public List<UserDTO> doSearch(UserDTO obj);
    @RequestMapping(value = "/createAcc", method = RequestMethod.POST)
    public UserBO createdAcc(@RequestBody UserDTO obj);

    @RequestMapping(value = "/checkLogin", method = RequestMethod.POST)
    public String checkLogin(@RequestBody UserDTO obj);

    @PostMapping("/update")
    public UserBO update(UserDTO obj);

    @PostMapping("/delete")
    public UserBO delete(UserDTO obj);
    @PostMapping("/getHistory")
    public HistoryBO getHistory(HistoryBO obj);

}
