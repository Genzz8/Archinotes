package it.risolo.ArchiNotes.document.dto;

import java.io.Serializable;

public class DocumentDto implements Serializable {

	private static final long serialVersionUID = 7053737109310820123L;

	private String id;
	private String username;
	private String title;
	private String documentText;
	private Attachment attachment;
	
	public DocumentDto() {
	}
	
	public DocumentDto(Builder builder) {
		this.id = builder.id;
		this.username = builder.username;
		this.title = builder.title;
		this.attachment = builder.attachment;
		this.documentText = builder.documentText;
	}
	
	public static class Builder {
		
		private String id;
		private String username;
		private String documentText;
		private Attachment attachment;
		private String title;
		
		public Builder setId(String id) {
			this.id = id;
			return this;
		}
		
		public Builder setUsername(String username) {
			this.username = username;
			return this;
		}
		
		public Builder setTitle(String title) {
			this.title = title;
			return this;
		}

		public Builder setDocumentText(String documentText) {
			this.documentText = documentText;
			return this;
		}
		
		public Builder setAttachment(Attachment attachment) {
			this.attachment = attachment;
			return this;
		}
		
		public DocumentDto build() {
			return new DocumentDto(this);
		}
		
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getDocumentText() {
		return documentText;
	}

	public void setDocumentText(String documentText) {
		this.documentText = documentText;
	}

	public Attachment getAttachment() {
		return attachment;
	}

	public void setAttachment(Attachment attachment) {
		this.attachment = attachment;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
	
	
	
}
