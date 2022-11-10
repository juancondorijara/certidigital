package com.as201msinstitute.institute.controller;
import com.as201msinstitute.institute.model.institute;
import com.as201msinstitute.institute.service.instituteService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Slf4j
@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/v1/institute")
public class instituteAplication {

    @Autowired
    private instituteService instituteService;

    @GetMapping
    public Flux<institute> toShowInstitute() {
        return instituteService.toShowInstitute();
    }

    @GetMapping("/status/{active}")
    public Flux<institute> findInstituteByStatus(@PathVariable boolean active) { return instituteService.findInstituteByStatus(active); }

    @GetMapping("/{id}")
    public Mono<institute> findIdInstitute(@PathVariable Long id) {
        return instituteService.findIdInstitute(id);
    }

    @PostMapping("/create")
    public Mono<institute> createInstitute(@RequestBody institute data) { return instituteService.createInstitute(data); }

    @PutMapping("/update")
    public Mono<institute> modifyInstitute(@RequestBody institute data) { return instituteService.modifyInstitute(data); }

    @GetMapping("/delete/{id}")
    public Mono<institute> deleteInstitute(@PathVariable Long id) { return instituteService.deleteInstitute(id); }

    @GetMapping("/restore/{id}")
    public Mono<institute> restoreInstitute(@PathVariable Long id) {
        return instituteService.restoreInstitute(id);
    }

}
