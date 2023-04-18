package com.emp.attendanceservice.common;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.Getter;
import lombok.Setter;

/**
 * This class is Validation Error for this service.
 * 
 * @author abhtripa
 */
@JsonAutoDetect
@JsonInclude(Include.NON_NULL)
@Getter
@Setter
public class ValidationError implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -1055110733387709630L;
	
	/** The error code. */
	private int errorCode;
	
	/** The error desc. */
	private String errorDesc;
	
	/**
	 * Instantiates a new validation error.
	 *
	 * @param msg the msg
	 */
	public ValidationError(String msg) {
		this.errorDesc = msg;
	}
	
	/**
	 * Instantiates a new validation error.
	 *
	 * @param errorCode the error code
	 * @param msg the msg
	 */
	public ValidationError(int errorCode, String msg) {
		this.errorDesc = msg;
		this.errorCode = errorCode;
	}
}
