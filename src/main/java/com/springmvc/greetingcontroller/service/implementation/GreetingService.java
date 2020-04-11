package com.springmvc.greetingcontroller.service.implementation;

import com.springmvc.greetingcontroller.model.Greeting;
import com.springmvc.greetingcontroller.model.User;
import com.springmvc.greetingcontroller.service.IGreetingService;
import com.springmvc.greetingcontroller.repository.IGreetingRepository;
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
        String message =user.toString().isEmpty()?
                "Hello World ":
                user.getFirstName()+" "+user.getLastName();
        Greeting greeting=new Greeting();
        greeting.setId(counter.incrementAndGet());
        greeting.setMessage(message);
        return greetingRepository.save(greeting);
    }

    @Override
    public Greeting getGreetingById(long id) {
        return greetingRepository.findById(id).get();
    }

}
