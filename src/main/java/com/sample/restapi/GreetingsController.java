package com.sample.restapi;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/greetings")
public class GreetingsController
{
    @GetMapping
    public String greetings(@RequestParam final String name) {
        return "Hello " + name + "!";
    }
}
