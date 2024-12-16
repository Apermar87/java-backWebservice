# Web Service CRUD Application - Spring Boot

Este proyecto es una aplicación RESTful desarrollada con **Spring Boot** que implementa un CRUD (Crear, Leer, Actualizar, Eliminar) para gestionar información de usuarios almacenada en una base de datos **MySQL** utilizando **Liquibase** para el control de cambios en la base de datos y **Docker** para la contenerización.

---

## 🛠️ Tecnologías Utilizadas
- **Spring Boot**: Framework para aplicaciones Java.
- **JPA/Hibernate**: Para el manejo de la persistencia.
- **MySQL**: Base de datos relacional.
- **Liquibase**: Gestión de cambios en la base de datos.
- **Docker**: Contenerización de la base de datos.
- **Postman**: Herramienta para probar APIs.

---

## 🚀 Funcionalidades
1. **GET/ Obtener todos los usuarios**: Devuelve una lista de todos los usuarios registrados.
2. **POST/ Obtener usuario por DNI**: Recupera la información de un usuario mediante su DNI.
3. **POST/ Insertar usuario**: Permite registrar un nuevo usuario en la base de datos.
4. **DELETE/ Eliminar usuario por DNI**: Elimina un usuario basado en su DNI.

---

## 📂 Estructura del Proyecto
- **`Controller.java`**: Define las rutas REST.
- **`UsuarioService.java`**: Contiene la lógica de negocio.
- **`UsuarioRepositorio.java`**: Gestiona la persistencia de datos.
- **`Usuarios.java`**: Clase entidad que mapea la tabla `usuarios`.
- **`db.changelog-master.xml`**: Archivo principal de Liquibase para la gestión de cambios en la base de datos.
- **`script.sql` y `script1.sql`**: Scripts SQL ejecutados por Liquibase.
- **`application.properties`**: Configuración del proyecto.
- **`WebserviceApplication.java`**: Clase principal de Spring Boot.

---

## 📝 Gestión de la Base de Datos con Liquibase
El proyecto utiliza Liquibase para el control de cambios en la base de datos. Los cambios se definen en el archivo db.changelog-master.xml:
- script.sql: Crea la tabla usuarios con los campos necesarios.

Liquibase se integra automáticamente al iniciar el proyecto y aplica los cambios en la base de datos configurada.

---

## ⚙️ Requisitos
1. **Java**: JDK 11 o superior.
2. **Spring Boot**: Framework principal.
3. **Base de datos**: MySQL.
4. **Docker**: Para la contenerización de la base de datos.
5. **Herramienta de prueba**: Postman o cualquier cliente REST.

## 🔧 Configuración y Ejecución

### 1. Configuración de MySQL con Docker
Crea un contenedor Docker para la base de datos MySQL:

docker run --name mysql-container -e MYSQL_ROOT_PASSWORD=<tu_contraseña> -e MYSQL_DATABASE=<nombre_base_datos> -p 3306:3306 -d mysql:latest

### 2. Configura la base de datos en `application.properties`:

spring.datasource.url=jdbc:mysql://localhost:3306/<nombre_base_datos>
spring.datasource.username=<tu_usuario>
spring.datasource.password=<tu_contraseña>
spring.jpa.hibernate.ddl-auto=none
spring.liquibase.change-log=classpath:/db/changelog/db.changelog-master.xml


### 3. Ejecuta el proyecto con el siguiente comando:
   mvn spring-boot:run
