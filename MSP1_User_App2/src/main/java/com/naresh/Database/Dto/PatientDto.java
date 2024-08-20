package com.naresh.Database.Dto;

import java.time.LocalDate;

public class PatientDto {
	
	private String name;
	
	private LocalDate dob;
	
	private String address;
	
	private String phoneNumber;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	private String email;
	
	private String gender;

 
	public PatientDto(String name, LocalDate dob, String address, String phoneNumber, String email, String gender) {
		super();
		this.name = name;
		this.dob = dob;
		this.address = address;
		this.phoneNumber = phoneNumber;
		this.email = email;
		this.gender = gender;
	}

	public PatientDto() {
		super();
	}

	public LocalDate getDob() {
		return dob;
	}

	public void setDob(LocalDate dob) {
		this.dob = dob;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	@Override
	public String toString() {
		return "PatientDto [name=" + name + ", dob=" + dob + ", address=" + address + ", phoneNumber=" + phoneNumber
				+ ", email=" + email + ", gender=" + gender + "]";
	}

	 
 
	
	
	
	
	 

}
