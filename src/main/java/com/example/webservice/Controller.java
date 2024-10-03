package com.example.webservice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://localhost:8080")
public class Controller {

    @Autowired
    private UsuarioService usuariosService;

    @GetMapping("/obtenerListaUsuarios")
    public List<Usuarios> obtenerListaUsuarios() {
        return usuariosService.extraerBaseDatos();
    }

    @PostMapping("/obtenerUsuarioDni")
    public Usuarios obtenerUsuarioDni(@RequestParam("dni") String dni) {
        return usuariosService.extraerDniBaseDatos(dni);
    }

    @DeleteMapping("/borrarUsuarioDni")
    public void borrarUsuarioDni(@RequestParam("dni") String dni) {
        Usuarios usuario = usuariosService.extraerDniBaseDatos(dni);
        usuariosService.borrarDniBaseDatos(usuario);
    }

    @PostMapping("/insertarUsuario")
    public Usuarios insertarUsuario(@RequestParam("nombre") String nombre, @RequestParam("apellidos") String apellidos,
            @RequestParam("dni") String dni, @RequestParam("direccion") String direccion,
            @RequestParam("fecha de nacimiento") String fecha_nacimiento) {
        Usuarios nuevoUsuario = new Usuarios(nombre, apellidos, dni, direccion, fecha_nacimiento);

        return usuariosService.guardarBaseDatos(nuevoUsuario);
    }

}
