package com.salesianostriana.dam.FranciscoJoseAlcantarillaCaladoProyecto.model;


import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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
@Builder
@Entity
@IdClass(LineaDeVentaPk.class)
public class LineaDeVenta {

	@Id @GeneratedValue
	private Long id; 
	
	private int cantidadProducto;
	private double subTotal;
	

	
	
	
	@ManyToOne
	@JoinColumn(foreignKey = @ForeignKey(name = "fk_lineadeventa_producto"))
	private Producto producto;
	
	@Id
	@ManyToOne
	private Venta venta;
	
	
	public double calcularSubtotal() {
		return producto.getPrecio() * cantidadProducto;
	}
}
