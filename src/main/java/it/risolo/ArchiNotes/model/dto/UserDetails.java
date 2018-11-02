package it.risolo.ArchiNotes.model.dto;

public class UserDetails extends UserDto {

	private static final long serialVersionUID = -5977486121569506853L;
	
	private String token;
	private String profileName;
	
	public UserDetails(TokenBuilder builder) {
		
		this.token = builder.token;
		this.profileName = builder.profileName;
		
		super.userName = builder.userName;
		super.userSurname = builder.userSurname;
	}
	
	public static class TokenBuilder extends Builder {
		
		private String token;
		private String profileName;
		
		public TokenBuilder setToken(String token) {
			this.token = token;
			return this;
		}
		
		public TokenBuilder setProfileName(String profileName) {
			this.profileName = profileName;
			return this;
		}
		
		public TokenBuilder setId(String id) {
			super.id = id;
			return this;
		}
		
		public TokenBuilder setUserName(String userName) {
			super.userName=userName;
			return this;
		}
		
		public TokenBuilder setUserSurname(String userSurname) {
			super.userSurname=userSurname;
			return this;
		}
		
		public TokenBuilder setPassword(String password) {
			super.password=password;
			return this;
		}
		
		public UserDetails build() {
			return new UserDetails(this);
		}
		
	}
	
	public String getProfileName() {
		return profileName;
	}
	public void setProfileName(String profileName) {
		this.profileName = profileName;
	}
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	
	
}
