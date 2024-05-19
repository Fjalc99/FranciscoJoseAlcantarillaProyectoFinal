package com.salesianostriana.dam.FranciscoJoseAlcantarillaCaladoProyecto.service;




import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


import com.salesianostriana.dam.FranciscoJoseAlcantarillaCaladoProyecto.model.Usuario;
import com.salesianostriana.dam.FranciscoJoseAlcantarillaCaladoProyecto.model.Venta;
import com.salesianostriana.dam.FranciscoJoseAlcantarillaCaladoProyecto.repository.UsuarioRepository;
import com.salesianostriana.dam.FranciscoJoseAlcantarillaCaladoProyecto.repository.VentaRepository;
import com.salesianostriana.dam.FranciscoJoseAlcantarillaCaladoProyecto.service.base.BaseServiceImpl;




@Service
public class UsuarioService extends BaseServiceImpl <Usuario, Long, UsuarioRepository> {

	
	@Autowired
	private VentaRepository ventaRepository;
	
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	@Override
	public Usuario save(Usuario t) {
		// TODO Auto-generated method stub
	t.setPassword(passwordEncoder.encode(t.getPassword()));
		
		return super.save(t);
	}
	
	public List<Venta> getVentasPorUsuario(Usuario usuario) {
	    return ventaRepository.findAllByUsuario(usuario);
	}
	

	
	
	
}
