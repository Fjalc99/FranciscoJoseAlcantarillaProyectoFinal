package com.salesianostriana.dam.FranciscoJoseAlcantarillaCaladoProyecto.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.salesianostriana.dam.FranciscoJoseAlcantarillaCaladoProyecto.model.Talla;
import com.salesianostriana.dam.FranciscoJoseAlcantarillaCaladoProyecto.repository.ProductoRepository;
import com.salesianostriana.dam.FranciscoJoseAlcantarillaCaladoProyecto.repository.TallaRepository;
import com.salesianostriana.dam.FranciscoJoseAlcantarillaCaladoProyecto.service.base.BaseServiceImpl;

@Service
public class TallaService extends BaseServiceImpl <Talla, Long, TallaRepository>{

	
	@Autowired
	private ProductoRepository productoRepository;
	
	
	  public int countProductosByTalla(Long tallaId) {
	        return productoRepository.countProductosByTalla(tallaId);
	    }
	
}
