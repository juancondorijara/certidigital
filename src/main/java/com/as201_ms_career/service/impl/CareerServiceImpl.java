package com.as201_ms_career.service.impl;

import com.as201_ms_career.service.CareerService;
import com.as201_ms_career.model.Career;
import com.as201_ms_career.repository.CareerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.*;
import lombok.*;
import lombok.extern.slf4j.Slf4j;


@Slf4j
@Service
@RequiredArgsConstructor
public class CareerServiceImpl implements CareerService {

    @Autowired
    private CareerRepository careerRepository;

    public Flux<Career> findCareer() {
        log.info("Mostrando todas las carreras");
        return careerRepository.findAll();
    }

    public Mono<Career> findCareerById(Long id) {
        log.info("Carrera encontrada con el ID = " + id);
        return careerRepository.findById(id);
    }

    public Flux<Career> findCareerByStatus(boolean status) {
        log.info("Carreras encontras con el estado = " + status);
        return careerRepository.findByStatus(status);
    }

    @Override
    public Flux<Career> findCareerByInstitute(Integer institute_id) {
        log.info("Carreras encontradas con el indtituto = " + institute_id);
        return careerRepository.findByInstitute(institute_id);
    }

    public Mono<Career> createCareer(Career career) {
        log.info("Carrera creada = " + career.toString());
        career.setActive(true);
        return careerRepository.save(career);
    }

    public Mono<Career> updateCareer(Career career) {
        log.info("Carrera actualizada = " + career.toString());
        return careerRepository.findById(career.getId()).map((car) -> {
            car.setId(career.getId());
            car.setName(career.getName());
            car.setBoss(career.getBoss());
            car.setArea(career.getArea());
            car.setInstitute_id(career.getInstitute_id());
            car.setPension(career.getPension());
            car.setQuantity_course(career.getQuantity_course());
            car.setQuantity_semester(career.getQuantity_semester());
//            car.setActive(career.parseString(getActive()));
            return car;
        }).flatMap(car -> careerRepository.save(car));
    }

    public Mono<Career> deleteCareer(Long id) {
        log.info("Carrera eliminada = " + id);
        Career data = new Career();
        data.setId(id);
        data.setActive(false);
        return dataCareer(data, id);
    }

    public Mono<Career> restoreCareer(Long id) {
        log.info("Carrera restaurada = " + id);
        Career data = new Career();
        data.setActive(true);
        return dataCareer(data, id);
    }

    public Mono<Career> dataCareer(Career data, Long id) {
        return careerRepository.findById(id).map((career) -> {
            data.setId(career.getId());
            data.setName(career.getName());
            data.setBoss(career.getBoss());
            data.setArea(career.getArea());
            data.setInstitute_id(career.getInstitute_id());
            data.setPension(career.getPension());
            data.setQuantity_course(career.getQuantity_course());
            data.setQuantity_semester(career.getQuantity_semester());
//            data.getActive();
            return data;
        }).flatMap(career -> careerRepository.save(data));
    }

}
