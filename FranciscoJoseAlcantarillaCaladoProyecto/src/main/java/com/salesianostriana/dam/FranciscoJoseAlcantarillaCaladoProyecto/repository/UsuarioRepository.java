package com.salesianostriana.dam.FranciscoJoseAlcantarillaCaladoProyecto.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.salesianostriana.dam.FranciscoJoseAlcantarillaCaladoProyecto.model.Usuario;



public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

	Optional<Usuario> findFirstByUsername(String username);

	 @Query("""
	            SELECT COUNT(u) > 0 
	            FROM Usuario u
	            WHERE u.username = ?1
	            """)
	    boolean noUserExistente(String username);
	
}

