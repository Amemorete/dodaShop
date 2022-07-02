package com.MyDodaDEv.ma.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

    @GetMapping("/admin")
    public  String showAdminDasboard(){
        return"admin/index";
    }
    @GetMapping("/table")
    public  String showAdminTable(){
        return"admin/table-basic";
    }

    @GetMapping("/calandrier")
    public String showAbsence(Model model){


        return  "admin/uc-calendar";
    }
}
