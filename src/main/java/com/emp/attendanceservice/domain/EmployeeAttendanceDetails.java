package com.emp.attendanceservice.domain;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.Getter;
import lombok.Setter;

/**
 * The Class EmployeeAttendanceDetails.
 */
@JsonAutoDetect
@JsonInclude(Include.NON_NULL)
@Getter
@Setter
public class EmployeeAttendanceDetails implements Serializable {
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -8061948961586901626L;

	/** The emp id. */
	private int empId;
	
	/** The attendance date. */
	private String attendanceDate;
	
	/** The total hours. */
	private Double totalHours;
	
	/** The status. */
	private String status;
	
	/** The day. */
	private String day;
}
