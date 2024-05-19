package com.salesianostriana.dam.FranciscoJoseAlcantarillaCaladoProyecto.controller;



<<<<<<< HEAD


=======
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
>>>>>>> refs/remotes/origin/main
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


import com.salesianostriana.dam.FranciscoJoseAlcantarillaCaladoProyecto.model.Usuario;
<<<<<<< HEAD

=======
import com.salesianostriana.dam.FranciscoJoseAlcantarillaCaladoProyecto.model.Venta;
import com.salesianostriana.dam.FranciscoJoseAlcantarillaCaladoProyecto.service.UsuarioService;
>>>>>>> refs/remotes/origin/main


@Controller
public class VentaController {

<<<<<<< HEAD

	


=======
	@Autowired
	private UsuarioService usuarioService;
	
>>>>>>> refs/remotes/origin/main
	@GetMapping("/Ventas")
    public String misVentas(@AuthenticationPrincipal Usuario usuario , Model model) {
		List<Venta> ventas = usuarioService.getVentasPorUsuario(usuario);
        model.addAttribute("ventas", ventas);
        return "misVentas";
    }
	
	

	
	
}


