package com.salesianostriana.dam.FranciscoJoseAlcantarillaCaladoProyecto.service;




import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


import com.salesianostriana.dam.FranciscoJoseAlcantarillaCaladoProyecto.model.Usuario;
import com.salesianostriana.dam.FranciscoJoseAlcantarillaCaladoProyecto.repository.UsuarioRepository;
import com.salesianostriana.dam.FranciscoJoseAlcantarillaCaladoProyecto.service.base.BaseServiceImpl;




@Service
public class UsuarioService extends BaseServiceImpl <Usuario, Long, UsuarioRepository> {

	private UsuarioRepository usuarioRepository;
	
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	@Override
	public Usuario save(Usuario t) {
		// TODO Auto-generated method stub
	t.setPassword(passwordEncoder.encode(t.getPassword()));
		
		return super.save(t);
	}
	
	
	

	
	
	
}
