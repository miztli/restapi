package com.sample.restapi;

import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/greetings")
public class GreetingsController
{
    @GetMapping
    public Map<String, String> greetings(@RequestParam final String name)
    {
        return Map.of("greetings", "Hello " + name + "!");
    }

    @GetMapping(value = "/blocking")
    public Map<String, String> blockingGreetings(@RequestParam final String name)
    {
        block();
        return Map.of("greetings", "Hello " + name + "!");
    }

    // simulate delay
    private void block()
    {
        try
        {
            System.out.println("Blocking thread " + Thread.currentThread().getName());
            Thread.sleep(10000); // 10 seconds
        }
        catch (final InterruptedException e)
        {
            e.printStackTrace();
        }
        finally
        {
            System.out.println("Releasing thread " + Thread.currentThread().getName());
        }
    }
}
