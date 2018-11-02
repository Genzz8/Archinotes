package it.risolo.ArchiNotes.services.user;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.risolo.ArchiNotes.model.dto.UserDetails;
import it.risolo.ArchiNotes.model.dto.UserDto;
import it.risolo.ArchiNotes.model.entity.UserEntity;
import it.risolo.ArchiNotes.model.mappers.UserMapper;
import it.risolo.ArchiNotes.repository.UserRepositories;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepositories userRepo;
	
	@Override
	public List<UserDto> findUserByName(String name) {
		
		List<UserEntity> users = userRepo.findByUserNameContaining(name);
					
		List<UserDto> dtoUsers = new ArrayList<>();
		for(UserEntity entity : users) {
			UserDto user = UserMapper.mapUser(entity);
			dtoUsers.add(user);
		}
		return dtoUsers;
	}

	@Override
	public void insertUser(UserDto user) {
		UserEntity userEntity = UserMapper.mapUser(user);
		userRepo.save(userEntity);
	}

}
