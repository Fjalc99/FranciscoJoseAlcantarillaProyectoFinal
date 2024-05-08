package com.salesianostriana.dam.FranciscoJoseAlcantarillaCaladoProyecto.model;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor 
@AllArgsConstructor
@Entity
@Builder
public class Venta {

	
	@Id @GeneratedValue
	private Long id;
	
	private double Total;
	
	@ToString.Exclude
	@EqualsAndHashCode.Exclude
	@Builder.Default
	@OneToMany(
				mappedBy="venta",
				fetch = FetchType.EAGER,
				cascade = CascadeType.ALL,
				orphanRemoval = true
			)
	private List<LineaDeVenta> LineaDeVenta = new ArrayList <>();
	
	//Metodos Helper
	
	public void addLineDeVenta (LineaDeVenta LDV) {
		LDV.setVenta(this);
		this.LineaDeVenta.add(LDV);
	}
	
	public void removeLineaDeVenta (LineaDeVenta LDV) {
		this.LineaDeVenta.add(LDV);
		LDV.setVenta(null);
	}
	
	
	
}