package com.naresh.Database.Token;

import java.util.Calendar;
import java.util.Date;

import org.springframework.stereotype.Component;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Component
public class JwtToken {
	
	private static final String SCREATE_KRY="qwertyuiopasdfghjklasdfghjklzxcvbasdfghjklqwertyuiopzxcvb";
	
	public String createJwtToken(String userName,String roleName)
	{
		 Date now = new Date();
		Calendar calendar = Calendar.getInstance();
		
        calendar.setTime(now);
        calendar.add(Calendar.MINUTE, 5);
        Date expirationTime = calendar.getTime();
        
        
		  Claims claims=  Jwts.claims().setSubject(userName)
	              .setIssuer("UserApp")
					 .setAudience("User_App_Users")
					  .setIssuedAt(now)//payload
						 .setExpiration(expirationTime);
						
			   
	            claims.put("role", roleName);   // roles is list of Roles having only roleNames; i.e (admin,user) , not id
	        
	            
	             String token= Jwts.builder().setClaims(claims)
	              .signWith(SignatureAlgorithm.HS256, SCREATE_KRY)
	              .compact();
	           
	   return token; 
		
	}
	
	
	

}
