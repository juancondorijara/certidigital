package com.as201_ms_career.controller;

import com.as201_ms_career.feignClient.InstituteFeignClient;
import com.as201_ms_career.model.Career;
import com.as201_ms_career.model.Institute;
import com.as201_ms_career.service.CareerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.*;

@Slf4j
@RestController
@CrossOrigin(origins="http://localhost:4200")
@RequestMapping("/v1/career")
public class CareerController {

	@Autowired
	private CareerService careerService;

	@Autowired
	private InstituteFeignClient instituteFeignClient;

	@GetMapping
	public Flux<Career> findCareer() {
		return careerService.findCareer();
	}

	@GetMapping("/id/{id}")
	public Mono<Career> findCareerById(@PathVariable Long id) {
		return careerService.findCareerById(id);
	}
	
	@GetMapping("/status/{status}")
	public Flux<Career> findCareerByStatus(@PathVariable boolean status) {
		return careerService.findCareerByStatus(status); }

	@GetMapping("/institute/{institute_id}")
	public Flux<Object> findInstituteById(@PathVariable Integer institute_id){
		Flux<Career> careerf = careerService.findCareerByInstitute(institute_id);
		Mono<Institute> institutef = instituteFeignClient.getInstitute(institute_id);
		return Flux.from(Flux.concat(Flux.from(careerf),Flux.from(institutef)));
	}

	@GetMapping("/institute")
	public Flux<Institute> findInstitute(){
		return instituteFeignClient.getAllInstitute();
	}

	@PostMapping
	public Mono<Career> createCareer(@RequestBody Career career) {
		return careerService.createCareer(career);
	}

	@PutMapping
	public Mono<Career> updateCareer(@RequestBody Career career) { return careerService.updateCareer(career); }

	@GetMapping("/delete/{id}")
	public Mono<Career> deleteCareer(@PathVariable Long id) { return careerService.deleteCareer(id); }

	@GetMapping("/restore/{id}")
	public Mono<Career> restoreCareer(@PathVariable Long id) {
		return careerService.restoreCareer(id);
	}
}
