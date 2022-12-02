package com.as201_ms_career.repository;

import com.as201_ms_career.model.Career;
import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

@Repository
public interface CareerRepository extends ReactiveCrudRepository<Career, Long> {

	@Query("SELECT * FROM career WHERE active = :active ORDER BY id DESC")
	Flux<Career> findByStatus(@Param("active") boolean status);

	@Query("SELECT * FROM career WHERE institute_id = :institute_id ORDER BY id DESC")
	Flux<Career> findByInstitute(@Param("institute_id") Integer institute_id);

}