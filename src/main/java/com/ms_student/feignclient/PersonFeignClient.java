package com.ms_student.feignclient;

import com.ms_student.model.Person;
import org.springframework.web.bind.annotation.*;
import reactivefeign.spring.config.ReactiveFeignClient;
import reactor.core.publisher.*;

//@ReactiveFeignClient(value = "ms-person", url = "http://localhost:8085/v2/person")
@ReactiveFeignClient(value = "ms-person", url = "https://certidigital-ms-person-be.azurewebsites.net/v2/person")
public interface PersonFeignClient {

    @GetMapping
    Flux<Person> findAllPerson();

    @GetMapping("/id/{person_id}")
    Mono<Person> findPersonById(@PathVariable("person_id") Long person_id);
}
