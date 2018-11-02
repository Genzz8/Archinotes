package it.risolo.ArchiNotes.document.dto;

import java.io.Serializable;

public class Attachment implements Serializable {

	private static final long serialVersionUID = -4209055175071305339L;
	
	private byte[] attach;
	private String type;

	public Attachment() {
	}
	
	public Attachment(Builder builder) {
		this.attach=builder.attach;
		this.type=builder.type;
	}
	
	public static class Builder {
		private byte[] attach;
		private String type;

		public Builder setAttach(byte[] attach) {
			this.attach = attach;
			return this;
		}
		
		public Builder setType(String type) {
			this.type = type;
			return this;
		}
		
		public Attachment build() {
			return new Attachment(this);
		}
		
	}
	
	public byte[] getAttach() {
		return attach;
	}
	public void setAttach(byte[] attach) {
		this.attach = attach;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	
}
