package com.daniel.cursomc.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.daniel.cursomc.domain.Cliente;
import com.daniel.cursomc.repositories.ClienteRepository;
import com.daniel.cursomc.services.exceptions.ObjectNotFoundException;

@Service
public class ClienteService {
	
	@Autowired
	private ClienteRepository repo;
	
	public Cliente find(Integer id) {
		Cliente obj = repo.findOne(id);
		
		if(obj==null) {
			throw new ObjectNotFoundException("Objeto Não eoncontrado! " +
					id + ", Tipo " + Cliente.class.getName());
			}
		
		return obj;		
	}
	
}
