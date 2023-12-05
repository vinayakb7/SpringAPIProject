package com.springApi.springApi.Entities;

class Result {
	
	public Boolean IsSuccessfull;

    public String Message;
}

public class Results<T> extends Result {
	
	public T Data;
}