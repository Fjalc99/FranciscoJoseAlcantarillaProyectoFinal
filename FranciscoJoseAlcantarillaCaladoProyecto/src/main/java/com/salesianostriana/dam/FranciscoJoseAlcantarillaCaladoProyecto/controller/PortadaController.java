package com.salesianostriana.dam.FranciscoJoseAlcantarillaCaladoProyecto.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PortadaController {

	@GetMapping("/index")
	public String mostrarPortada(Model model) {
		return "portada";
	}
	
	
}
