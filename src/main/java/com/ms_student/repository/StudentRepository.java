package com.ms_student.repository;

import com.ms_student.model.Student;
import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

@Repository
public interface StudentRepository extends ReactiveCrudRepository<Student, Long> {

    @Query("SELECT * FROM student ORDER BY id DESC")
    Flux<Student> findAll();

    @Query("SELECT * FROM student WHERE status = :status ORDER BY id DESC")
    Flux<Student> findByStatus(@Param("status") String status);

    @Query("SELECT * FROM student WHERE person_id = :person_id ORDER BY id DESC")
    Flux<Student> findPersonById(@Param("person_id") Long person_id);

    @Query("SELECT * FROM student WHERE career_id = :career_id ORDER BY id DESC")
    Flux<Student> findCareerById(@Param("career_id") Long career_id);
}
