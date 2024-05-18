package com.salesianostriana.dam.FranciscoJoseAlcantarillaCaladoProyecto.controller;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.salesianostriana.dam.FranciscoJoseAlcantarillaCaladoProyecto.model.Usuario;
import com.salesianostriana.dam.FranciscoJoseAlcantarillaCaladoProyecto.model.Venta;
import com.salesianostriana.dam.FranciscoJoseAlcantarillaCaladoProyecto.service.UsuarioService;


@Controller
public class VentaController {

	@Autowired
	private UsuarioService usuarioService;
	
	@GetMapping("/Ventas")
    public String misVentas(@AuthenticationPrincipal Usuario usuario , Model model) {
		List<Venta> ventas = usuarioService.getVentasPorUsuario(usuario);
        model.addAttribute("ventas", ventas);
        return "misVentas";
    }
	
	

	
	
}


