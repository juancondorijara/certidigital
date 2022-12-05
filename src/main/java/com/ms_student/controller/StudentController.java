package com.ms_student.controller;

import com.ms_student.model.Career;
import com.ms_student.model.Person;
import com.ms_student.model.Student;
import com.ms_student.service.StudentService;
import com.ms_student.feignclient.PersonFeignClient;
import com.ms_student.feignclient.CareerFeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/v1/student")
public class StudentController {

    @Autowired
    private StudentService studentService;

    /*@Autowired
    private PersonFeignClient personFeignClient;

    @Autowired
    private CareerFeignClient careerFeignClient;

    @GetMapping("/person")
    public Flux<Person> findAllPerson(){
        return personFeignClient.findAllPerson();
    }

    @GetMapping("/person/{person_id}")
    public Flux<Object> findPersonById(@PathVariable Long person_id){
        Flux<Student> studentFlux = studentService.findPersonById(person_id);
        Mono<Person> personMono = personFeignClient.findPersonById(person_id);
        return Flux.from(Flux.concat(Flux.from(studentFlux),Flux.from(personMono)));
    }

    @GetMapping("/career")
    public Flux<Career> findAllCareer(){
        return careerFeignClient.findAllCareer();
    }

    @GetMapping("/career/{career_id}")
    public Flux<Object> findCareerById(@PathVariable Long career_id){
        Flux<Student> studentFlux = studentService.findCareerById(career_id);
        Mono<Career> careerMono = careerFeignClient.findCareerById(career_id);
        return Flux.from(Flux.concat(Flux.from(studentFlux),Flux.from(careerMono)));
    }*/

    @GetMapping
    public Flux<Student> findAll(){ return studentService.findAll(); }

    @GetMapping("/id/{id}")
    public Mono<Student> findById(@PathVariable Long id){ return studentService.findById(id); }

    @GetMapping("/status/{status}")
    public Flux<Student> findByStatus(@PathVariable String status) { return studentService.findByStatus(status); }

    @PostMapping
    public Mono<Student> save(@RequestBody Student student){
        return studentService.save(student);
    }

    @PutMapping
    public Mono<Student> update(@RequestBody Student student){
        return studentService.update(student);
    }

    @PostMapping("/graduated/{id}")
    public Mono<ResponseEntity<Student>> deleteGraduated(@PathVariable Long id) { return studentService.deleteGraduated(id); }

    @PostMapping("/retired/{id}")
    public Mono<ResponseEntity<Student>> deleteRetired(@PathVariable Long id) { return studentService.deleteRetired(id); }

    @PostMapping("/restore/{id}")
    public Mono<ResponseEntity<Student>> restore(@PathVariable Long id){ return studentService.restore(id); }

}
