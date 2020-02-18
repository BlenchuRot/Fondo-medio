package com.example.demo;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingController {

    private final GreetingRepository repository;

    GreetingController(GreetingRepository repository) {
        this.repository = repository;
    }

    // Aggregate root

    @GetMapping("/greeting")
    Iterable<Greeting> all() {
        return repository.findAll();
    }

    @PostMapping("/greeting")
    Greeting newGreeting(@RequestBody Greeting newGreeting) {
        return repository.save(newGreeting);
    }

    // Single item

    @GetMapping("/greeting/{id}")
    Greeting one(@PathVariable Long id) {

        return repository.findById(id).orElseThrow();
    }

    @PutMapping("/greeting/{id}")
    Greeting replaceGreeting(@RequestBody Greeting newGreeting, @PathVariable Long id) {

        Greeting actual = repository.findById(id).get();

        actual.getContent();

        return repository.save(actual);
    }

    @DeleteMapping("/greeting/{id}")
    void deleteGreeting(@PathVariable Long id) {
        repository.deleteById(id);
    }
}