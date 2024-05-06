package com.salesianostriana.dam.FranciscoJoseAlcantarillaCaladoProyecto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.salesianostriana.dam.FranciscoJoseAlcantarillaCaladoProyecto.model.Socio;
import com.salesianostriana.dam.FranciscoJoseAlcantarillaCaladoProyecto.service.SocioService;

@Controller
public class SocioController {
	
	
	@Autowired
	private SocioService socioService;
	
	
	
	//Login
	
	@GetMapping("/loginSocio")
	private String loginSocio(Model model) {
		
		Socio socio = new Socio();
		model.addAttribute("loginForm", socio);
		
		return "login";		
	}
	
	@PostMapping("/loginSocio/addSocio")
	public String submit (@ModelAttribute("loginForm")Socio socio, Model model) {
		model.addAttribute("socio", socio);
		
		return"redirect:/tienda";
	}
	
	
	//--------------------------------------------------------
	//Socio Nuevo
	
	@GetMapping("/sociosAdmin")
	private String listarSocios (Model model) {
		model.addAttribute("listaSocios", socioService.findAll());
		return "socioVistaAdmin";
	}
	
	@GetMapping("/nuevoSocios")
	private String formRegistro (Model model) {	
		model.addAttribute("socio", new Socio());
		return "registroSocio";
	}
	
	@PostMapping("/nuevoSocios/addSocioNuevo")
	public String submitRegistro (@ModelAttribute("socio") Socio socio) {
		socioService.save(socio);
		return "redirect:/sociosAdmin";
	}
	
}
