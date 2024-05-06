package com.salesianostriana.dam.FranciscoJoseAlcantarillaCaladoProyecto.model;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor @AllArgsConstructor
public class Socio {
	
	@Id @GeneratedValue
	private Long id;
	
	private String nombre;
	private String apellidos;
	private String telefono; 
	private String email;
	private String direccion; 
	private String provincia; 
	private String codigoPostal;
	private String dni;
	private String contrasenia;
	private String repetirContrasenia;
	
	@DateTimeFormat(iso = ISO.DATE_TIME)
	private LocalDate fechaDeNacimiento;
}
