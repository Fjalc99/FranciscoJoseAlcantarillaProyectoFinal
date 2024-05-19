package com.salesianostriana.dam.FranciscoJoseAlcantarillaCaladoProyecto.repository;

<<<<<<< HEAD
=======
import java.util.List;
>>>>>>> refs/remotes/origin/main
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

<<<<<<< HEAD
import com.salesianostriana.dam.FranciscoJoseAlcantarillaCaladoProyecto.model.Producto;
=======

>>>>>>> refs/remotes/origin/main
import com.salesianostriana.dam.FranciscoJoseAlcantarillaCaladoProyecto.model.Usuario;
import com.salesianostriana.dam.FranciscoJoseAlcantarillaCaladoProyecto.model.Venta;

public interface VentaRepository extends JpaRepository<Venta, Long> {

<<<<<<< HEAD
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
=======
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
            SELECT CASE WHEN COUNT(lv) > 0 THEN true ELSE false END 
            FROM LineaDeVenta lv 
            WHERE lv.venta.usuario.id = ?1 
            AND lv.producto.id = ?2 
            AND lv.venta.finalizada = false
            """)
    boolean hayProductoEnCarrito(Long usuarioId, Long productoId);
    
    
    @Query("SELECT v FROM Venta v WHERE v.usuario = ?1")
    List<Venta> findAllByUsuario(Usuario usuario);

	List<Venta> findByUsuario(Usuario usuario);
>>>>>>> refs/remotes/origin/main
}
