package com.daniel.cursomc.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.daniel.cursomc.domain.Categoria;
import com.daniel.cursomc.repositories.CategoriaRepository;
import com.daniel.cursomc.services.exceptions.ObjectNotFoundException;

@Service
public class CategoriaService {
	
	@Autowired
	private CategoriaRepository repo;
	
	public Categoria find(Integer id) {
		Categoria obj = repo.findOne(id);
		
		if(obj==null) {
			throw new ObjectNotFoundException("Objeto Não eoncontrado! " +
					id + ", Tipo " + Categoria.class.getName());
			}
		
		return obj;
	}
	
	public Categoria insert(Categoria obj) {
		obj.setId(null); // Quando é nulo cadastra, quando houver update 
		return repo.save(obj);
	}
	
	public Categoria update(Categoria obj) {
		find(obj.getId());

		return repo.save(obj);
	}
	
}
