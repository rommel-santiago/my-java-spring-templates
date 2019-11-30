package com.sebnsab.demo.controller.json;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

public class JsonController {
    @Controller
    public static class ThymeLeaf {

        @RequestMapping("/listing")
        public String getListing(Model model) {
            return "Listing";
        }
    }
}
