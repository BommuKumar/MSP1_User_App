package com.naresh.Database.CustomException;

public class InvalidRole extends RuntimeException {
	
	public InvalidRole(String msg)
	{
		super(msg);
	}
	public InvalidRole(String msg,Throwable cause)
	{
		super(msg, cause);
	}
 
}
