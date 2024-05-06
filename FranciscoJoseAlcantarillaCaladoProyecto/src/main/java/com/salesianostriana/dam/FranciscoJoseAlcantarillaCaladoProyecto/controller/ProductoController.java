package com.salesianostriana.dam.FranciscoJoseAlcantarillaCaladoProyecto.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.salesianostriana.dam.FranciscoJoseAlcantarillaCaladoProyecto.model.Producto;
import com.salesianostriana.dam.FranciscoJoseAlcantarillaCaladoProyecto.service.ProductoService;



@Controller
public class ProductoController {

	@Autowired
	private ProductoService productoservice;
	
	@GetMapping("/productoAdmin")
	private String listarProductos(Model model) {
		model.addAttribute("listaProductos", productoservice.findAll());
		return "productosVistaAdmin";
	}
	
	
	@GetMapping("/tienda")
	private String vistaTienda(Model model) {
		model.addAttribute("listaProductos", productoservice.findAll());
		return "producto";
	}
	
	
	@GetMapping("/descripcionProducto")
	private String vistaDescripcion(Model model) {
		Producto producto = new Producto ();
		model.addAttribute("vistaDescripcion", producto);
		return "descripcionDelProducto";
	}
	
	@GetMapping("/nuevo")
	public String formularioProducto(Model model) {
		model.addAttribute("producto", new  Producto());
		
		return "formularioProductos";
	}
	
	
	
	
	@PostMapping("/nuevo/addProducto")
	public String submit(@ModelAttribute("producto")Producto producto) {
		productoservice.save(producto);
		return "redirect:/productoAdmin";
	}
	
	@GetMapping("/editar/{id}")
	public String verEditarFormulario (@PathVariable("id") Long id, Model model) {

		Optional<Producto> pEditar = productoservice.findById(id); 
		if (pEditar.isPresent()) {
			model.addAttribute("producto", pEditar.get());
			return "formularioProductos";
		}else {
			return "redirect:/productoAdmin";
		}

	}


	@PostMapping("/editar/addProducto")
	public String verInformacionEditada (@ModelAttribute("producto")Producto p) {
		productoservice.edit(p);
		return"redirect:/productoAdmin";
	}
	
	
	@GetMapping("/borrar/{id}")
	public String borrarProducto(@PathVariable("id")Long id, Model model) {
		productoservice.deleteById(id);
		return "redirect:/productoAdmin";
	}
	
}
