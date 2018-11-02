package it.risolo.ArchiNotes.services.user;

import java.util.List;

import it.risolo.ArchiNotes.model.dto.UserDto;

public interface UserService {

	List<UserDto> findUserByName(String name);
	
	void insertUser(UserDto user);
	
}
