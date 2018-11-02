package it.risolo.ArchiNotes.user.utils;

import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

@Component
public class UserUtils {
	
	public String getCurrentUsername() throws Exception {
		
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		if (!(authentication instanceof AnonymousAuthenticationToken)) { 
			 return authentication.getName();
		}
		throw new Exception("User not in session");
	}
	
	
}
