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
	

	@GetMapping("/nuevoSocios")
	private String formRegistro (Model model) {	
		model.addAttribute("usuario", new Usuario());
		return "/admin/registroSocio";
	}
	
	@PostMapping("/nuevoSocios/addSocioNuevo")
	public String submitRegistro (@ModelAttribute("usuario") Usuario usuario) {
		usuarioService.save(usuario);
		return "redirect:/admin/sociosAdmin";
	}
	
}
