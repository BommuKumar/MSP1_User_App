package com.naresh.Database.Configuration;

import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.springframework.context.annotation.Bean;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import com.naresh.Database.Dto.UserResponseDto;
import com.naresh.Database.Entity.User;
 

@Configuration
public class Config {
	
	@Bean
	 public AuthenticationManager getAuthenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception
	  {
		  return authenticationConfiguration.getAuthenticationManager();
	  }
	    @Bean
	    public PasswordEncoder passwordEncoder() {
	        return new BCryptPasswordEncoder();
	    }
	    
		@Bean
		SecurityFilterChain httpSecurity(HttpSecurity security) 
		{
			System.out.println("hi1");
			SecurityFilterChain filterChain=null;
			
			
			try {
				security.csrf(csrf->csrf.disable())
				        .cors(cors->cors.disable())
				        .authorizeHttpRequests(authorize->authorize.requestMatchers("/regsiter","/login","/get/**")
				        .permitAll()
				        .anyRequest()
				        .authenticated());
				       
				filterChain=security.build();
			}
		
			
			catch (Exception e) {
				e.printStackTrace();
			}
			
			return filterChain;
		}
		
		 @Bean
		    public ModelMapper modelMapper() {
		        ModelMapper modelMapper = new ModelMapper();
 
		        modelMapper.addMappings(new PropertyMap<User,UserResponseDto>() {
		            @Override
		            protected void configure() {
		                // Directly map authorities as Collection<GrantedAuthority>
		                map().setAuthorities(source.getAuthorities().stream().map(GrantedAuthority::getAuthority).collect(Collectors.toList()));
		            }
		        });

		        return modelMapper;
		    }
}
