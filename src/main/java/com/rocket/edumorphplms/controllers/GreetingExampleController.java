package com.rocket.edumorphplms.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

// Reference: https://spring.io/guides/gs/serving-web-content/ for detail explanation
@Controller
public class GreetingExampleController {
    @GetMapping("/greeting_example")
    public String greeting_example(@RequestParam(name="name", required=false, defaultValue="World") String name, Model model) {
        model.addAttribute("name", name);
        return "greeting_example";
    }
    // visit http://localhost:8080/greeting_example
    // visit http://localhost:8080/greeting_example?name=John
}
