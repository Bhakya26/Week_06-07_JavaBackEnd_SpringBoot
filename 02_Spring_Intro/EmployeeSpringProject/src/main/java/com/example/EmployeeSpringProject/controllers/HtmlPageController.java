package com.example.EmployeeSpringProject.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/hellomsgs")
public class HtmlPageController {
    @GetMapping("/")
    public String returnHtml(){
        return "Hello from bridgelabz";
    }

    @GetMapping("/query")
    public String returnhellobyquery(@RequestParam String name,@RequestParam String last){
        return "Hello "+name+last;
    }
    @GetMapping("/{name}")
    public String getnamebypath(@PathVariable String name){
        return "Hey "+ name;
    }
}
