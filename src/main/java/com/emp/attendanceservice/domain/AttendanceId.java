package com.emp.attendanceservice.domain;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * This class provides the composite key (empId, attendanceDate) for
 * EmployeeAttendanceEntity.
 *
 * @author abhtripa
 */
@JsonAutoDetect
@JsonInclude(Include.NON_NULL)
@Getter
@Setter
@NoArgsConstructor

/**
 * Hash code.
 *
 * @return the int
 */
@EqualsAndHashCode
public class AttendanceId implements Serializable {
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 8618773166798371296L;
	
	/** The emp id. */
	private int empId;
	
	/** The attendance date. */
	private String attendanceDate;
}
