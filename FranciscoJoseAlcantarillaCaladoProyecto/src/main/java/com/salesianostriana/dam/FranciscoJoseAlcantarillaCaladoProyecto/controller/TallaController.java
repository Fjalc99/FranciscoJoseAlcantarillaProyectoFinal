package com.salesianostriana.dam.FranciscoJoseAlcantarillaCaladoProyecto.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
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
	public String submitTalla (@ModelAttribute("talla") Talla talla) {
		tallaService.save(talla);
		return "redirect:/admin/tallasAdmin";
	}
	
	
	@GetMapping("/editarTalla/{id}")
	public String verEditarTalla (@PathVariable("id") Long id, Model model) {

		Optional<Talla> tEditar = tallaService.findById(id); 
		if (tEditar.isPresent()) {
			model.addAttribute("talla", tEditar.get());
			return "/admin/formularioVariante";
		}else {
			return "redirect:/admin/tallasAdmin";
		}
	}
	
	@PostMapping("/editarTalla/submit")
	public String verInformacionEditada (@ModelAttribute("talla")Talla t) {
		tallaService.edit(t);
		return"redirect:/admin/tallasAdmin";
	}
	
	
	
	   @GetMapping("/borrarTalla/{id}")
	    public String borrarTalla(@PathVariable("id") Long id) {
	        Optional<Talla> optionalTalla = tallaService.findById(id);
	        
	        if (optionalTalla.isPresent()) {
	            Talla tallaEncontrada = optionalTalla.get();
	            
	            if (tallaService.countProductosByTalla(tallaEncontrada.getId()) == 0) {
	                tallaService.delete(tallaEncontrada);
	            } else {
	                return "redirect:/admin/tallasAdmin?error=true";
	            }
	        }
	        
	        return "redirect:/admin/tallasAdmin";
	    }
	
}
