-- BORRAR TABLA person SI EXISTE
DROP TABLE IF EXISTS student;


-- CREAR TABLA student
CREATE TABLE student (
    id SERIAL PRIMARY KEY NOT NULL,
	person_id INTEGER NOT NULL,
	career_id INTEGER NOT NULL,
	institutional_email VARCHAR(80) NOT NULL,
	pay_method VARCHAR(80) NOT NULL,
	admission_date VARCHAR(30) NOT NULL,
	guardian_name VARCHAR(80) NOT NULL,
	home_phone CHAR(9) NOT NULL,
	status CHAR(1) NOT NULL
);


-- INSERTAR REGISTROS DE student
INSERT INTO student
(person_id,career_id,institutional_email,pay_method,admission_date,guardian_name,home_phone,status)
VALUES
(1,1,'juan@vallegrande.edu.pe','Dinero en Efectivo','2022-10-10','Maria Carmen Jara Nuñez','958454679','G'),
(2,2,'carlos@vallegrande.edu.pe','Dinero en Efectivo','2022-10-10','Ana Luz Lira Carbonel','978456345','G'),
(3,1,'alex@vallegrande.edu.pe','Dinero en Efectivo','2022-10-10','Rosa Carmen Campos Lara','967453453','R'),
(4,2,'damian@vallegrande.edu.pe','Dinero en Efectivo','2022-10-10','Lucia Maria Lopez Nuñez','967456324','E'),
(5,1,'josue@vallegrande.edu.pe','Dinero en Efectivo','2022-10-10','Maria Luz Campos Sanchez','956453423','R'),
(6,2,'brayan@vallegrande.edu.pe','Dinero en Efectivo','2022-10-10','Luz Lucia Lopez Flores','905467567','E');


--CONSULTAR REGISTROS DE student
SELECT * FROM student;
