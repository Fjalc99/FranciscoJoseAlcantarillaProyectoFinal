package com.salesianostriana.dam.FranciscoJoseAlcantarillaCaladoProyecto.model;

import java.time.LocalDate;
import java.util.Collection;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@SuppressWarnings("serial")
@Data
@Entity
@NoArgsConstructor @AllArgsConstructor
@Builder
public class Usuario implements UserDetails {
	
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
	private String username;
	private String password;
	private boolean admin;
	
	@DateTimeFormat(iso = ISO.DATE)
	private LocalDate fechaDeNacimiento;
	
	
	
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		String role = "ROLE_";
		role += (admin) ? "ADMIN" : "USER";
		return List.of(new SimpleGrantedAuthority(role));
	}	

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}


}

