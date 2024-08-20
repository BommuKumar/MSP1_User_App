package com.naresh.Database.Dto;

public class DoctorDto {
	
	private String name;

	private String specialization;
	
	private String phoneNumber;
	
	private String email;
 

	@Override
	public String toString() {
		return "DoctorDto [name=" + name + ", specialization=" + specialization + ", phoneNumber=" + phoneNumber
				+ ", email=" + email + "]";
	}

	public DoctorDto(String name, String specialization, String phoneNumber, String email) {
		super();
		this.name = name;
		this.specialization = specialization;
		this.phoneNumber = phoneNumber;
		this.email = email;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public DoctorDto() {
		super();
	}

	public String getSpecialization() {
		return specialization;
	}

	public void setSpecialization(String specialization) {
		this.specialization = specialization;
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
	 
}
 