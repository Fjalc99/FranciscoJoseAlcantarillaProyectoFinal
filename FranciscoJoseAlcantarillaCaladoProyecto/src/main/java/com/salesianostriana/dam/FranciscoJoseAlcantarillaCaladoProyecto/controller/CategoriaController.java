package com.salesianostriana.dam.FranciscoJoseAlcantarillaCaladoProyecto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.salesianostriana.dam.FranciscoJoseAlcantarillaCaladoProyecto.model.Categoria;
import com.salesianostriana.dam.FranciscoJoseAlcantarillaCaladoProyecto.service.CategoriaService;

@Controller
@RequestMapping("/admin")
public class CategoriaController {

	@Autowired
	private CategoriaService categoriaService;
	
	@GetMapping("/categoriaAdmin")
	public String listarCategorias(Model model) {
		model.addAttribute("listaCategorias", categoriaService.findAll());
		return "/admin/categoriaVistaAdmin";
	}
	
	
	@GetMapping("/nuevaCategoria")
	public String formularioCategoria(Model model) {
		model.addAttribute("categoria", new Categoria());
		return "/admin/formularioCategoria";
	}
	
	
	@PostMapping("/nuevaCategoria/addCategoria")
	public String submitCategoria(@ModelAttribute("categoria")Categoria categoria) {
		categoriaService.save(categoria);
		
		return "redirect:/admin/categoriaAdmin";
	}
}
