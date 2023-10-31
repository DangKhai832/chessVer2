package com.example.demo.Controller;

import com.example.demo.BO.UserBO;
import com.example.demo.DTO.UserDTO;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

public interface RestController {
    @RequestMapping(value = "/doSearch", method = RequestMethod.POST)
    public List<UserDTO> doSearch(UserDTO obj);
    @RequestMapping(value = "/createAcc", method = RequestMethod.POST)
    public UserBO createdAcc(UserDTO obj);

    @PostMapping("/update")
    public UserBO update(UserDTO obj);

    @PostMapping("/delete")
    public UserBO delete(UserDTO obj);
}
