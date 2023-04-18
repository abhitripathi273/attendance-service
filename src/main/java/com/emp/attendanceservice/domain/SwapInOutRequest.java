package com.emp.attendanceservice.domain;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.Getter;
import lombok.Setter;

/**
 * The Class SwapInOutRequest.
 */
@JsonAutoDetect
@JsonInclude(Include.NON_NULL)
@Getter
@Setter
public class SwapInOutRequest implements Serializable {
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 2819467723106269065L;
	
	/** The emp id. */
	private String empId;
	
	/** The date time. */
	private String dateTime;
}
