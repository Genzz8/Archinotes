package it.risolo.ArchiNotes.document.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.risolo.ArchiNotes.document.dto.DocumentDto;
import it.risolo.ArchiNotes.document.entity.DocumentEntity;
import it.risolo.ArchiNotes.document.mapper.DocumentMapper;
import it.risolo.ArchiNotes.document.repository.DocumentRepository;

@Service
public class DocumentServiceImpl implements DocumentService{

	@Autowired
	private DocumentRepository docRepository;
	
	@Override
	public void insertDocument(DocumentDto document) {
		DocumentEntity entity = DocumentMapper.mapDocument(document);
		docRepository.save(entity);
	}

	@Override
	public List<DocumentDto> getDocumentsByUser(String userName) {
		List<DocumentDto> documents = new ArrayList<>();
		for(DocumentEntity entity : docRepository.findByUsername(userName)) {
			documents.add(DocumentMapper.mapDocument(entity));
		}
		return documents;
	}

	@Override
	public DocumentDto findByIdAndUsername(String id, String username) {
		DocumentEntity doc = docRepository.findByIdAndUsername(id, username);
		DocumentDto dto = DocumentMapper.mapDocument(doc);
		return dto;
	}
	
	

}
