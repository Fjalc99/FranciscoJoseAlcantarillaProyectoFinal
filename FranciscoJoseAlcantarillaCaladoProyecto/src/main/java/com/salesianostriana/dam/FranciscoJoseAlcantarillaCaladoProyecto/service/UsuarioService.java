package com.salesianostriana.dam.FranciscoJoseAlcantarillaCaladoProyecto.service;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;


import com.salesianostriana.dam.FranciscoJoseAlcantarillaCaladoProyecto.model.Usuario;
import com.salesianostriana.dam.FranciscoJoseAlcantarillaCaladoProyecto.repository.UsuarioRepository;
import com.salesianostriana.dam.FranciscoJoseAlcantarillaCaladoProyecto.service.base.BaseServiceImpl;

import jakarta.transaction.Transactional;

@Service
public class UsuarioService extends BaseServiceImpl <Usuario, Long, UsuarioRepository> {

	@Transactional
	public void encriptarPassword (Usuario username, Usuario formRegistro) {
		String newPassword = "{bcrypt}" + new BCryptPasswordEncoder().encode(formRegistro.getPassword());
		
		
	}
	
}
