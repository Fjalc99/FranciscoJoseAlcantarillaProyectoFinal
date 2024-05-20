package com.salesianostriana.dam.FranciscoJoseAlcantarillaCaladoProyecto.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.salesianostriana.dam.FranciscoJoseAlcantarillaCaladoProyecto.model.Categoria;
import com.salesianostriana.dam.FranciscoJoseAlcantarillaCaladoProyecto.repository.CategoriaRepository;
import com.salesianostriana.dam.FranciscoJoseAlcantarillaCaladoProyecto.repository.ProductoRepository;
import com.salesianostriana.dam.FranciscoJoseAlcantarillaCaladoProyecto.service.base.BaseServiceImpl;

@Service
public class CategoriaService extends BaseServiceImpl<Categoria, Long, CategoriaRepository> {

    @Autowired
    private ProductoRepository productoRepository;
	
	
	 public int countProductosByCategoria(Long categoriaId) {
	        return productoRepository.countProductosByCategoria(categoriaId);
	    }

}
