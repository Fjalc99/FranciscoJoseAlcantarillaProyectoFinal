package com.salesianostriana.dam.FranciscoJoseAlcantarillaCaladoProyecto.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.salesianostriana.dam.FranciscoJoseAlcantarillaCaladoProyecto.model.Producto;
import com.salesianostriana.dam.FranciscoJoseAlcantarillaCaladoProyecto.repository.ProductoRepository;
import com.salesianostriana.dam.FranciscoJoseAlcantarillaCaladoProyecto.repository.VentaRepository;
import com.salesianostriana.dam.FranciscoJoseAlcantarillaCaladoProyecto.service.base.BaseServiceImpl;

@Service
public class ProductoService extends BaseServiceImpl <Producto, Long, ProductoRepository> {


	 @Autowired
	    private ProductoRepository productoRepository;
	 
	 @Autowired
	 private VentaRepository ventaRepository;
	 
	 public List<Producto> findByCategoriaId(Long categoriaId) {
	        return productoRepository.findByCategoriaId(categoriaId);
	    }
	
	 public int countNumProductoByVenta(Long productoId) {
	        return ventaRepository.countNumProductoByVenta(productoId);
	    }
}
