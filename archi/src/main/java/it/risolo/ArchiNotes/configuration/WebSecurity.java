package it.risolo.ArchiNotes.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import it.risolo.ArchiNotes.configuration.security.CustomLogoutHandler;
import it.risolo.ArchiNotes.configuration.security.JWTAuthorizationFilter;
import it.risolo.ArchiNotes.configuration.security.JwtAuthenticationFilter;
import it.risolo.ArchiNotes.configuration.security.SecurityConstants;
import it.risolo.ArchiNotes.services.user.UserDetailsServiceImpl;

@EnableWebSecurity
@Order(1)
public class WebSecurity extends WebSecurityConfigurerAdapter{

	private UserDetailsServiceImpl userService;
	private BCryptPasswordEncoder psswdEncoder;
	
	public WebSecurity(UserDetailsServiceImpl userService, BCryptPasswordEncoder psswdEncoder) {
		this.userService = userService;
		this.psswdEncoder = psswdEncoder;
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
		 http.cors().and().csrf().disable().authorizeRequests()
         .antMatchers(HttpMethod.POST, SecurityConstants.SIGN_UP_URL).permitAll()
         .anyRequest().authenticated()
         .and()
	         .addFilter(new JwtAuthenticationFilter(authenticationManager()))
	         .addFilter(new JWTAuthorizationFilter(authenticationManager()))
	         .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
         .and()
	         .logout()
	         .logoutUrl("/logout")
	         .deleteCookies("JSESSIONID")
	         .logoutSuccessHandler(new CustomLogoutHandler())
	         .permitAll();
	}
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userService).passwordEncoder(psswdEncoder);
	}
	
	@Bean
	CorsConfigurationSource corsConfigurationSource() {
		final UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
		source.registerCorsConfiguration("/**", new CorsConfiguration().applyPermitDefaultValues());
		return source;
	}
	
}
