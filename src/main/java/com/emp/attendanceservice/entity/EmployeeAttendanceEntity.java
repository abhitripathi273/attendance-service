package com.emp.attendanceservice.entity;

import java.io.Serializable;
import java.util.Date;

import com.emp.attendanceservice.domain.AttendanceId;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

/**
 * This is entity class for EMPLOYEE_ATTENDANCE_DETAILS table.
 * 
 * @author abhtripa
 */

@Data
@Entity
@IdClass(AttendanceId.class)
@Table(name = "EMPLOYEE_ATTENDANCE_DETAILS")
@Getter
@Setter
public class EmployeeAttendanceEntity implements Serializable {
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 271501375976027266L;

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
	
	@Id
	@Column(name = "emp_id", nullable = false)
	private int empId;

	@Id
	@Column(name = "ATTENDANCE_DATE")
	private String attendanceDate;

	@Column(name = "TOTAL_HOURS", nullable = false)
	private Double totalHours;

	@Column(name = "STATUS", length = 10, nullable = false)
	private String status;
}
