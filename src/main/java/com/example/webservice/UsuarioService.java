package com.example.webservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;


@Service
public class UsuarioService {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void guardarBaseDatos(Usuarios usuarios){
        String sql = "INSERT INTO empleados (nombre, apellidos, dni, direccion, fecha_nacimiento) VALUES (?, ?, ?, ?, ?)";
        jdbcTemplate.update(sql, usuarios.getNombre(), usuarios.getApellidos(),usuarios.getDni(), usuarios.getDireccion(), usuarios.getFechaNacimiento());
    }
}
