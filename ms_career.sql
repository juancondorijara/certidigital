-- CREAR DATABASE as201-ms-career
CREATE DATABASE "as201-ms-career"
    WITH 
    OWNER = postgres
    ENCODING = 'UTF8'
    LC_COLLATE = 'Spanish_Peru.1252'
    LC_CTYPE = 'Spanish_Peru.1252'
    TABLESPACE = pg_default
    CONNECTION LIMIT = -1;


-- COMENTAR DATABASE
COMMENT ON DATABASE "as201-ms-career"
    IS 'Career Microservice Database';


-- CREAR TABLA career
CREATE TABLE career (
	id SERIAL PRIMARY KEY NOT NULL,
	name VARCHAR(100) NOT NULL,
	boss VARCHAR(100) NOT NULL,
	area VARCHAR(100) NOT NULL,
	institute_id INT NOT NULL,
	pension DECIMAL(5,2) NOT NULL,
	quantity_course INT NOT NULL,
	quantity_semester INT NOT NULL,
	active boolean NOT NULL
);


-- INSERTAR REGISTROS DE UBIGEO
INSERT INTO career
(name,boss,area,institute_id,pension,quantity_course,quantity_semester,active)
VALUES
('Análisis de Sistemas','Luis Aquilino Manzo Candela','Carrera Profesional de Anális de Sistemas','1','350.00','9','6','true'),
('Producción Agraria','Luis Ángel Ricardo Campos','Carrera Profesional de Producción Agraria','1','350.00','9','6','true');


SELECT * FROM career;


/*
SERVIDOR = pgsqlserver123
USUARIO = postgressql
CONTRASEÑA = Java2020@
*/
