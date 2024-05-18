package com.salesianostriana.dam.FranciscoJoseAlcantarillaCaladoProyecto.service;

import java.time.LocalDateTime;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.salesianostriana.dam.FranciscoJoseAlcantarillaCaladoProyecto.model.LineaDeVenta;
import com.salesianostriana.dam.FranciscoJoseAlcantarillaCaladoProyecto.model.Producto;
import com.salesianostriana.dam.FranciscoJoseAlcantarillaCaladoProyecto.model.Usuario;
import com.salesianostriana.dam.FranciscoJoseAlcantarillaCaladoProyecto.model.Venta;

@Service
public class CarritoService  {

	@Autowired
	private VentaService ventaService;
	
	
	  public void addProducto(Producto producto, int cantidad, Usuario usuario) {
	        Venta carrito = getCarrito(usuario);
	        
	        if(!ventaService.hayProductosEnCarrito(usuario, producto)) {
	            carrito.addLineDeVenta(
	                    LineaDeVenta.builder()
	                    .producto(producto)
	                    .cantidadProducto(cantidad)
	                    .subTotal(cantidad*producto.getPrecio())
	                    .build()
	                    );    
	        }else {
	            Optional<LineaDeVenta> lv = buscarPorProducto(producto, usuario);
	            if(lv.isPresent()) {
	                modificar(producto, lv.get().getCantidadProducto()+1, usuario);
	            }
	        }
	        
	        ventaService.edit(carrito);
	    }
	  
	  public void modificar(Producto producto, int cantidad, Usuario usuario) {
		    Venta carrito = getCarrito(usuario);

		    if (cantidad <= 0) {
		        borrar(producto, usuario);
		    } else {
		        Optional<LineaDeVenta> lv = buscarPorProducto(producto, usuario);
		        if (lv.isPresent()) {
		            LineaDeVenta lineaDeVenta = lv.get();
		            lineaDeVenta.setCantidadProducto(cantidad);

		            lineaDeVenta.setSubTotal(lineaDeVenta.getProducto().getPrecio() * cantidad);
		            ventaService.edit(carrito);
		        } else {
		            addProducto(producto, cantidad, usuario);
		        }
		    }
		}
	  
	  public void finalizarCompra(Usuario usuario) {
	        Venta carrito = getCarrito(usuario);
	        
	        carrito.setFinalizada(true);
	        carrito.setTotal(getImporte(usuario));
	        carrito.setFechaCompra(LocalDateTime.now());
	        
	        ventaService.edit(carrito);
	        usuario.getVenta().add(carrito);

	    }
	  
	    public double getImporte(Usuario usuario){
	        return getCarrito(usuario).getLineaDeVenta()
	            .stream()
	            .mapToDouble(LineaDeVenta::getSubTotal)
	            .sum();
	    }
	    
	    public void borrar( Producto producto, Usuario usuario){
	        Venta carrito = getCarrito(usuario);
	        Optional<LineaDeVenta> eliminar = buscarPorProducto(producto, usuario);
	        
	        if(eliminar.isPresent()) {
	            carrito.removeLineaDeVenta(eliminar.get());
	            ventaService.edit(carrito);
	        }    
	    }
	    
	    
	    
	    public Optional<LineaDeVenta> buscarPorProducto(Producto producto, Usuario usuario){
	        Venta carrito = getCarrito(usuario);
	        return carrito.getLineaDeVenta().stream()
	                .filter(lv -> lv.getProducto().getId()== producto.getId())
	                .findFirst();
	    }
	    
	    public Venta crearCarrito(Usuario usuario) {
	        
	        Venta carrito = Venta.builder()
	                .usuario(usuario)
	                .finalizada(false)
	                .build();
	        ventaService.save(carrito);
	        return carrito;  
	    }            
	  
	    public boolean hayCarrito(Usuario usuario) {
	        return ventaService.existeVentaNoFinaliza(usuario);
	    }
	    
	  public Venta getCarrito(Usuario usuario) {
	        return ventaService.getVentaNoFinaliza(usuario).orElseGet(() -> crearCarrito(usuario));
	    }
	  
	   public Map<Producto, Integer> getProductoEnCarrito(Usuario usuario){
	        return getCarrito(usuario)
	                .getLineaDeVenta()
	                .stream()
	                .collect(Collectors.toMap(lv -> lv.getProducto(),lv -> lv.getCantidadProducto()));
	    }
}
