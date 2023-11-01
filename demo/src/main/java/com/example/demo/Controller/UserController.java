package com.example.demo.Controller;


import com.example.demo.BO.UserBO;
import com.example.demo.DTO.UserDTO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;
public interface UserController {

    @GetMapping("/login")
    public String home();

    @GetMapping("/createAccount")
    public String createAccount();
    @GetMapping("/information")
    public String getInformation();
}
