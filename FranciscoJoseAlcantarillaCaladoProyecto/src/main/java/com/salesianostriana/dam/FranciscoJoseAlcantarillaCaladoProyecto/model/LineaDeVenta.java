package com.salesianostriana.dam.FranciscoJoseAlcantarillaCaladoProyecto.model;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Builder
public class LineaDeVenta {

	@Id @GeneratedValue
	private Long id; 
	
	private int cantidadProducto;
	private double subTotal;
	
	
	@ManyToOne
	private Venta venta;
	
}
