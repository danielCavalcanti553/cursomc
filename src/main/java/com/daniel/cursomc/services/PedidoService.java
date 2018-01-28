package com.daniel.cursomc.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.daniel.cursomc.domain.Pedido;
import com.daniel.cursomc.repositories.PedidoRepository;
import com.daniel.cursomc.services.exceptions.ObjectNotFoundException;

@Service
public class PedidoService {
	
	@Autowired
	private PedidoRepository repo;
	
	public Pedido buscar(Integer id) {
		Pedido obj = repo.findOne(id);
		
		if(obj==null) {
			throw new ObjectNotFoundException("Objeto Não eoncontrado! " +
					id + ", Tipo " + Pedido.class.getName());
			}
		
		return obj;
	}
	
}
