package com.salesianostriana.dam.FranciscoJoseAlcantarillaCaladoProyecto.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.salesianostriana.dam.FranciscoJoseAlcantarillaCaladoProyecto.model.Producto;
import com.salesianostriana.dam.FranciscoJoseAlcantarillaCaladoProyecto.model.Usuario;
import com.salesianostriana.dam.FranciscoJoseAlcantarillaCaladoProyecto.model.Venta;

public interface VentaRepository extends JpaRepository<Venta, Long> {

	@Query("SELECT lv.producto, SUM(lv.cantidadProducto) " +
		       "FROM LineaDeVenta lv " +
		       "GROUP BY lv.producto " +
		       "ORDER BY SUM(lv.cantidadProducto) DESC " + 
		       "LIMIT 1")
		Optional<Producto> findProductoMasVendido();
	
	
	@Query("SELECT v.usuario, COUNT(v.usuario) " +
		       "FROM Venta v " +
		       "GROUP BY v.usuario " +
		       "ORDER BY COUNT(v.usuario) DESC " +
		       "LIMIT 1")
		Optional<Usuario> findSocioQueHaCompradoMas();
}
