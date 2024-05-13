package com.salesianostriana.dam.FranciscoJoseAlcantarillaCaladoProyecto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.salesianostriana.dam.FranciscoJoseAlcantarillaCaladoProyecto.service.CategoriaService;
import com.salesianostriana.dam.FranciscoJoseAlcantarillaCaladoProyecto.service.ProductoService;
import com.salesianostriana.dam.FranciscoJoseAlcantarillaCaladoProyecto.service.TallaService;
import com.salesianostriana.dam.FranciscoJoseAlcantarillaCaladoProyecto.service.UsuarioService;


@Controller
@RequestMapping("/admin")
public class AdminController {

	@Autowired
	private UsuarioService usuarioService;
	
	@Autowired
	private ProductoService productoService;
	
	
	@Autowired
	private CategoriaService categoriaService;
	
	
	@Autowired
	private TallaService tallaService;
	
	
	
	
	@GetMapping("/productoAdmin")
	private String listarProductos(Model model) {
		model.addAttribute("listaProductos", productoService.findAll());
		return "/admin/productosVistaAdmin";
	}

	@GetMapping("/categoriaAdmin")
	public String listarCategorias(Model model) {
		model.addAttribute("listarCategorias", categoriaService.findAll());
		return "/admin/categoriaVistaAdmin";
	}
	
	@GetMapping("/sociosAdmin")
	private String listarSocios (Model model) {
		model.addAttribute("listaSocios", usuarioService.findAll());
		return "/admin/socioVistaAdmin";
	}
	
	
	@GetMapping("/tallasAdmin")
	private String listarVariantes(Model model) {
		model.addAttribute("variante", tallaService.findAll());
		return "/admin/varianteVistaAdmin";
	}

}
