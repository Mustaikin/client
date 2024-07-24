package ru.mrsu.test.project.clients.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    @GetMapping("/helloWorld")
    public String hello(){
        return "Hello, World!";
    }
    @GetMapping("/helloClient")
    public String getHelloMessage(@RequestParam String name){
        return "Hello, " + name + "!";
    }
}
