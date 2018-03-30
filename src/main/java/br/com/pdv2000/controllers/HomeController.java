/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.pdv2000.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Diego
 */
@Controller
public class HomeController {

    @RequestMapping
    public String home(ModelAndView map) {
        return "newhtml.html";
        
    }
    
//    @GetMapping("/")
//    public String redirectWithUsingRedirectView() {
//        return "../../index.html";
//    }

}
