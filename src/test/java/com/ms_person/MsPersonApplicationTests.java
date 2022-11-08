package com.ms_person;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;
import com.ms_person.model.Person;
import com.ms_person.repository.PersonRepository;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import reactor.core.publisher.*;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.TestInstance.Lifecycle;

@TestInstance(Lifecycle.PER_CLASS)
@DisplayName("PERSON")
class MsPersonApplicationTests {

	@Mock
	private PersonRepository personRepository;

	Person person = new Person();

	Flux<Person> list;

	@BeforeAll
	void init() {
		System.out.println("INICIO DE PRUEBAS");
	}

	@BeforeEach
	void setUp(){
		MockitoAnnotations.initMocks(this);
		person.setId(Long.valueOf(1));
		person.setId_type("DNI");
		person.setId_number("70335061");
		person.setName("Juan Gabriel");
		person.setLastname("Condori Jara");
		person.setCellphone("940460321");
		person.setEmail("juangabrielcondorijara@gmail.com");
		person.setUsername("juan");
		person.setPassword("12345@ABC");
		person.setActive(true);
		list = Flux.just(person);
	}

	@Nested
	@DisplayName("CRUD")
	class crud {

		@Test
		@DisplayName("LISTAR")
		void findAll(){
			when(personRepository.findAll()).thenReturn(list);
			System.out.println(when(personRepository.findAll()).thenReturn(list));
			System.out.println("LISTA = " + person);
			assertNotEquals(null, list);
		}

		@Test
		@DisplayName("GUARDAR")
		void save(){
			personRepository.save(person);
			System.out.println("GUARDADO = " + person);
			assertNotEquals(null, list);
		}

		@Test
		@DisplayName("MODIFICAR")
		void update(){
			System.out.println("LISTA ORIGINAL = " + person);
			person.setName("Carlos Alberto");
			personRepository.save(person);
			System.out.println("LISTA MODIFICADA = " + person);
			assertNotNull(person.getName());
		}

		@Test
		@DisplayName("ELIMINAR")
		void delete(){
			personRepository.deleteById(person.getId());
			Mono<Person> personDelete = personRepository.findById(person.getId());
			System.out.println("ELIMINADO CON EL ID = " + person.getId());
			System.out.println("ELIMINADO = " + person);
			System.out.println("LISTA = " + personDelete);
			assertNull(personDelete);
		}
	}

	@AfterAll
	void end() {
		System.out.println("FIN DE PRUEBAS");
	}
}
