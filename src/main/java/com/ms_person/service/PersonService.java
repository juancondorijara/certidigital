package com.ms_person.service;

import com.ms_person.model.Person;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public interface PersonService {

    Flux<Person> findAll();

    Mono<Person> findById(Long id);

    Flux<Person> findByStatus(boolean active);

    Mono<Person> save(Person person);

    Mono<Person> update(Person person);

    Mono<ResponseEntity<Person>> delete(Long id);

    Mono<ResponseEntity<Person>> restore(Long id);
}
