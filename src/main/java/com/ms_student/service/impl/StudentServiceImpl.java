package com.ms_student.service.impl;

import com.ms_student.model.*;
import com.ms_student.repository.StudentRepository;
import com.ms_student.service.StudentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import lombok.extern.slf4j.Slf4j;
import lombok.*;

@Slf4j
@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Override
    public Flux<Student> findAll() {
        log.info("Mostrando todas las estudiantes");
        return studentRepository.findAll();
    }

    @Override
    public Mono<Student> findById(Long id) {
        log.info("Estudiante encontrado con el ID = " + id);
        return studentRepository.findById(id);
    }

    @Override
    public Flux<Student> findByStatus(String status) {
        log.info("Estudiantes filtrados por estado = " + status);
        return studentRepository.findByStatus(status);
    }

    @Override
    public Mono<Student> save(Student student) {
        log.info("Estudiante creado = " + student.toString());
        student.setStatus("E");
        return studentRepository.save(student);
    }

    @Override
    public Mono<Student> update(Student student) {
        log.info("Estudiante actualizado = " + student.toString());
        student.setStatus("E");
        return studentRepository.save(student);
    }

    @Override
    public Mono<ResponseEntity<Student>> deleteGraduated(Long id) {
        log.info("Estudiante cambiado a egresado = " + id);
        return studentRepository.findById(id).flatMap(newStudent -> {
            newStudent.setStatus("G");
            return studentRepository.save(newStudent);
        }).map(updatedDocument -> new ResponseEntity<>(updatedDocument, HttpStatus.OK)).defaultIfEmpty(new ResponseEntity<>(HttpStatus.OK));
    }

    @Override
    public Mono<ResponseEntity<Student>> deleteRetired(Long id) {
        log.info("Estudiante cambiado a retirado = " + id);
        return studentRepository.findById(id).flatMap(newStudent -> {
            newStudent.setStatus("R");
            return studentRepository.save(newStudent);
        }).map(updatedDocument -> new ResponseEntity<>(updatedDocument, HttpStatus.OK)).defaultIfEmpty(new ResponseEntity<>(HttpStatus.OK));
    }

    @Override
    public Mono<ResponseEntity<Student>> restore(Long id) {
        log.info("Estudiante restaurado = " + id);
        return studentRepository.findById(id).flatMap(newStudent -> {
            newStudent.setStatus("E");
            return studentRepository.save(newStudent);
        }).map(updatedDocument -> new ResponseEntity<>(updatedDocument, HttpStatus.OK)).defaultIfEmpty(new ResponseEntity<>(HttpStatus.OK));
    }

}
