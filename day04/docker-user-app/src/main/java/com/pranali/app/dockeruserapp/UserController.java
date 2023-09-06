package com.pranali.app.dockeruserapp;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @GetMapping ("/name")
    public String getName(){
        return "Pranali Patil";
    }

    @GetMapping ("/age")
    public int getAge(){
        return 25;
    }

    @GetMapping ("/address")
    public String getAddress(){
        return "Nagpur Maharashtra";
    }

}
