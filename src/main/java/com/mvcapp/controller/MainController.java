package com.mvcapp.controller;

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
        char actionChar;

        switch (action) {
            case "multiply":
                result = x * y;
                actionChar = '*';
                break;
            case "divide":
                actionChar = '/';
                try {
                    result = x / y;
                } catch (ArithmeticException ignored) {

                }
                break;
            case "addition":
                actionChar = '+';
                result = x+y;
                break;
            case "subtraction":
                actionChar = '-';
                result = x-y;
                break;
            default:
                actionChar = '~';
                result=0;
                break;
        }
        model.addAttribute("message",x + " " + actionChar + " " + y + "=" + " " + result);
        return "calculator.html";
    }
}
