package com.springmvc.greetingcontroller.controller;

import com.springmvc.greetingcontroller.model.Greeting;
import com.springmvc.greetingcontroller.model.User;
import com.springmvc.greetingcontroller.service.IGreetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class GreetingController {

    @Autowired
    private IGreetingService greetingService;

    @GetMapping("/greeting")
    public Greeting greeting(@RequestParam(value = "fname", defaultValue = "World") String firstName,
                             @RequestParam("lName") String lastName) {
        User user = new User();
        user.setFirstName(firstName);
        user.setLastName(lastName);
        return greetingService.addGreeting(user);
    }

    @GetMapping("/findId")
    public Greeting findGreetingById(@RequestParam(value = "id", defaultValue = "1") long id) {
        return greetingService.getGreetingById(id);
    }

}