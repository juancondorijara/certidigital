package com.as201_ms_career.service;

import com.as201_ms_career.model.Career;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public interface CareerService {

    Flux<Career> findCareer();

    Mono<Career> findCareerById(Long id);

    Flux<Career> findCareerByStatus(boolean status);

    Flux<Career> findCareerByInstitute(Integer institute_id);

    Mono<Career> createCareer(Career career);

    Mono<Career> updateCareer(Career career);

    Mono<Career> deleteCareer(Long id);

    Mono<Career> restoreCareer(Long id);
}
