package com.naresh.Database.CustomException;

public class RoleNotFound extends RuntimeException {
	
	public RoleNotFound(String msg)
	{
		super(msg);
	}
	public RoleNotFound(String msg,Throwable cause)
	{
		super(msg, cause);
	}


}
