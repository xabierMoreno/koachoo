package com.app.koachoo.service;

import java.util.ArrayList;

import com.app.koachoo.dao.UserDao;
import com.app.koachoo.dto.UserDto;
import com.app.koachoo.repository.UserDaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class JwtUserDetailsService implements UserDetailsService {

	@Autowired
	private UserDaoRepository userDaoRepository;

	@Autowired
	private PasswordEncoder bcryptEncoder;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		UserDao user = userDaoRepository.findByUsername(username);
		if (user == null) {
			throw new UsernameNotFoundException("User not found with username: " + username);
		}
		return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(),
				new ArrayList<>());
	}

	public UserDao save(UserDto userDto) {
		UserDao newUser = new UserDao();
		newUser.setUsername(userDto.getUsername());
		newUser.setPassword(bcryptEncoder.encode(userDto.getPassword()));
		return userDaoRepository.save(newUser);
	}

}