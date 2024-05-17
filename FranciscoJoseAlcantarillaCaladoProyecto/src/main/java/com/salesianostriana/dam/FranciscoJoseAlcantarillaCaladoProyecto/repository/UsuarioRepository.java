package com.salesianostriana.dam.FranciscoJoseAlcantarillaCaladoProyecto.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.salesianostriana.dam.FranciscoJoseAlcantarillaCaladoProyecto.model.Usuario;



public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

	Optional<Usuario> findFirstByUsername(String username);

	
	
}
