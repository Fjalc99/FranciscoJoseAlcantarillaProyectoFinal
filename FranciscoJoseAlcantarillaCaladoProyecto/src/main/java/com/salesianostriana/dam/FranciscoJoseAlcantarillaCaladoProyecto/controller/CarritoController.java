package com.salesianostriana.dam.FranciscoJoseAlcantarillaCaladoProyecto.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.salesianostriana.dam.FranciscoJoseAlcantarillaCaladoProyecto.model.Producto;
import com.salesianostriana.dam.FranciscoJoseAlcantarillaCaladoProyecto.model.Usuario;
import com.salesianostriana.dam.FranciscoJoseAlcantarillaCaladoProyecto.model.Venta;
import com.salesianostriana.dam.FranciscoJoseAlcantarillaCaladoProyecto.service.CarritoService;
import com.salesianostriana.dam.FranciscoJoseAlcantarillaCaladoProyecto.service.ProductoService;

@Controller
public class CarritoController {

	@Autowired
	private CarritoService carritoService;
	
	@Autowired
	private ProductoService productoService;
	
	
	
	   @GetMapping("/carrito")
	   public String showCarrito(@AuthenticationPrincipal Usuario usuario, Model model) {
		    if (carritoService.hayCarrito(usuario)) {
		        Venta carrito = carritoService.getCarrito(usuario);
		        model.addAttribute("ventas", carrito.getLineaDeVenta());
		        return "paginaCarrito";
		    }
		    return "redirect:/tiendaPrincipal";
		}

	   @GetMapping("/productoACarrito/{id}")
	   public String agregarProductoCarrito(@PathVariable("id") Long id, Model model, @AuthenticationPrincipal Usuario usuario) {
	       Optional<Producto> producto = productoService.findById(id);
	       if(producto.isPresent()) {
	           carritoService.addProducto(producto.get(), 1, usuario);
	           return "redirect:/carrito";
	       }
	       return "redirect:/tiendaPrincipal";
	   }
	    
	    @GetMapping("/confirmar")
	    public String finalizarCompra(@AuthenticationPrincipal Usuario usuario) {
	        carritoService.finalizarCompra(usuario);
	        return "redirect:/Ventas";
	    }
	    
	    @GetMapping("/modificar/{id}/cantidad/{cantidad}")
	    public String modificar(Usuario usuario, @PathVariable("id") Long id, @PathVariable("cantidad") int cantidad) {
	        Optional <Producto> producto = productoService.findById(id);
	        if(producto.isPresent()) {
	            carritoService.modificar(producto.get(), cantidad, usuario);
	        }
	        return "redirect:/carrito";
	    }
}
