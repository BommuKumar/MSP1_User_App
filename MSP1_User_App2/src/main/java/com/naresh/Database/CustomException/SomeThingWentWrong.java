package com.naresh.Database.CustomException;

public class SomeThingWentWrong extends RuntimeException {
	
	public SomeThingWentWrong(String msg)
	{
		super(msg);
	}
	public SomeThingWentWrong(String msg,Throwable cause)
	{
		super(msg, cause);
	}
}
