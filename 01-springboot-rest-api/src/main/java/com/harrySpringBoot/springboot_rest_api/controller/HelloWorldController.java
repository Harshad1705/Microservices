package com.harrySpringBoot.springboot_rest_api.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;


@RestController  // @Controller + @ResponseBody
/*
@Controller
@ResponseBody  // used to convert a response from java object into JSON
*/
public class HelloWorldController {

    @GetMapping("/hello-world")
    public String helloWorld() {
        return "Hello World";
    }
    
}
