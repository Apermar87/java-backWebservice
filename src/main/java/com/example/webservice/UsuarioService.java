package com.example.webservice;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;



@Service
public class UsuarioService {

    /*@Autowired
    private JdbcTemplate jdbcTemplate;*/

    @Autowired
    private UsuarioRepositorio usuarioRepositorio;

    /*public void obtenerUsuarios(Usuarios usuarios){
        String sql = "SELECT * FROM empleados (nombre, apellidos, dni, direccion, fecha_nacimiento) VALUES (?, ?, ?, ?, ?)";
        jdbcTemplate.update(sql, usuarios.getNombre(), usuarios.getApellidos(), usuarios.getDni(), usuarios.getDireccion(), usuarios.getFechaNacimiento());
    }*/

    /*public void guardarBaseDatos(Usuarios usuarios){
        String sql = "INSERT INTO empleados (nombre, apellidos, dni, direccion, fecha_nacimiento) VALUES (?, ?, ?, ?, ?)";
        jdbcTemplate.update(sql, usuarios.getNombre(), usuarios.getApellidos(),usuarios.getDni(), usuarios.getDireccion(), usuarios.getFechaNacimiento());
    }*/

    public Usuarios guardarBaseDatos(Usuarios usuarios) {
        // Este método guarda o actualiza la entidad automáticamente en la base de datos
        return usuarioRepositorio.save(usuarios);
    }

}
