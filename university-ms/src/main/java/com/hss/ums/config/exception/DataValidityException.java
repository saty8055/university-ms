package com.hss.ums.config.exception;

/**
 * @descrition Exception to be thrown if wrong data presented to server..
 * */
@SuppressWarnings("serial")
public class DataValidityException extends Exception{

	public DataValidityException(String message) {
		super(message);
	}
	
}
