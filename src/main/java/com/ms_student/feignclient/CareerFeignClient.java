package com.ms_student.feignclient;

import com.ms_student.model.Career;
import org.springframework.web.bind.annotation.*;
import reactivefeign.spring.config.ReactiveFeignClient;
import reactor.core.publisher.*;

@ReactiveFeignClient(value = "as201-ms-career", url = "http://localhost:8087/v1/career")
public interface CareerFeignClient {

    @GetMapping
    Flux<Career> findAllCareer();

    @GetMapping("/id/{career_id}")
    Mono<Career> findCareerById(@PathVariable("career_id") Long career_id);
}
