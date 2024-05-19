package com.salesianostriana.dam.FranciscoJoseAlcantarillaCaladoProyecto.controller;





import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


import com.salesianostriana.dam.FranciscoJoseAlcantarillaCaladoProyecto.model.Usuario;



@Controller
public class VentaController {


	


	@GetMapping("/Ventas")
    public String misVentas(@AuthenticationPrincipal Usuario usuario , Model model) {
        model.addAttribute("usuario", new Usuario());
        model.addAttribute("ventas", usuario.getVenta());
        return "misVentas";
    }
	
	

	
	
}


