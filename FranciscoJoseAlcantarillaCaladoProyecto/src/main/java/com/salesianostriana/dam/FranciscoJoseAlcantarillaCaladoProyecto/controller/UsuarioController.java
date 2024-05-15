package com.salesianostriana.dam.FranciscoJoseAlcantarillaCaladoProyecto.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;


import com.salesianostriana.dam.FranciscoJoseAlcantarillaCaladoProyecto.model.Usuario;
import com.salesianostriana.dam.FranciscoJoseAlcantarillaCaladoProyecto.service.UsuarioService;


@Controller
public class UsuarioController {
	
	
	@Autowired
	private UsuarioService usuarioService;
	

	

	@GetMapping("/usuario/perfil")
	public String me (@AuthenticationPrincipal Usuario usuario, Model model) {
		model.addAttribute("usuario", usuario);
		return "perfil";
	}
	
		
	@GetMapping("/nuevoSocios")
	private String formRegistro (Model model) {	
		model.addAttribute("usuario", new Usuario());
		return "/admin/registroSocio";
	}
	
	@PostMapping("/nuevoSocios/submit")
	public String submitRegistro( Usuario usuario, Model model) {
		usuarioService.save(usuario);
		return "redirect:/admin/sociosAdmin";
	}
	
	@GetMapping("/editarSocio/{id}")
	public String verEditarFormulario (@PathVariable("id") Long id, Model model) {

		Optional<Usuario> pEditar = usuarioService.findById(id); 
		if (pEditar.isPresent()) {
			model.addAttribute("usuario", pEditar.get());
			return "/admin/registroSocio";
		}else {
			return "redirect:/admin/sociosAdmin";
		}

	}


	@PostMapping("/editarSocio/submit")
	public String verInformacionEditada (@ModelAttribute("usuario")Usuario u) {
		usuarioService.edit(u);
		return"redirect:/admin/sociosAdmin";
	}
	
	@GetMapping("/borrarSocio/{id}")
	public String borrarSocio (@PathVariable("id")Long id, Model model) {
		usuarioService.deleteById(id);
		 model.addAttribute("mensaje", "El socio ha sido eliminado exitosamente.");
		return "redirect:/admin/sociosAdmin";
	}
	
	
	@GetMapping("/nuevoSocio")
	public String verFormSocio (Model model) {
		model.addAttribute("usuario", new Usuario());
		
		return "registroSocioManualmente";
	}
	
	
	@PostMapping("/nuevoSocio/submit")
	public String submitSocio (Usuario usuario, Model model) {
		
		usuarioService.save(usuario);
		return "redirect:/";
	}
	
}
