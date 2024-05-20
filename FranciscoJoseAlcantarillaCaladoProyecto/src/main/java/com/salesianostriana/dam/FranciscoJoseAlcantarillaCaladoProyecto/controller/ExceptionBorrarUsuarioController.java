package com.salesianostriana.dam.FranciscoJoseAlcantarillaCaladoProyecto.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.salesianostriana.dam.FranciscoJoseAlcantarillaCaladoProyecto.exceptions.ExceptionBorrarUsuario;

@ControllerAdvice
public class ExceptionBorrarUsuarioController {

	  @ExceptionHandler(ExceptionBorrarUsuario.class)
	    public String exceptionBorrarUsuario(Model model, ExceptionBorrarUsuario exBorrarUsuario) {
	        model.addAttribute("errorUsuario", exBorrarUsuario.getMessage());
	        return "redirect:/admin/sociosAdmin?error=true";
	    }
	
	
}
