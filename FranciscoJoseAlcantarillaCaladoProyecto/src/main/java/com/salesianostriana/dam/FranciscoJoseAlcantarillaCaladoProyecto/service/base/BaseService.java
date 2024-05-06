package com.salesianostriana.dam.FranciscoJoseAlcantarillaCaladoProyecto.service.base;

import java.util.List;
import java.util.Optional;

public interface BaseService <T, ID> {

	//La t es el tipo de entidad, alumno, producto etc
		//La id  es el tipo del identifacador
		
		List<T> findAll();
		
		Optional<T> findById(ID id);
		
		T save(T t);
		
		T edit(T t);
		
		void delete(T t);
		
		void deleteById(ID id);
		
}
