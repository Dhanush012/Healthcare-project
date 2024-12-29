package com.project.PatientManagement.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.project.PatientManagement.model.PatientUser;
import com.project.PatientManagement.model.UserPrincipal;
import com.project.PatientManagement.repository.UserRepo;

@Service
public class MyUserDetailsService implements UserDetailsService{

	@Autowired
	private UserRepo repo;
	
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		PatientUser user = repo.findByUsername(username);
		
		if(user == null) {
			throw new UsernameNotFoundException("Not found username");
		}
		return new UserPrincipal(user); 
	}
}
