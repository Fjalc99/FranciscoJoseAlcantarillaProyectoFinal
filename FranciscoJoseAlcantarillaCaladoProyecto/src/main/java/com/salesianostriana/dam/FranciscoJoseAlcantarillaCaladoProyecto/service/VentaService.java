package com.salesianostriana.dam.FranciscoJoseAlcantarillaCaladoProyecto.service;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.salesianostriana.dam.FranciscoJoseAlcantarillaCaladoProyecto.model.Producto;
import com.salesianostriana.dam.FranciscoJoseAlcantarillaCaladoProyecto.model.Usuario;
import com.salesianostriana.dam.FranciscoJoseAlcantarillaCaladoProyecto.model.Venta;

import com.salesianostriana.dam.FranciscoJoseAlcantarillaCaladoProyecto.repository.VentaRepository;
import com.salesianostriana.dam.FranciscoJoseAlcantarillaCaladoProyecto.service.base.BaseServiceImpl;

@Service
public class VentaService extends BaseServiceImpl<Venta, Long, VentaRepository> {

	 @Autowired
	    private VentaRepository ventaRepository;
	
	 public Optional<Producto> obtenerProductoMasVendido() {
	        return ventaRepository.findProductoMasVendido();
	    }
	 
	 public Optional<Usuario> obtenerSocioQueHaCompradoMas() {
	        return ventaRepository.findSocioQueHaCompradoMas();
	    }
}
