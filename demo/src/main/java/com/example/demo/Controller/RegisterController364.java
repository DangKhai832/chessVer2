package com.example.demo.Controller;



import com.example.demo.Entity.dto.LoginResultDTO;
import com.example.demo.Entity.member.Account364;
import com.example.demo.Entity.member.Member364;
import com.example.demo.Service.ServiceLibman;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class RegisterController364 {

    @Autowired
    ServiceLibman serviceLibman;

    @GetMapping("/home/reader/registerReaderCard")
    public String getRegisterReaderCardFrm() {
        return "reader/RegisterFrm364.html";
    }

    @PostMapping("/getGreetingMessage")
    @ResponseBody
    public String getGreetingMessage(@RequestBody Member364 obj) {
        return serviceLibman.getNameMember(obj.getId());
    }

    @PostMapping("/register")
    @ResponseBody
    public void register (@RequestBody Member364 obj) {
        serviceLibman.readerCardRegister(obj);
    }

    @PostMapping("/checkLogin")
    @ResponseBody
    public ResponseEntity<LoginResultDTO> checkLogin(@RequestBody Account364 account364){
        return serviceLibman.checkLogin(account364);
    };
}
