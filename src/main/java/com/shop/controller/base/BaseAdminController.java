package com.shop.controller.base;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping("/admin")
public class BaseAdminController {
    @GetMapping
    public ModelAndView home(){
        return new ModelAndView("/admin/Dashboard");
    }
}
