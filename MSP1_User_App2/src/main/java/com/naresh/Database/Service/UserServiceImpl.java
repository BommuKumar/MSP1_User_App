package com.naresh.Database.Service;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.naresh.Database.FeignClient.DoctorFeignClient;
import com.naresh.Database.FeignClient.PatientFeignClients;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.naresh.Database.CustomException.InvalidRole;
import com.naresh.Database.CustomException.RoleNotFound;
import com.naresh.Database.Dto.DoctorDto;
import com.naresh.Database.Dto.PatientDto;
import com.naresh.Database.Dto.UserDto;
import com.naresh.Database.Entity.User;
import com.naresh.Database.Repository.UserRepository;

import java.time.LocalDate;

import org.modelmapper.ModelMapper;
@Service
public class UserServiceImpl implements UserService,UserDetailsService {
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	 PatientFeignClients patientFeignClients;
	
	@Autowired
	DoctorFeignClient doctorFeignClient;
	
	@Autowired
	 private PasswordEncoder passwordEncoder;

	@Override
	public String UserRegister(UserDto userDto) {
		 
		System.out.println(userDto.getPass());
		 
		ModelMapper modelMapper=new ModelMapper();
		
		User user=modelMapper.map(userDto, User.class);
		
		System.out.println(user.getPassword());
		
		user.setPass(passwordEncoder.encode(user.getPassword()));
		
		if(userDto.getRole()==null)
		{
			throw new RoleNotFound("Role not found please Enter your role");
		}
		
		if(userDto.getRole().equalsIgnoreCase("patient"))
		{
			
			PatientDto patientDto=userDto.getPatientDto();
			
			
			patientDto.setName(userDto.getName());
			
		    int patientId=patientFeignClients.createPatient(patientDto).getBody();	
		     
		     
		    user.setCreatedAt(LocalDate.now());
		    user.setUpdatedAt(LocalDate.now());
		    user.setPatientId(patientId);
		  
		    User savedUser=userRepository.save(user);
		    
		    return "Registered sucessfully with User Id"+savedUser.getUserId();
		}
		if(userDto.getRole().equalsIgnoreCase("Doctor"))
		{
			
			DoctorDto  doctorDto=userDto.getDoctorDto();
			
			doctorDto.setName(userDto.getName());
			
			int doctorId=doctorFeignClient.createDoctor(doctorDto).getBody();
			
			  
		    user.setCreatedAt(LocalDate.now());
		    user.setUpdatedAt(LocalDate.now());
		    user.setDoctorId(doctorId);
		    User savedUser=userRepository.save(user);
 			
		    return "Registered sucessfully with User Id"+savedUser.getUserId();
		}
		else
		{
		 throw 	new InvalidRole("invalid role plesase select valid Role");
		}
		 
	}

	@Override
	public User loadUserByUsername(String username) {


		User user=userRepository.findByName(username).orElseThrow(()->new UsernameNotFoundException("user not found with this name "+username));
		
	return user;
	}

}
