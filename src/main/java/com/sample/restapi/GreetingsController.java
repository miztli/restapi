package com.sample.restapi;

import java.util.Map;
import javax.annotation.Resource;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/greetings")
public class GreetingsController
{
    @Resource
    private IGreetingsService iGreetingsService;

    @GetMapping
    public Map<String, String> greetings(@RequestParam final String name)
    {
        return iGreetingsService.greetings(name);
    }

    @GetMapping(value = "/blocking")
    public Map<String, String> blockingGreetings(@RequestParam final String name)
    {
        return iGreetingsService.blockingGreetings(name);
    }
}
