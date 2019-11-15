package com.sebnsab.demo.controller.thymeleaf;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ThymeLeaf {

    @RequestMapping("/listing")
    public String getListing(Model model) {
        return "Listing";
    }
}
