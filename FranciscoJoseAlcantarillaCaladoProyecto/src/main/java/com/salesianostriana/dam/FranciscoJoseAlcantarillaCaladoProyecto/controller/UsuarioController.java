package com.salesianostriana.dam.FranciscoJoseAlcantarillaCaladoProyecto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;


import com.salesianostriana.dam.FranciscoJoseAlcantarillaCaladoProyecto.model.Usuario;
import com.salesianostriana.dam.FranciscoJoseAlcantarillaCaladoProyecto.service.UsuarioService;


@Controller
public class UsuarioController {
	
	
	@Autowired
	private UsuarioService usuarioService;
	
	
	
	//Login
	
	@GetMapping("/loginUsuario")
	private String loginSocio(Model model) {
		
		Usuario usuario = new Usuario();
		model.addAttribute("loginForm", usuario);
		
		return "login";		
	}
	
	@PostMapping("/loginSocio/addSocio")
	public String submit (@ModelAttribute("loginForm") Usuario usuario, Model model) {
		model.addAttribute("Usuario", usuario);
		
		return"redirect:/tienda";
	}
	
	
	//--------------------------------------------------------
	//Socio Nuevo
	
	@GetMapping("/sociosAdmin")
	private String listarSocios (Model model) {
		model.addAttribute("listaSocios", usuarioService.findAll());
		return "socioVistaAdmin";
	}
	
	@GetMapping("/nuevoSocios")
	private String formRegistro (Model model) {	
		model.addAttribute("usuario", new Usuario());
		return "registroSocio";
	}
	
	@PostMapping("/nuevoSocios/addSocioNuevo")
	public String submitRegistro (@ModelAttribute("usuario") Usuario usuario) {
		usuarioService.save(usuario);
		return "redirect:/sociosAdmin";
	}
	
}
