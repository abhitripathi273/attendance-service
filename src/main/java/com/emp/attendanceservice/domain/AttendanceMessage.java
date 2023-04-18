package com.emp.attendanceservice.domain;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.Getter;
import lombok.Setter;

/**
 * This is message consumed from topic.
 * 
 * @author abhtripa
 */
@JsonAutoDetect
@JsonInclude(Include.NON_NULL)
@Getter
@Setter
public class AttendanceMessage implements Serializable {
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -8804895604743382724L;
	
	/** The emp id. */
	private Long empId;
	
	/** The attendance date. */
	private String attendanceDate;
	
	/** The total hours. */
	private Double totalHours;
}
