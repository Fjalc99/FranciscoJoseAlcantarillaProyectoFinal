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

import com.salesianostriana.dam.FranciscoJoseAlcantarillaCaladoProyecto.exceptions.ExceptionBorrarUsuario;
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
		
		  if (usuarioService.noUserExistente(usuario.getUsername())) {
			  model.addAttribute("error", "El nombre de usuario ya existe.");
	            return "/admin/registroSocio";
	        } else {
	        	usuarioService.save(usuario);
	    		return "redirect:/admin/sociosAdmin";
	        }
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
		Optional<Usuario> optionalUsuario = usuarioService.findById(id);
        
        if (optionalUsuario.isPresent()) {
            Usuario usuarioEncontrado = optionalUsuario.get();
            
            if (usuarioService.countVentasByUsuario(usuarioEncontrado.getId()) == 0) {
                usuarioService.delete(usuarioEncontrado);
            } else {
            	
            	throw new ExceptionBorrarUsuario("No se puede borrar el usuario porque tiene ventas asociadas");
            }
        }
        
        return "redirect:/admin/sociosAdmin";
	}
	
	
	@GetMapping("/nuevoSocio")
	public String verFormSocio (Model model) {
		model.addAttribute("usuario", new Usuario());
		
		return "registroSocioManualmente";
	}
	
	
	 @PostMapping("/nuevoSocio/submit")
	    public String submitSocio(Usuario usuario, Model model) {
	        if (usuarioService.noUserExistente(usuario.getUsername())) {
	        	model.addAttribute("error", "El nombre de usuario ya existe.");
	            return "registroSocioManualmente";
	        } else {
	            usuarioService.save(usuario);
	            return "redirect:/";
	        }
	    }
	
}
