DROP TABLE IF EXISTS INSTITUTE;

CREATE TABLE INSTITUTE(
    id SERIAL,
    name VARCHAR(100) NOT NULL,
    ruc  VARCHAR(100) NOT NULL,
    area VARCHAR(100) NOT NULL,
    active BOOLEAN NOT NULL,
    PRIMARY KEY(id)
);

INSERT INTO INSTITUTE (name,ruc,area,active)
values  ('Valle Grande','20552103816','analisis de sistemas','true'),
        ('Valle Grande','20538856674','agronomia','true'),
        ('Condoray','20553856451','contabilidad','true'),
        ('Condoray','20553856451','administracion','true');

select * from INSTITUTE;