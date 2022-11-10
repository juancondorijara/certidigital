package com.ms_student;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;
import com.ms_student.model.Student;
import com.ms_student.repository.StudentRepository;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import reactor.core.publisher.*;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.TestInstance.Lifecycle;

@TestInstance(Lifecycle.PER_CLASS)
@DisplayName("STUDENT")
class MsStudentApplicationTests {

	@Mock
	private StudentRepository studentRepository;

	Student student = new Student();

	Flux<Student> list;

	@BeforeAll
	void init() {
		System.out.println("INICIO DE PRUEBAS");
	}

	@BeforeEach
	void setUp(){
		MockitoAnnotations.initMocks(this);
		student.setId(Long.valueOf(1));
		student.setPerson_id(Long.valueOf(1));
		student.setCareer_id(Long.valueOf(1));
		student.setInstitutional_email("juan@vallegrande.edu.pe");
		student.setPay_method("Dinero en Efectivo");
		student.setAdmission_date("2022-10-10");
		student.setGuardian_name("Ana Luz Lira Carbonel");
		student.setHome_phone("945783424");
		student.setInstitutional_email("juan@vallegrande.edu.pe");
		student.setStatus("Estudiante");
		list = Flux.just(student);
	}

	@Nested
	@DisplayName("CRUD")
	class crud {

		@Test
		@DisplayName("LISTAR")
		void findAll(){
			when(studentRepository.findAll()).thenReturn(list);
			System.out.println(when(studentRepository.findAll()).thenReturn(list));
			System.out.println("LISTA = " + student);
			assertNotEquals(null, list);
		}

		@Test
		@DisplayName("GUARDAR")
		void save(){
			studentRepository.save(student);
			System.out.println("GUARDADO = " + student);
			assertNotEquals(null, list);
		}

		@Test
		@DisplayName("MODIFICAR")
		void update(){
			System.out.println("LISTA ORIGINAL = " + student);
			student.setInstitutional_email("juan.condori@vallegrande.edu.pe");
			studentRepository.save(student);
			System.out.println("LISTA MODIFICADA = " + student);
			assertNotNull(student.getInstitutional_email());
		}

		@Test
		@DisplayName("ELIMINAR")
		void delete(){
			studentRepository.deleteById(student.getId());
			Mono<Student> studentDelete = studentRepository.findById(student.getId());
			System.out.println("ELIMINADO CON EL ID = " + student.getId());
			System.out.println("ELIMINADO = " + student);
			System.out.println("LISTA = " + studentDelete);
			assertNull(studentDelete);
		}
	}

	@AfterAll
	void end() {
		System.out.println("FIN DE PRUEBAS");
	}

	@Test
	@DisplayName("TEST")
	void test(){
		//Long batch = 1L;
		//batch++;
		//System.out.println("LONG = " + batch);
		//assertNotNull(batch);

		Long a = 0L;
		System.out.println("A = " + a++);
		System.out.println("A = " + a++);
		System.out.println("A = " + a++);
		Long b = 0L;
		System.out.println("B = " + ++b);
		System.out.println("B = " + ++b);
		System.out.println("B = " + ++b);

		assertNotNull(a);
	}

}
