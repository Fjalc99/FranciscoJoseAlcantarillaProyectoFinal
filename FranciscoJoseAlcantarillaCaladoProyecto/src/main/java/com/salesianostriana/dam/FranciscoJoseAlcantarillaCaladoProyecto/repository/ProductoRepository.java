package com.salesianostriana.dam.FranciscoJoseAlcantarillaCaladoProyecto.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.salesianostriana.dam.FranciscoJoseAlcantarillaCaladoProyecto.model.Producto;

public interface ProductoRepository extends JpaRepository <Producto, Long> {

	@Query("select p from Producto p where p.precio > 100.00")
	public List <Producto> prodcutosMasCarosDeCien (@Param("precio") double precio);
	

	 @Query("SELECT p FROM Producto p WHERE p.categoria.nombreCategoria = 'Balones'")
	  public List<Producto> findByCategoriaBalones();

	 @Query("SELECT p FROM Producto p WHERE p.categoria.nombreCategoria = 'Equipacion'")
	  public List<Producto> findByCategoriaEquipaciones();
	 
	 
	 @Query("SELECT p FROM Producto p WHERE p.categoria.nombreCategoria = 'Accesorios'")
	  public List<Producto> findByCategoriaAccesorios();

}
