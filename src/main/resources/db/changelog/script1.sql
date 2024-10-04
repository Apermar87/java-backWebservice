-- Cambiar el tipo de dato de fecha_nacimiento de DATE a VARCHAR
ALTER TABLE usuarios 
ALTER COLUMN fecha_nacimiento TYPE VARCHAR(255);
