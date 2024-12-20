package com.salesianostriana.dam.FranciscoJoseAlcantarillaCaladoProyecto.model;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
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
public class Talla {

	@Id @GeneratedValue
	private Long id;
	
	private String nombreTalla;


	@ToString.Exclude
	@EqualsAndHashCode.Exclude
	@ManyToMany(mappedBy="tallas", fetch=FetchType.EAGER)
	@Builder.Default
	private List <Producto> productos = new ArrayList <> ();
	
	

}
