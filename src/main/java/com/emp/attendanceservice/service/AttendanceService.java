package com.emp.attendanceservice.service;

import com.emp.attendanceservice.domain.AttendanceDetailsRequest;
import com.emp.attendanceservice.domain.AttendanceMessage;
import com.emp.attendanceservice.domain.EmployeeAttendanceResponse;

/**
 * The Interface AttendanceService.
 */
public interface AttendanceService {
	
	/**
	 * Gets the attendance.
	 *
	 * @param request the request
	 * @return the attendance
	 */
	public EmployeeAttendanceResponse getAttendance(AttendanceDetailsRequest request);
	
	/**
	 * Process attendance message.
	 *
	 * @param msg the msg
	 */
	public void processAttendanceMessage(AttendanceMessage msg);
}
