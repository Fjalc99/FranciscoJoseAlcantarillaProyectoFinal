package com.salesianostriana.dam.FranciscoJoseAlcantarillaCaladoProyecto.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.salesianostriana.dam.FranciscoJoseAlcantarillaCaladoProyecto.model.Producto;
import com.salesianostriana.dam.FranciscoJoseAlcantarillaCaladoProyecto.model.Usuario;
import com.salesianostriana.dam.FranciscoJoseAlcantarillaCaladoProyecto.model.Venta;

public interface VentaRepository extends JpaRepository<Venta, Long> {

	@Query("""
            SELECT v
            FROM Venta v 
            WHERE v.finalizada = false
            AND v.usuario = ?1
            """)
    Optional<Venta> findByFinalizadaAndUsuario(Usuario usuario);

    @Query("""
            SELECT COUNT(v) > 0
            FROM Venta v 
            WHERE v.finalizada = false
            AND v.usuario = ?1
            """)
    boolean existVentaNoFinalizada(Usuario usuario);
    
    @Query("""
            SELECT CASE WHEN COUNT(v) > 0 THEN true ELSE false END 
            FROM Venta v left JOIN v.lineasVentas lv WHERE v.usuario
            = ?1 and lv.producto = ?2 AND finalizada = false
            """)
    boolean hayProductoEnCarrito(Usuario usuario, Producto producto);
	
}
