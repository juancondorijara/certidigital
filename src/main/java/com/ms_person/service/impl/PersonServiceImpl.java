package com.ms_person.service.impl;

import com.ms_person.model.Person;
import com.ms_person.repository.PersonRepository;
import com.ms_person.service.PersonService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import lombok.*;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@RequiredArgsConstructor
public class PersonServiceImpl implements PersonService {

    @Autowired
    private PersonRepository personRepository;

    @Override
    public Flux<Person> findAll() {
        log.info("Mostrando todas las personas");
        return personRepository.findAll();
    }

    @Override
    public Mono<Person> findById(Long id) {
        log.info("Persona encontrada con el ID = " + id);
        return personRepository.findById(id);
    }

    @Override
    public Flux<Person> findByStatus(boolean active) {
        log.info("Personas filtradas por estado = " + active);
        return personRepository.findByStatus(active);
    }

    @Override
    public Mono<Person> save(Person person) {
        log.info("Persona creada = " + person.toString());
        person.setLevel(1);
        person.setActive(true);
        return personRepository.save(person);
    }

    @Override
    public Mono<Person> update(Person person) {
        log.info("Persona actualizada = " + person.toString());
        person.setLevel(1);
        person.setActive(true);
        return personRepository.save(person);
    }

    @Override
    public Mono<ResponseEntity<Person>> delete(Long id) {
        log.info("Persona eliminada = " + id);
        return personRepository.findById(id).flatMap(newPerson -> {
            newPerson.setActive(false);
            return personRepository.save(newPerson);
        }).map(updatedDocument -> new ResponseEntity<>(updatedDocument, HttpStatus.OK)).defaultIfEmpty(new ResponseEntity<>(HttpStatus.OK));
    }

    @Override
    public Mono<ResponseEntity<Person>> restore(Long id) {
        log.info("Persona restaurada = " + id);
        return personRepository.findById(id).flatMap(newPerson -> {
            newPerson.setActive(true);
            return personRepository.save(newPerson);
        }).map(updatedDocument -> new ResponseEntity<>(updatedDocument, HttpStatus.OK)).defaultIfEmpty(new ResponseEntity<>(HttpStatus.OK));
    }
}
