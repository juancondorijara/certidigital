package com.ms_student.service.impl;

import com.ms_student.feignclient.CareerFeignClient;
import com.ms_student.feignclient.PersonFeignClient;
import com.ms_student.model.Career;
import com.ms_student.model.Person;
import com.ms_student.model.Student;
import com.ms_student.repository.StudentRepository;
import com.ms_student.service.StudentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.scheduler.Schedulers;
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

    @Autowired
    private CareerFeignClient careerFeignClient;

    @Autowired
    private PersonFeignClient personFeignClient;

    @Override
    public Flux<Student> findAll() {
        log.info("Mostrando todas las estudiantes");
        Flux<Student> list = studentRepository.findAll().publishOn(Schedulers.boundedElastic());
        return findStudentTransacction(list);
    }

    @Override
    public Mono<Student> findById(Long id) {
        log.info("Estudiante encontrado con el ID = " + id);
        return studentRepository.findById(id);
    }

    @Override
    public Flux<Student> findByStatus(String status) {
        log.info("Estudiantes filtrados por estado = " + status);
        Flux<Student> list = studentRepository.findByStatus(status).publishOn(Schedulers.boundedElastic());
        return findStudentTransacction(list);
    }

    @Override
    public Flux<Student> findPersonById(Long person_id) {
        log.info("Personas encontrados con ID de la persona = " + person_id);
        return studentRepository.findPersonById(person_id);
    }

    @Override
    public Flux<Student> findCareerById(Long career_id) {
        log.info("Carreras encontrados con ID de la carrera = " + career_id);
        return studentRepository.findCareerById(career_id);
    }

    @Override
    public Mono<Student> save(Student student) {
        log.info("Estudiante creado = " + student.toString());
        student.setStatus("Estudiante");
        return studentRepository.save(student);
    }

    @Override
    public Mono<Student> update(Student student) {
        log.info("Estudiante actualizado = " + student.toString());
        student.setStatus("Estudiante");
        return studentRepository.save(student);
    }

    @Override
    public Mono<ResponseEntity<Student>> deleteGraduated(Long id) {
        log.info("Estudiante cambiado a egresado = " + id);
        return studentRepository.findById(id).flatMap(newStudent -> {
            newStudent.setStatus("Egresado");
            return studentRepository.save(newStudent);
        }).map(updatedDocument -> new ResponseEntity<>(updatedDocument, HttpStatus.OK)).defaultIfEmpty(new ResponseEntity<>(HttpStatus.OK));
    }

    @Override
    public Mono<ResponseEntity<Student>> deleteRetired(Long id) {
        log.info("Estudiante cambiado a retirado = " + id);
        return studentRepository.findById(id).flatMap(newStudent -> {
            newStudent.setStatus("Retirado");
            return studentRepository.save(newStudent);
        }).map(updatedDocument -> new ResponseEntity<>(updatedDocument, HttpStatus.OK)).defaultIfEmpty(new ResponseEntity<>(HttpStatus.OK));
    }

    @Override
    public Mono<ResponseEntity<Student>> restore(Long id) {
        log.info("Estudiante restaurado = " + id);
        return studentRepository.findById(id).flatMap(newStudent -> {
            newStudent.setStatus("Estudiante");
            return studentRepository.save(newStudent);
        }).map(updatedDocument -> new ResponseEntity<>(updatedDocument, HttpStatus.OK)).defaultIfEmpty(new ResponseEntity<>(HttpStatus.OK));
    }

    public Flux<Student> findStudentTransacction(Flux<Student> list) {
        return list.concatMap(Flux::just).publishOn(Schedulers.boundedElastic()).map(dataStudent -> {
            Mono<Career> career = careerFeignClient.findCareerById(dataStudent.getCareer_id());
            career.subscribe(getCareer -> dataStudent.setCareer_name(getCareer.getName()));

            Mono<Person> person = personFeignClient.findPersonById(dataStudent.getPerson_id());
            person.subscribe(getPerson -> dataStudent.setPerson_name(getPerson.getName() + " " + getPerson.getLastname()));
            try {
                Thread.sleep(1500);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
            return dataStudent;
        });
    }

}
