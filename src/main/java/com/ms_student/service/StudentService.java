package com.ms_student.service;

import com.ms_student.model.Student;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public interface StudentService {

    Flux<Student> findAll();

    Mono<Student> findById(Long id);

    Flux<Student> findByStatus(String status);

    Flux<Student> findPersonById(Long person_id);

    Flux<Student> findCareerById(Long career_id);

    Mono<Student> save(Student student);

    Mono<Student> update(Student student);

    Mono<ResponseEntity<Student>> deleteGraduated(Long id);

    Mono<ResponseEntity<Student>> deleteRetired(Long id);

    Mono<ResponseEntity<Student>> restore(Long id);
}
