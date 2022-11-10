package com.as201msinstitute.institute.service;

import com.as201msinstitute.institute.model.institute;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface instituteService {

    Flux<institute> toShowInstitute();

    Mono<institute> findIdInstitute(Long id);

    Flux<institute> findInstituteByStatus(boolean active);

    Mono<institute> createInstitute(institute institute);

    Mono<institute> modifyInstitute(institute institute);

    Mono<institute> deleteInstitute(Long id);

    Mono<institute> restoreInstitute(Long id);

}
