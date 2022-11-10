package com.as201msinstitute.institute.service.impl;

import com.as201msinstitute.institute.model.institute;
import com.as201msinstitute.institute.repository.instituteRepository;
import com.as201msinstitute.institute.service.instituteService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Slf4j
@Service
@RequiredArgsConstructor
public class instituteServiceImpl implements instituteService {

    @Autowired
    private instituteRepository instituteRepository;

    @Override
    public Flux<institute> toShowInstitute() {
        log.info("Mostrando todas los institutos");
        return instituteRepository.findAll();
    }

    @Override
    public Mono<institute> findIdInstitute(Long id) {
        log.info("instituto encontrado con el ID = " + id);
        return instituteRepository.findById(id);
    }

    @Override
    public Flux<institute> findInstituteByStatus(boolean active) {
        log.info("instituto filtradas por estado = " + active);
        return instituteRepository.findByStatus(active);
    }

    @Override
    public Mono<institute> createInstitute(institute institute) {
        log.info("Colaborador creado = " + institute.toString());
        institute.setActive(true);
        return instituteRepository.save(institute);
    }

    @Override
    public Mono<institute> modifyInstitute(institute institute) {
        log.info("Persona actualizada = " + institute.toString());
        institute.setActive(true);
        return instituteRepository.save(institute);
    }

    @Override
    public Mono<institute> deleteInstitute(Long id) {
        log.info("Colaborador eliminado = " + id);
        institute data = new institute();
        data.setActive(false);
        return dataInstitute(data, id);
    }

    @Override
    public Mono<institute> restoreInstitute(Long id) {
        log.info("Colaborador restaurado = " + id);
        institute data = new institute();
        data.setActive(true);
        return dataInstitute(data, id);
    }
    public Mono<institute> dataInstitute(institute data, Long id) {
        return instituteRepository.findById(id).map((institute) -> {
            data.setId(institute.getId());
            data.setName(institute.getName());
            data.setRuc(institute.getRuc());
            data.setArea(institute.getArea());
            data.setActive(true);
            return data;
        }).flatMap(collaborator -> instituteRepository.save(data));
    }
}
