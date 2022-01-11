package com.cms.jwt.config.auth;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.cms.jwt.model.User;
import com.cms.jwt.repository.UserRepository;

import lombok.RequiredArgsConstructor;

//http://localhost:8787/login => 동작 X .formLogin().disable()
@Service
@RequiredArgsConstructor
public class PrincipalDetailsService implements UserDetailsService {
	
	private final UserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		System.out.println("PrincipalDetailsService의 loadUserByUsername");
		User userEntity = userRepository.findByUsername(username);
		System.out.println("userEntity: " + userEntity);
		return new PrincipalDetails(userEntity);
	}

}
