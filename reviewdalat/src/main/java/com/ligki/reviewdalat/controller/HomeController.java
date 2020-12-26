package com.ligki.reviewdalat.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller("/")
public class HomeController {

    @GetMapping("/")
    public ModelAndView toHome() {
        ModelAndView mav = new ModelAndView("/home");
        return mav;
    }
}
