package com.salesianostriana.dam.FranciscoJoseAlcantarillaCaladoProyecto.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PortadaController {

	@GetMapping("/")
	public String mostrarPortada() {
		return "index";
	}
	
	
}