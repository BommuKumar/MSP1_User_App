package com.naresh.Database;
import com.naresh.Database.Dto.loginDto;
import com.naresh.Database.Entity.User;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.naresh.Database.CustomException.InvalidRole;
import com.naresh.Database.CustomException.RoleNotFound;
import com.naresh.Database.CustomException.SomeThingWentWrong;
import com.naresh.Database.Dto.UserDto;
import com.naresh.Database.Dto.UserResponseDto;
import com.naresh.Database.Service.UserService;
import com.naresh.Database.Token.JwtToken;
import com.naresh.Database.Service.UserServiceImpl;
@RestController
public class UserController {

	@Autowired
	UserService userService;
	
	@Autowired
	JwtToken  jwtToken;
	
    @Autowired
	
	AuthenticationManager  authenticationManager;
    
    @Autowired
     UserServiceImpl userServiceImpl; 
    
    @Autowired
    ModelMapper modelMapper;
    
    @GetMapping(path="get/{user}")
	public ResponseEntity<UserResponseDto>  loadUserByUsername(@PathVariable("user")  String userName)
     {	 
		 
    	User user=userServiceImpl.loadUserByUsername(userName);
    	
    	 
    	
		return ResponseEntity.status(HttpStatus.OK).body(modelMapper.map(user, UserResponseDto.class));	
	 
	 
     }
    
    @ExceptionHandler(UsernameNotFoundException.class)
    public ResponseEntity<String> UsernameNotFoundExceptionHandler(UsernameNotFoundException ex)
	{
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getLocalizedMessage());

	}
    
	@PostMapping(path="regsiter")
	public ResponseEntity<String>  userRegister(@RequestBody UserDto userDto)
	{	
		try
		{
		return ResponseEntity.status(HttpStatus.OK).body(userService.UserRegister(userDto));	
		}
		catch(RoleNotFound ex)
		{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getLocalizedMessage());

		}
		catch(InvalidRole ex)
		{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getLocalizedMessage());

		}
		
	}
	
	@PostMapping("login")
	public ResponseEntity<String>  userLogin(@RequestBody loginDto loginDto)
	{	
		//Authentication  authentication;
         try
         {
        	 Authentication authentication=authenticationManager.authenticate(new  UsernamePasswordAuthenticationToken(loginDto.getUserName(),loginDto.getPassWord()));// internally i t calls loadUserName() from UUserDetailsService and checks
          
		   //Authentication authentications=SecurityContextHolder.getContext().getAuthentication();
      
		   
		   if(authentication.isAuthenticated())
		     {
			  
		    	
			 User user=(User) authentication.getPrincipal();
			
			String token =jwtToken.createJwtToken(user.getUsername(), user.getRole());
			
			 return ResponseEntity.status(HttpStatus.OK).header("Authorization", token).body("sucessfully loggedIn");
			
		     }
		    else
		    {
              throw new SomeThingWentWrong("something went wrong please try again");
		     }
          }
         catch(BadCredentialsException ex)
         {
          return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getLocalizedMessage());
         }
         catch(SomeThingWentWrong ex)
         {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getLocalizedMessage());
 
         }
		
	   
	}
}

