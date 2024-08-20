package com.naresh.Database.Dto;

public class loginDto {
	
	private String userName;
	
	private String passWord;

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassWord() {
		return passWord;
	}

	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}

	public loginDto(String userName, String passWord) {
		super();
		this.userName = userName;
		this.passWord = passWord;
	}

	public loginDto() {
		super();
	}

	@Override
	public String toString() {
		return "loginDto [userName=" + userName + ", passWord=" + passWord + "]";
	}
	
	

}
