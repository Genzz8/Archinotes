package it.risolo.ArchiNotes.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@EnableWebMvc
@Configuration
public class WebConfiguration implements WebMvcConfigurer {
	
	
	public ViewResolver viewResolver() {
		
		InternalResourceViewResolver bean = new InternalResourceViewResolver();
		bean.setPrefix("/WEB-INF.view");
		bean.setSuffix(".html");
		
		return bean;
	}


}
