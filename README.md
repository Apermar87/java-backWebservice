# Web Service CRUD Application - Spring Boot

Este proyecto es una aplicación RESTful desarrollada con **Spring Boot** que implementa un CRUD (Crear, Leer, Actualizar, Eliminar) para gestionar información de usuarios almacenada en una base de datos.

## 🛠️ Tecnologías Utilizadas
- Spring Boot: Framework para aplicaciones Java.
- JPA/Hibernate: Para el manejo de la persistencia.
- MySQL: Base de datos relacional.
- Postman: Herramienta para probar APIs.

## 🚀 Funcionalidades

1. **Obtener todos los usuarios**: Devuelve una lista de todos los usuarios registrados.
2. **Obtener usuario por DNI**: Recupera la información de un usuario mediante su DNI.
3. **Insertar usuario**: Permite registrar un nuevo usuario en la base de datos.
4. **Eliminar usuario por DNI**: Elimina un usuario basado en su DNI.

## 📂 Estructura del Proyecto

### 1. `Controller.java`
Define las rutas REST y las operaciones disponibles:
- `GET /obtenerListaUsuarios`: Devuelve la lista de todos los usuarios.
- `POST /obtenerUsuarioDni`: Recupera un usuario por DNI.
- `POST /insertarUsuario`: Inserta un nuevo usuario.
- `DELETE /borrarUsuarioDni`: Borra un usuario por DNI.

### 2. `UsuarioService.java`
Servicio que actúa como intermediario entre el controlador y el repositorio para realizar las operaciones CRUD.

### 3. `UsuarioRepositorio.java`
Extiende `JpaRepository` para interactuar con la base de datos. Incluye métodos personalizados como `findByDni`.

### 4. `Usuarios.java`
Entidad que representa un usuario en la base de datos con atributos como:
- `nombre`
- `apellidos`
- `dni`
- `direccion`
- `fecha_nacimiento`

### 5. `WebserviceApplication.java`
Clase principal que inicia la aplicación Spring Boot.

## ⚙️ Requisitos

1. **Java**: JDK 11 o superior.
2. **Spring Boot**: Dependencias incluidas:
   - `spring-boot-starter-web`
   - `spring-boot-starter-data-jpa`
3. **Base de datos**: Configuración de una base de datos relacional soportada por JPA (por ejemplo, MySQL).
4. **Herramienta de prueba**: Postman o cualquier cliente REST.

## 🔧 Configuración

1. Configura la base de datos en `application.properties`:
   ```properties
   spring.datasource.url=jdbc:mysql://localhost:3306/nombre_base_datos
   spring.datasource.username=tu_usuario
   spring.datasource.password=tu_contraseña
   spring.jpa.hibernate.ddl-auto=update

2. Ejecuta el proyecto con el siguiente comando:
   mvn spring-boot:run
