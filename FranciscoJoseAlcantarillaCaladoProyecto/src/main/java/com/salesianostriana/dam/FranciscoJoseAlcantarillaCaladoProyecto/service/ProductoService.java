package com.salesianostriana.dam.FranciscoJoseAlcantarillaCaladoProyecto.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.salesianostriana.dam.FranciscoJoseAlcantarillaCaladoProyecto.model.Producto;
import com.salesianostriana.dam.FranciscoJoseAlcantarillaCaladoProyecto.repository.ProductoRepository;
import com.salesianostriana.dam.FranciscoJoseAlcantarillaCaladoProyecto.service.base.BaseServiceImpl;

@Service
public class ProductoService extends BaseServiceImpl <Producto, Long, ProductoRepository> {

<<<<<<< HEAD
	
	
	
=======
	 @Autowired
	    private ProductoRepository productoRepository;
	 
	public List<Producto> getProductosBalones() {
        return productoRepository.findByCategoriaBalones();
    }
	
	
	public List<Producto> getProductosEquipaciones() {
        return productoRepository.findByCategoriaEquipaciones();
    }
	
	
	public List<Producto> getProductosAccesorios() {
        return productoRepository.findByCategoriaAccesorios();
    }
>>>>>>> 39-hu-21-consultas-para-filtrar
}
