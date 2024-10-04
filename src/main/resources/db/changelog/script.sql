-- script.sql
CREATE TABLE usuarios (
    id BIGINT PRIMARY KEY NOT NULL,
    nombre VARCHAR(255) NOT NULL,
    apellidos VARCHAR(255) NOT NULL,
    dni VARCHAR(10) NOT NULL UNIQUE,
    direccion TEXT,
    fecha_nacimiento DATE
);
