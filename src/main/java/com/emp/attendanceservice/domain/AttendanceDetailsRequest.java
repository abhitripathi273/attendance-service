package com.emp.attendanceservice.domain;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.Getter;
import lombok.Setter;

/**
 * The Class AttendanceDetailsRequest.
 */
@JsonAutoDetect
@JsonInclude(Include.NON_NULL)
@Getter
@Setter
public class AttendanceDetailsRequest implements Serializable {
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -7774240603799019659L;
	
	/** The emp id. */
	private int empId;
	
	/** The attendance date. */
	private String attendanceDate;
}
