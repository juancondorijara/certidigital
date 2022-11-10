package com.as201msinstitute.institute.repository;

import com.as201msinstitute.institute.model.institute;
import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Flux;

public interface instituteRepository extends ReactiveCrudRepository<institute,Long> {

    @Query("SELECT * FROM institute WHERE active = :active ORDER BY id DESC")
    Flux<institute> findByStatus(@Param("active") boolean active);

}
