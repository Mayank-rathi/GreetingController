package com.springmvc.greetingcontroller.service;

import com.springmvc.greetingcontroller.model.Greeting;
import com.springmvc.greetingcontroller.model.User;

public interface IGreetingService {
    Greeting addGreeting(User user);

    Greeting getGreetingById(long id);

    Greeting deleteGreetingById(long id);

    Greeting deleteGreeting(long id);

    Greeting update(Greeting greeting, long id);

    Greeting saveOrUpdate(Greeting greeting);
}
