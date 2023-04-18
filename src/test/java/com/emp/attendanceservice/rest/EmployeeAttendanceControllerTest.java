package com.emp.attendanceservice.rest;

import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.emp.attendanceservice.domain.AttendanceDetailsRequest;
import com.emp.attendanceservice.domain.EmployeeAttendanceResponse;
import com.emp.attendanceservice.service.AttendanceService;

/**
 * The Class EmployeeAttendanceControllerTest.
 */
@SpringBootTest
class EmployeeAttendanceControllerTest {

	/** The employee attendance controller. */
	@InjectMocks
	private EmployeeAttendanceController employeeAttendanceController;
	
	/** The attendance servcie. */
	@Mock
	private AttendanceService attendanceServcie;

	/**
	 * Test.
	 */
	@Test
	void test() {
		AttendanceDetailsRequest request = new AttendanceDetailsRequest();
		request.setAttendanceDate("2023-03-29");
		request.setEmpId(123444);
		EmployeeAttendanceResponse response = new EmployeeAttendanceResponse();
		when(attendanceServcie.getAttendance(request)).thenReturn(response);
		response = employeeAttendanceController.getAttendanceDetails(request);
		Assertions.assertNotNull(response);
	}
}
