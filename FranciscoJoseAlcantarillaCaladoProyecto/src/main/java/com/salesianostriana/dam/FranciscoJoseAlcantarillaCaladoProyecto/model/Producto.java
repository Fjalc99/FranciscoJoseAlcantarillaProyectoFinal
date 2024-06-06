package com.salesianostriana.dam.FranciscoJoseAlcantarillaCaladoProyecto.model;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import jakarta.persistence.ForeignKey;

@Data 
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Builder
public class Producto {

	@Id @GeneratedValue
	private Long id;
	
	private String nombre;
	private String descripcion;
	private double precio;
	private String imagen;
	
	@ManyToOne
	@JoinColumn(foreignKey = @ForeignKey(name="fk_producto_categoria"))
	private Categoria categoria;
	
	@ManyToMany (fetch = FetchType.EAGER)
	@JoinTable(
				name = "Tiene",
				joinColumns = @JoinColumn (name = "producto_id"),
				inverseJoinColumns = @JoinColumn(name="talla_id")
			)
	@Builder.Default
	private List <Talla> tallas = new ArrayList <>();
	
	
	
	public void addCategoria(Categoria categoria) {
		this.categoria = categoria;
		categoria.getProductos().add(this);
	}
	
	public void deleteCategoria(Categoria categoria) {
		categoria.getProductos().remove(this);
		this.categoria = categoria;
		
	}
	
	
	public void addTalla(Talla t) {
		this.tallas.add(t);
		t.getProductos().add(this);
	}
	
	public void deleteTalla(Talla t) {
		t.getProductos().remove(this);
		this.tallas.remove(t);
		
	}
}
