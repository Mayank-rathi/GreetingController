package com.springmvc.greetingcontroller.repository;

import com.springmvc.greetingcontroller.model.Greeting;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IGreetingRepository extends JpaRepository<Greeting, Long> {
    Greeting deleteById(long id);
}
