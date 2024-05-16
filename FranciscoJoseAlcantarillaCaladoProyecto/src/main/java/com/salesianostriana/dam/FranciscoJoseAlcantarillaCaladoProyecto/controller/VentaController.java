package com.salesianostriana.dam.FranciscoJoseAlcantarillaCaladoProyecto.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.salesianostriana.dam.FranciscoJoseAlcantarillaCaladoProyecto.service.VentaService;

@Controller
public class VentaController {

	@Autowired
	private VentaService ventaService;
		
	
	
	@GetMapping("/ventas")
	public String listaVentas (Model model) {
		model.addAttribute("venta", ventaService.findAll());
		
		return "misVentas";
	}
	
}
