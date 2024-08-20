package com.naresh.Database.Entity;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name="User7")
public class User implements UserDetails{
	
	@Id
	@SequenceGenerator(name = "user7_seq_gen",sequenceName = "user7_seq",allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "user7_seq_gen")
	private int userId;
	
	@Column(name="user_name")
	private String name;
	
	@Column(name="pass_word")
	private String pass;
	
	private String role;
	
	private Integer doctorId;
	
	private Integer  patientId;
	
	private LocalDate createdAt;
	
	private LocalDate  updatedAt;

	 

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		 
	    Collection<GrantedAuthority> authorities = new ArrayList<>(); // Initialize to avoid null
		
	    if (this.role != null) {
	        authorities.add(new SimpleGrantedAuthority(this.role));
	    }
		return  authorities;
	}

	@Override
	public String getPassword() {

		return this.pass;
	}




	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return this.name;
	}
	
	 

	public User(int userId, String name, String pass, String role, Integer doctorId, Integer patientId,
			LocalDate createdAt, LocalDate updatedAt) {
		super();
		this.userId = userId;
		this.name = name;
		this.pass = pass;
		this.role = role;
		this.doctorId = doctorId;
		this.patientId = patientId;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
	}




	@Override
	public String toString() {
		return "User [userId=" + userId + ", name=" + name + ", pass=" + pass + ", role=" + role + ", doctorId="
				+ doctorId + ", patientId=" + patientId + ", createdAt=" + createdAt + ", updatedAt=" + updatedAt + "]";
	}




	public User() {
		super();
	}

	 

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}
 
 
	public String getName() {
		return name;
	}




	public void setName(String name) {
		this.name = name;
	}




	public String getPass() {
		return pass;
	}




	public void setPass(String pass) {
		this.pass = pass;
	}




	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public Integer getDoctorId() {
		return doctorId;
	}

	public void setDoctorId(Integer doctorId) {
		this.doctorId = doctorId;
	}

	public Integer getPatientId() {
		return patientId;
	}

	public void setPatientId(Integer patientId) {
		this.patientId = patientId;
	}

	public LocalDate getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(LocalDate createdAt) {
		this.createdAt = createdAt;
	}

	public LocalDate getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(LocalDate updatedAt) {
		this.updatedAt = updatedAt;
	}


 
}
 
