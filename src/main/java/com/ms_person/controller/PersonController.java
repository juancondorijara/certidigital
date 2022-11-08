package com.ms_person.controller;

import com.ms_person.model.Person;
import com.ms_person.service.PersonService;
import org.springframework.http.ResponseEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/v2/person")
public class PersonController {

    @Autowired
    private PersonService personService;

    @GetMapping
    public Flux<Person> findAll(){ return personService.findAll(); }

    @GetMapping("/id/{id}")
    public Mono<Person> findById(@PathVariable Long id){ return personService.findById(id); }

    @GetMapping("/active/{active}")
    public Flux<Person> findByStatus(@PathVariable boolean active) { return personService.findByStatus(active); }

    @PostMapping
    public Mono<Person> save(@RequestBody Person person){
        return personService.save(person);
    }

    @PutMapping
    public Mono<Person> update(@RequestBody Person person){
        return personService.update(person);
    }

    @PostMapping("/delete/{id}")
    public Mono<ResponseEntity<Person>> delete(@PathVariable Long id) { return personService.delete(id); }

    @PostMapping("/restore/{id}")
    public Mono<ResponseEntity<Person>> restore(@PathVariable Long id){ return personService.restore(id); }
}
