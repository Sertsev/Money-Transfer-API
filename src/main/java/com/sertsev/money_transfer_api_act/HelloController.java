package com.sertsev.money_transfer_api_act;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping("/")
    public String sayHello() {
        return "Hello World";
    }

    @GetMapping("/{name}")
    public String sayHelloName(@PathVariable String name) {
        return "Hello there " + name;
    }
}
