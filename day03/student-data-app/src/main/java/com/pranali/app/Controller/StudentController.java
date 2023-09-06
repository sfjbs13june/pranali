package com.pranali.app.Controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentController {

    @GetMapping("/getstudent")

    public String getStudentDetail(){

        return "student1";
    }

   @PutMapping("/updatestudent")

    public String updatestudentdetail(){
        return "updated student1";

    }

    @DeleteMapping("/deletestudent")

    public String deletestudentdetail(){
        return "deleted student1";
    }



}


