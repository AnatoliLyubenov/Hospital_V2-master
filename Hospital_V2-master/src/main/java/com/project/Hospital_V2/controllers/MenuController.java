package com.project.Hospital_V2.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MenuController {
    @GetMapping("/menu")
    public String menu() {
        return "/menu";
    }

    @GetMapping("login")
    public String loginPage() {
        return "/login";
    }

}