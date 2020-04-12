package com.springmvc.greetingcontroller.service.implementation;

import com.springmvc.greetingcontroller.model.Greeting;
import com.springmvc.greetingcontroller.model.User;
import com.springmvc.greetingcontroller.repository.IGreetingRepository;
import com.springmvc.greetingcontroller.service.IGreetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.concurrent.atomic.AtomicLong;

@Service
public class GreetingService implements IGreetingService {

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @Autowired
    private IGreetingRepository greetingRepository;

    @Override
    public Greeting addGreeting(User user) {
        String message = user.toString().isEmpty() ?
                "Hello World " :
                user.getFirstName() + " " + user.getLastName();
        Greeting greeting = new Greeting();
        greeting.setId(counter.incrementAndGet());
        greeting.setMessage(message);
        return greetingRepository.save(greeting);
    }

    @Override
    public Greeting getGreetingById(long id) {
        return greetingRepository.findById(id).get();
    }

    @Override
    public Greeting deleteGreetingById(long id) {
        return greetingRepository.deleteById(id);
    }


    @Override
    public Greeting saveOrUpdate(Greeting greeting) {
        return greetingRepository.save(greeting);
    }

    @Override
    public Greeting deleteGreeting(long id) {
        return greetingRepository.deleteById(id);
    }

    @Override
    public Greeting update(Greeting greeting, long id) {
        return greetingRepository.save(greeting);
    }

}
