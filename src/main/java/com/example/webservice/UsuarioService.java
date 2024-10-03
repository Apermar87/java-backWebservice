package com.example.webservice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepositorio usuarioRepositorio;

    public List <Usuarios> extraerBaseDatos(){
        return usuarioRepositorio.findAll();
    }

    public Usuarios extraerDniBaseDatos(String dni){
        return usuarioRepositorio.findByDni(dni);
    }

    public void borrarDniBaseDatos(Usuarios usuarios){
        usuarioRepositorio.delete(usuarios);
    }

    public Usuarios guardarBaseDatos(Usuarios usuarios) {
        return usuarioRepositorio.save(usuarios);
    }
}
