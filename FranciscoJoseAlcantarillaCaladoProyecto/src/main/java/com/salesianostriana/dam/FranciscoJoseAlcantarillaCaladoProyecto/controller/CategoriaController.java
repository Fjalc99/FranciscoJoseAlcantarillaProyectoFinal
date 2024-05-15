package com.salesianostriana.dam.FranciscoJoseAlcantarillaCaladoProyecto.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;


import com.salesianostriana.dam.FranciscoJoseAlcantarillaCaladoProyecto.model.Categoria;
import com.salesianostriana.dam.FranciscoJoseAlcantarillaCaladoProyecto.service.CategoriaService;

@Controller
public class CategoriaController {

	@Autowired
	private CategoriaService categoriaService;
	

	@GetMapping("/nuevaCategoria")
	public String formularioCategoria(Model model) {
		model.addAttribute("categoria", new Categoria());
		return "/admin/formularioCategoria";
	}
	
	
	@PostMapping("/nuevaCategoria/submit")
	public String submitCategoria(@ModelAttribute("categoria")Categoria categoria) {
		categoriaService.save(categoria);
		
		return "redirect:/admin/categoriaAdmin";
	}
	
	@GetMapping("/editarCategoria/{id}")
	public String verEditarFormulario(@PathVariable("id")Long id, Model model) {
		
		Optional<Categoria> cEditar = categoriaService.findById(id);
		if (cEditar.isPresent()) {
			model.addAttribute("categoria", cEditar.get());
			return "/admin/formularioCategoria";
		}else {
			return "redirect:/admin/categoriaVistaAdmin";
		}
	}
	
	@PostMapping("/editarCategoria/submit")
	public String verInformacionEditada(@ModelAttribute("categoria")Categoria c) {
		categoriaService.edit(c);
		return "redirect:/admin/categoriaAdmin";
	}
	
	@GetMapping("/borrarCategoria/{id}")
	public String borrarCategoria(@PathVariable("id")Long id, Model model) {
		categoriaService.deleteById(id);
		return "redirect:/admin/categoriaAdmin";
		
	}
	
	@GetMapping("/categoria")
	public String listarCategorias(Model model) {
		model.addAttribute("listarCategorias", categoriaService.findAll());
		return "/tienda";
	}
}
