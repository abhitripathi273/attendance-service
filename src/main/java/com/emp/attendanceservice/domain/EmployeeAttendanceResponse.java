package com.emp.attendanceservice.domain;

import java.io.Serializable;

import com.emp.attendanceservice.common.CommonResponse;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.Getter;
import lombok.Setter;

/**
 * The Class EmployeeAttendanceResponse.
 */
@JsonAutoDetect
@JsonInclude(Include.NON_NULL)
@Getter
@Setter
public class EmployeeAttendanceResponse extends CommonResponse implements Serializable {
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -2467170979130165113L;
	
	/** The emp id. */
	private int empId;
	
	/** The first name. */
	private String firstName;
	
	/** The last name. */
	private String lastName;
	
	/** The employee attendance details. */
	private EmployeeAttendanceDetails employeeAttendanceDetails;
}
