package com.springmvc.greetingcontroller.repository;

import com.springmvc.greetingcontroller.model.Greeting;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IGreetingRepository extends JpaRepository<Greeting, Long> {

    List<Object> findByName(String name);
}
