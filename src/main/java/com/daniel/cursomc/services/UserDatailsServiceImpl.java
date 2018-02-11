package com.daniel.cursomc.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.daniel.cursomc.domain.Cliente;
import com.daniel.cursomc.repositories.ClienteRepository;
import com.daniel.cursomc.security.UserSS;

@Service
public class UserDatailsServiceImpl implements UserDetailsService{
	
	@Autowired
	private ClienteRepository repo;	
	
	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		
		Cliente cli = repo.findByEmail(email);
		if(cli==null) {
			throw new UsernameNotFoundException(email); 
		}
		
		return new UserSS(cli.getId(),cli.getEmail(),cli.getSenha(),cli.getPerfis());
	}

}
