package com.example.webservice;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepositorio extends JpaRepository<Usuarios, Long> {
    Usuarios findByDni (String dni) ;
}
