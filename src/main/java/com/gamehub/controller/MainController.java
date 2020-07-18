package com.gamehub.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MainController {

    @GetMapping("")
    public String indexPage(){
        return "index.html";
    }

    @GetMapping("/calculator")
    public String calculatorPage(@RequestParam("x") double x, @RequestParam("y") double y,
                            @RequestParam("action") String action, Model model){
        double result = 0;

        switch (action) {
            case "multiply":
                result = x * y;
                break;
            case "divide":
                try {
                    result = x / y;
                } catch (ArithmeticException ignored) {

                }
                break;
            case "addition":
                result = x+y;
                break;
            case "subtraction":
                result = x-y;
                break;
            default:
                result=0;
                break;
        }
        model.addAttribute("result",result);
        return "calculator.html";
    }
}
