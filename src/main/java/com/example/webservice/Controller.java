package com.example.webservice;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "http://localhost:8080")
public class Controller {

    @Autowired
    private UsuarioService usuariosService;

    ArrayList<Usuarios> usuarios;
    
    public Controller() {
        usuarios = new ArrayList<>();
        usuarios.add(new Usuarios("Antonio", "Pérez", "30521874D", "Avenida Carlos 3", "17/05/2000"));
        usuarios.add(new Usuarios("Pedro", "Marín", "50412987R", "Avenida Cervantes", "05/06/1998"));
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
    public Usuarios insertarUsuario(@RequestParam("nombre") String nombre, @RequestParam("apellidos") String apellidos, @RequestParam("dni") String dni, @RequestParam("direccion") String direccion, @RequestParam("fecha de nacimiento") String fechaNacimiento) {
        Usuarios nuevoUsuario = new Usuarios(nombre, apellidos, dni, direccion, fechaNacimiento);
        usuarios.add(nuevoUsuario);

        usuariosService.guardarBaseDatos(nuevoUsuario);

        return nuevoUsuario;
    } 

    

}
