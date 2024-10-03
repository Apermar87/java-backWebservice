package com.example.webservice;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://localhost:8080")
public class Controller {

    @Autowired
    private UsuarioService usuariosService;

    ArrayList<Usuarios> usuarios;

    public Controller() {
        usuarios = new ArrayList<>();
        usuarios.add(new Usuarios("Antonio", "Pérez", "30521874D", "Avenida Carlos 3", "1990-01-01"));
        usuarios.add(new Usuarios("Pedro", "Marín", "50412987R", "Avenida Cervantes", "1990-01-01"));
    }

    @GetMapping("/obtenerListaUsuarios")
    public ArrayList<Usuarios> obtenerListaUsuarios() {
        return usuarios;
    }

    @PostMapping("/obtenerUsuarioDni")
    public Usuarios obtenerUsuarioDni(@RequestParam("dni") String dni) {
        for (Usuarios usuarioEncontrado : usuarios) {
            if (usuarioEncontrado.getDni().equals(dni)) {
                return usuarioEncontrado;
            }
        }
        return null;
    }

    @DeleteMapping("/borrarUsuarioDni")
    public Usuarios borrarUsuarioDni(@RequestParam("dni") String dni) {
        for (Usuarios usuarioEncontrado : usuarios) {
            if (usuarioEncontrado.getDni().equals(dni)) {
                usuarios.remove(usuarioEncontrado);
                return usuarioEncontrado;
            }
        }
        return null;
    }

    @PostMapping("/insertarUsuario")
    public Usuarios insertarUsuario(@RequestParam("nombre") String nombre, @RequestParam("apellidos") String apellidos,
            @RequestParam("dni") String dni, @RequestParam("direccion") String direccion,
            @RequestParam("fecha de nacimiento") String fecha_nacimiento) {
        Usuarios nuevoUsuario = new Usuarios(nombre, apellidos, dni, direccion, fecha_nacimiento);
        usuarios.add(nuevoUsuario);

        return usuariosService.guardarBaseDatos(nuevoUsuario);
    }

    @PostMapping("/pruebaInsertar")
    public String pruebaInsertar() {
        Usuarios usuarioPrueba = new Usuarios("Prueba2", "Usuario2", "32345678R", "Dirección Prueba2", "1990-01-04");
        usuariosService.guardarBaseDatos(usuarioPrueba);
        return "Insertado";
    }

}
