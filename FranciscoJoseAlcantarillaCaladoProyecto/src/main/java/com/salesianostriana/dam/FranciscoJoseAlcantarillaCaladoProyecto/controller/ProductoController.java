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
import com.salesianostriana.dam.FranciscoJoseAlcantarillaCaladoProyecto.service.CategoriaService;
import com.salesianostriana.dam.FranciscoJoseAlcantarillaCaladoProyecto.service.ProductoService;



@Controller
public class ProductoController {

	@Autowired
	private ProductoService productoService;
	
	@Autowired
	private CategoriaService categoriaService;
	
	
	@GetMapping("/tienda")
	private String vistaTienda(Model model) {
		model.addAttribute("listaProductos", productoService.findAll());
		return "tienda";
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
		model.addAttribute("listaCategorias", categoriaService.findAll());
		return "/admin/formularioProductos";
	}
	
	
	
	
	@PostMapping("/nuevo/submit")
	public String submit(@ModelAttribute("producto")Producto producto) {
		productoService.save(producto);
		return "redirect:/admin/productoAdmin";
	}
	
	@GetMapping("/editar/{id}")
	public String verEditarFormulario (@PathVariable("id") Long id, Model model) {

		Optional<Producto> pEditar = productoService.findById(id); 
		if (pEditar.isPresent()) {
			model.addAttribute("producto", pEditar.get());
			model.addAttribute("listaCategorias", categoriaService.findAll());
			return "/admin/formularioProductos";
		}else {
			return "redirect:/admin/productoAdmin";
		}

	}


	@PostMapping("/editar/submit")
	public String verInformacionEditada (@ModelAttribute("producto")Producto p) {
		productoService.edit(p);
		return"redirect:/admin/productoAdmin";
	}
	
	
	@GetMapping("/borrar/{id}")
	public String borrarProducto(@PathVariable("id")Long id, Model model) {
		productoService.deleteById(id);
		return "redirect:/admin/productoAdmin";
	}
	
}
