
DROP TABLE IF EXISTS career;
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


-- INSERTAR REGISTROS
INSERT INTO career
(name,boss,area,institute_id,pension,quantity_course,quantity_semester,active)
VALUES
('Análisis de Sistemas','Luis Aquilino Manzo Candela','Carrera Profesional de Anális de Sistemas','1','350.00','9','6','true'),
('Producción Agraria','Luis Ángel Ricardo Campos','Carrera Profesional de Producción Agraria','1','350.00','9','6','true');


SELECT * FROM career;

SELECT * FROM career WHERE id = 2;