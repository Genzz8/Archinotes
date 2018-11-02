package it.risolo.ArchiNotes.services.user;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import it.risolo.ArchiNotes.model.entity.UserEntity;
import it.risolo.ArchiNotes.repository.UserRepositories;

@Service
public class UserDetailsServiceImpl implements UserDetailsService{

	@Autowired
	private UserRepositories userRepo;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		UserEntity user = userRepo.findByUserName(username);
		if(user==null) {
			throw new UsernameNotFoundException(username);
		}
		return new User(user.getUserName(), user.getPassword(), new ArrayList<>());
	}

}
