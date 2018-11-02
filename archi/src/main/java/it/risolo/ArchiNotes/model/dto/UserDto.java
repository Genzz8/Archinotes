package it.risolo.ArchiNotes.model.dto;

import java.io.Serializable;

public class UserDto implements Serializable {

	private static final long serialVersionUID = -1821171668569993577L;

	protected String id;
	protected String userName;
	protected String userSurname;
	protected String password;
	
	public UserDto() {
	}
	
	private UserDto(Builder builder){
		this.id = builder.id;
		this.userName = builder.userName;
		this.userSurname = builder.userSurname;
		this.password = builder.password;
	}
	
	public static class Builder {
		
		protected String id;
		protected String userName;
		protected String userSurname;
		protected String password;
		
		public Builder setId(String id) {
			this.id = id;
			return this;
		}
		
		public Builder setUserName(String userName) {
			this.userName = userName;
			return this;
		}
		
		public Builder setUserSurname(String userSurname) {
			this.userSurname = userSurname;
			return this;
		}
		
		public Builder setPassword(String password) {
			this.password = password;
			return this;
		}
		
		
		public UserDto build() {
			return new UserDto(this);
		}
		
		
	}
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserSurname() {
		return userSurname;
	}
	public void setUserSurname(String userSurname) {
		this.userSurname = userSurname;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
}
