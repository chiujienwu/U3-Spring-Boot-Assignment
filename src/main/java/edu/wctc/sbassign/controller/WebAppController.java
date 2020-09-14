package edu.wctc.sbassign.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Date;

@Controller
public class WebAppController {
    private String appMode;

    @Autowired
    public void WebAppContoller(Environment environment){
        appMode = environment.getProperty("app-mode");
    }

    @RequestMapping("/")
    public String index(Model model){
        model.addAttribute("datetime", new Date());
        model.addAttribute("projectname", "Unit3");
        model.addAttribute("mode", appMode);
        model.addAttribute("blogname", "Jerry's Big Bad Blog of the Dark Dark Web");
        model.addAttribute("source","https://www.theverge.com/2013/12/19/5183356/how-to-steal-bitcoin-in-three-easy-steps");

        return "index";
    }

    @RequestMapping("/bitcoin1")
    public String lesson1tutorial(Model model){
        model.addAttribute("blogname","History of Grand Theft Bitcoin!");
        return "pages/introtutorial";
    }

    @RequestMapping("/bitcoin2")
    public String lesson2tutorial(Model model){
        model.addAttribute("blogname","Lesson 1 - Copying the Keys");
        return "pages/lesson1tutorial";
    }

    @RequestMapping("/bitcoin3")
    public String lesson3tutorial(Model model){
        model.addAttribute("blogname", "Lesson 2 - Getting Away with It");
        return "pages/lesson2tutorial";
    }

    @RequestMapping("/bitcoin4")
    public String lesson4tutorial(Model model){
        model.addAttribute("blogname","Conclusion - Living Large!");
        return "pages/finaltutorial";
    }
}
