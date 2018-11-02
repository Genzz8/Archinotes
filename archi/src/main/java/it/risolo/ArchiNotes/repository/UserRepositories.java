package it.risolo.ArchiNotes.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import it.risolo.ArchiNotes.model.entity.UserEntity;

@Repository
public interface UserRepositories extends MongoRepository<UserEntity, String>{
	
	List<UserEntity> findByUserNameContaining(String userName);
	
	UserEntity findByUserName(String username);
	
	
}
