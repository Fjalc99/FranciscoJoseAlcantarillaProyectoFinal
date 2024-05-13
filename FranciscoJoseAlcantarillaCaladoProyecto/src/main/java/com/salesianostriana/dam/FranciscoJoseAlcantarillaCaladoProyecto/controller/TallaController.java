package com.salesianostriana.dam.FranciscoJoseAlcantarillaCaladoProyecto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.salesianostriana.dam.FranciscoJoseAlcantarillaCaladoProyecto.model.Talla;
import com.salesianostriana.dam.FranciscoJoseAlcantarillaCaladoProyecto.service.TallaService;

@Controller
public class TallaController {

	@Autowired
	private TallaService tallaService;
	
	
	@GetMapping("/nuevaTalla")
	public String formularioTalla (Model model) {
	model.addAttribute("talla", new Talla ());
	return "/admin/formularioVariante";
	}
	
	@PostMapping("/nuevaTalla/submit")
	public String submitCategoria (@ModelAttribute("talla") Talla talla) {
		tallaService.save(talla);
		return "redirect:/admin/tallasAdmin";
	}
	
	
	
}
