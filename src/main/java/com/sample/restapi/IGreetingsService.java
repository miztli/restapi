package com.sample.restapi;

import java.util.Map;

public interface IGreetingsService
{
    Map<String, String> greetings(String name);

    Map<String, String> blockingGreetings(String name);
}
