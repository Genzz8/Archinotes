package it.risolo.ArchiNotes.model.mappers;

import it.risolo.ArchiNotes.model.dto.UserDto;
import it.risolo.ArchiNotes.model.entity.UserEntity;

public class UserMapper {

	public static UserEntity mapUser(UserDto user) {
		
		UserEntity entity = new UserEntity();
		entity.setId(user.getId());
		entity.setUserName(user.getUserName());
		entity.setUserSurname(user.getUserSurname());
		entity.setPassword(user.getPassword());
		return entity;
		
	}
	
	
	public static UserDto mapUser(UserEntity user) {
		
		UserDto dto = new UserDto.Builder()
				.setId(user.getId())
				.setUserName(user.getUserName())
				.setUserSurname(user.getUserSurname())
				.build();
		return dto;
	}
	
}
