package it.risolo.ArchiNotes.document.service;

import java.util.List;

import it.risolo.ArchiNotes.document.dto.DocumentDto;


public interface DocumentService {

	void insertDocument(DocumentDto document);
	
	List<DocumentDto> getDocumentsByUser(String userName);
	
	DocumentDto findByIdAndUsername(String id, String username);
	
}
