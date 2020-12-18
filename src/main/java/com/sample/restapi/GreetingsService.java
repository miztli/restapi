package com.sample.restapi;

import java.util.Map;

import org.springframework.stereotype.Service;

@Service
public class GreetingsService implements IGreetingsService
{
    @Override
    public Map<String,String> greetings(final String name)
    {
        return Map.of("greetings", "Hello " + name + "!");
    }

    @Override
    public Map<String,String> blockingGreetings(final String name)
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
            Thread.sleep(10000);
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
