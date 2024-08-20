package com.naresh.Database.Dto;

public class UserDto {
	
   private String name;
	
	private String pass;
	
	private String role;
	
	private PatientDto patientDto;
	 
	private DoctorDto doctorDto;
	
	

	 

 

	public PatientDto getPatientDto() {
		return patientDto;
	}

	public void setPatientDto(PatientDto patientDto) {
		this.patientDto = patientDto;
	}

	public DoctorDto getDoctorDto() {
		return doctorDto;
	}

	public void setDoctorDto(DoctorDto doctorDto) {
		this.doctorDto = doctorDto;
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

	public UserDto() {
		super();
	}

	@Override
	public String toString() {
		return "UserDto [name=" + name + ", pass=" + pass + ", role=" + role + ", patientDto=" + patientDto
				+ ", doctorDto=" + doctorDto + "]";
	}

	public UserDto(String name, String pass, String role, PatientDto patientDto, DoctorDto doctorDto) {
		super();
		this.name = name;
		this.pass = pass;
		this.role = role;
		this.patientDto = patientDto;
		this.doctorDto = doctorDto;
	}
 
	
	

}
