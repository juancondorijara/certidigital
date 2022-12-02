package com.as201_ms_career;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;
import com.as201_ms_career.model.Career;
import com.as201_ms_career.repository.CareerRepository;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import reactor.core.publisher.*;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.TestInstance.Lifecycle;

@TestInstance(Lifecycle.PER_CLASS)
@DisplayName("CAREER")
class As201_Ms_CareerApplicationTests {

    @Mock
    private CareerRepository careerRepository;

    Career career = new Career();

    Flux<Career> list;

    @BeforeAll
    void init() {
        System.out.println("INICIO DE PRUEBAS");
    }

    @BeforeEach
    void setUp(){
        MockitoAnnotations.initMocks(this);
        career.setId(Long.valueOf(1));
        career.setName("Análisis de Sistemas");
        career.setBoss("Luis Aquilino Manzo Candela");
        career.setArea("Carrera Profesional de Anális de Sistemas");
        career.setInstitute_id(1);
        career.setPension(350.0);
        career.setQuantity_course(9);
        career.setQuantity_semester(6);
        career.setActive(true);
        list = Flux.just(career);
    }

    @Nested
    @DisplayName("CRUD")
    public class crud {

        @Test
        @DisplayName("LISTAR")
        void findAll(){
            when(careerRepository.findAll()).thenReturn(list);
            System.out.println("LISTA = " + career);
            assertNotEquals(null, list);
        }

        @Test
        @DisplayName("GUARDAR")
        void save(){
            careerRepository.save(career);
            System.out.println("GUARDADO = " + career);
            assertNotEquals(null, list);
        }

        @Test
        @DisplayName("MODIFICAR")
        void update(){
            System.out.println("LISTA ORIGINAL = " + career);
            career.setName("Producción Agraria");
            careerRepository.save(career);
            System.out.println("LISTA MODIFICADA = " + career);
            assertNotNull(career.getName());
        }

        @Test
        @DisplayName("ELIMINAR")
        void delete(){
            careerRepository.deleteById(career.getId());
            Mono<Career> career2 = careerRepository.findById(career.getId());
            System.out.println("ELIMINADO CON EL ID = " + career.getId());
            System.out.println("ELIMINADO = " + career);
            assertEquals(null, career2);
        }
    }

    @AfterAll
    void end() {
        System.out.println("FIN DE PRUEBAS");
    }
}
