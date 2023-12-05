package com.springApi.springApi.Services;

import com.springApi.springApi.Entities.Results;

public abstract class AServices {
	
	/**
	 * Method to prepare result model for end point.
	 * @param <T>
	 * @param data
	 * @param isEmpty
	 * @return
	 */
	public <T> Results<T> getResultObject(T data, Boolean isEmpty){
		if(isEmpty) {
			return getResultObject(null, "No Data Found!", false);
		}
		else {
			return getResultObject(data, "", true);
		}
	}
	
	/**
	 * Overloaded method to prepare result model for end point.
	 * @param <T>
	 * @param Data
	 * @param message
	 * @param isSuccessfull
	 * @return
	 */
	private <T> Results<T> getResultObject(T Data, String message, Boolean isSuccessfull)
	{
		Results<T> result = new Results<T>();
		result.Data = Data;
		result.Message = message;
		result.IsSuccessfull = isSuccessfull;
		return result;
	}
}
