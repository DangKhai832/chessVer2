package com.example.demo.Controller;

import com.example.demo.BO.UserBO;
import com.example.demo.DTO.UserDTO;
import com.example.demo.Service.ChessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import java.util.List;

@Controller
public class UserControllerImpl implements UserController {

    @Override
    public  String home() { return "login.html";}

    @Override
    public String createAccount() {
        return "accountCreationScreen.html";
    }

    @Override
    public String getInformation() {
        return "information.html";
    }
}
