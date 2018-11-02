package it.risolo.ArchiNotes.document.mapper;

import it.risolo.ArchiNotes.document.dto.Attachment;
import it.risolo.ArchiNotes.document.dto.DocumentDto;
import it.risolo.ArchiNotes.document.entity.DocumentEntity;

public class DocumentMapper {

	
	public static DocumentDto mapDocument(DocumentEntity doc) {
		
		Attachment attach = null;
		if(doc.getAttachment() != null ) {
			attach = new Attachment.Builder()
					.setAttach(doc.getAttachment().getAttach())
					.setType(doc.getAttachment().getType())
					.build();
		}
		
		DocumentDto dto = new DocumentDto.Builder()
				.setId(doc.getId())
				.setAttachment(attach)
				.setDocumentText(doc.getDocumentText())
				.setUsername(doc.getUsername())
				.setTitle(doc.getTitle())
				.build();
		
		return dto;
	}
	
	
	public static DocumentEntity mapDocument(DocumentDto doc) {
		
		DocumentEntity entity = new DocumentEntity();
		
		if(doc.getAttachment() != null ) {
			entity.setAttachment(new Attachment.Builder()
					.setAttach(doc.getAttachment().getAttach())
					.setType(doc.getAttachment().getType())
					.build());
		}
		entity.setId(doc.getId());
		entity.setDocumentText(doc.getDocumentText());
		entity.setUsername(doc.getUsername());
		entity.setTitle(doc.getTitle());
		return entity;
	}
	
	
}
