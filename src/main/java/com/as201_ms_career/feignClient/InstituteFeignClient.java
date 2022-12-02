package com.as201_ms_career.feignClient;

import com.as201_ms_career.model.Institute;
import org.springframework.web.bind.annotation.*;
import reactivefeign.spring.config.ReactiveFeignClient;
import reactor.core.publisher.*;

//@ReactiveFeignClient(value = "as201-ms-institute", url = "http://localhost:8086/v1/institute")
@ReactiveFeignClient(value = "institute", url = "https://certidigital-ms-institute-be.azurewebsites.net/v1/institute")
public interface InstituteFeignClient {

    @GetMapping
    Flux<Institute> getAllInstitute();

    @GetMapping("/{institute_id}")
    Mono<Institute> getInstitute(@PathVariable("institute_id") Integer institute_id);

}
