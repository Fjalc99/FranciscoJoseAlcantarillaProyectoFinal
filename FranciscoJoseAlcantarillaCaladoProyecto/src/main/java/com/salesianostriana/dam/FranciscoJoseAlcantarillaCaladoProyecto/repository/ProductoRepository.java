package com.salesianostriana.dam.FranciscoJoseAlcantarillaCaladoProyecto.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.salesianostriana.dam.FranciscoJoseAlcantarillaCaladoProyecto.model.Producto;

public interface ProductoRepository extends JpaRepository <Producto, Long> {

	@Query("select p from Producto p where p.precio > 100.00")
	public List <Producto> prodcutosMasCarosDeCien (@Param("precio") double precio);
	

	   @Query("SELECT p FROM Producto p WHERE p.categoria.id = :categoriaId")
	    List<Producto> findByCategoriaId(Long categoriaId);
	   
	   @Query("SELECT COUNT(p) FROM Producto p WHERE p.categoria.id = :categoriaId")
	    int countProductosByCategoria(@Param("categoriaId") Long categoriaId);
	
	   @Query("SELECT COUNT(p) FROM Producto p JOIN p.tallas t WHERE t.id = :tallaId")
	    int countProductosByTalla(@Param("tallaId") Long tallaId);
	
}
