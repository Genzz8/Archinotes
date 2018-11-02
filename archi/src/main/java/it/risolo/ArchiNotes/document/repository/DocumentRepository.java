package it.risolo.ArchiNotes.document.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import it.risolo.ArchiNotes.document.entity.DocumentEntity;

@Repository
public interface DocumentRepository extends MongoRepository<DocumentEntity, String>{

	@Query(fields="{username:1, title:1}")
	List<DocumentEntity> findByUsername(String username);
	
	DocumentEntity findByIdAndUsername(String id, String username);
	
}
