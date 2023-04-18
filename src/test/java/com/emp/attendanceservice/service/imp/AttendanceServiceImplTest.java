package com.emp.attendanceservice.service.imp;

import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.emp.attendanceservice.domain.AttendanceDetailsRequest;
import com.emp.attendanceservice.domain.AttendanceMessage;
import com.emp.attendanceservice.domain.EmployeeAttendanceResponse;
import com.emp.attendanceservice.entity.EmployeeAttendanceEntity;
import com.emp.attendanceservice.entity.EmployeeEntity;
import com.emp.attendanceservice.mapper.AttendanceMapper;
import com.emp.attendanceservice.repo.EmployeeAttendanceRepository;
import com.emp.attendanceservice.repo.EmployeeRepository;
import com.emp.attendanceservice.service.impl.AttendanceServiceImpl;

/**
 * The Class AttendanceServiceImplTest.
 */
@SpringBootTest
class AttendanceServiceImplTest {

	/** The attendance service impl. */
	@InjectMocks
	private AttendanceServiceImpl attendanceServiceImpl;

	/** The emp attendance repo. */
	@Mock
	private EmployeeAttendanceRepository empAttendanceRepo;

	/** The employee repo. */
	@Mock
	private EmployeeRepository employeeRepo;

	/** The mapper. */
	@Mock
	private AttendanceMapper mapper;

	/**
	 * Test process attendance message absent.
	 */
	@Test
	void testProcessAttendanceMessage_Absent() {
		attendanceServiceImpl.processAttendanceMessage(buildAttendanceMessage(12345L, "2023-03-31", 3.8));
	}

	/**
	 * Test process attendance message half day.
	 */
	@Test
	void testProcessAttendanceMessage_HalfDay() {
		attendanceServiceImpl.processAttendanceMessage(buildAttendanceMessage(12345L, "2023-03-31", 6.3));
	}

	/**
	 * Test process attendance message present.
	 */
	@Test
	void testProcessAttendanceMessage_Present() {
		attendanceServiceImpl.processAttendanceMessage(buildAttendanceMessage(12345L, "2023-03-31", 8.2));
	}

	/**
	 * Test get attendance.
	 */
	@Test
	void testGetAttendance() {
		AttendanceDetailsRequest request = new AttendanceDetailsRequest();
		request.setEmpId(123456);
		request.setAttendanceDate("2023-03-31");
		EmployeeAttendanceEntity empEntity = new EmployeeAttendanceEntity();
		empEntity.setEmpId(123456);
		empEntity.setAttendanceDate("2023-03-31");
		empEntity.setTotalHours(8.6);
		empEntity.setStatus("PRESENT");
		EmployeeEntity emp = new EmployeeEntity();
		emp.setFirstName("AJAY");
		emp.setFirstName("YADAV");
		emp.setEmpId(123456);
		emp.setAge(32);
		emp.setEmail("test@gmail.com");
		when(employeeRepo.findByEmpId(anyInt())).thenReturn(Optional.ofNullable(emp));
		when(empAttendanceRepo.findByEmpIdAndAttendanceDate(anyInt(), anyString()))
				.thenReturn(Optional.ofNullable(empEntity));
		EmployeeAttendanceResponse response = attendanceServiceImpl.getAttendance(request);
		Assertions.assertNotNull(response);
		Assertions.assertNotNull(response.getStatus());
	}

	/**
	 * Test get attendance details not found.
	 */
	@Test
	void testGetAttendanceDetailsNotFound() {
		AttendanceDetailsRequest request = new AttendanceDetailsRequest();
		request.setEmpId(123456);
		request.setAttendanceDate("2023-03-31");
		EmployeeEntity emp = new EmployeeEntity();
		emp.setFirstName("AJAY");
		emp.setFirstName("YADAV");
		emp.setEmpId(123456);
		emp.setAge(32);
		emp.setEmail("test@gmail.com");
		when(employeeRepo.findByEmpId(anyInt())).thenReturn(Optional.ofNullable(emp));
		when(empAttendanceRepo.findByEmpIdAndAttendanceDate(anyInt(), anyString())).thenReturn(Optional.empty());
		EmployeeAttendanceResponse response = attendanceServiceImpl.getAttendance(request);
		Assertions.assertNotNull(response);
		Assertions.assertNotNull(response.getStatus());
	}

	/**
	 * Test get attendance empty list.
	 */
	@Test
	void testGetAttendanceEmptyList() {
		AttendanceDetailsRequest request = new AttendanceDetailsRequest();
		request.setEmpId(123456);
		request.setAttendanceDate("2023-03-31");
		when(empAttendanceRepo.findByEmpIdAndAttendanceDate(anyInt(), anyString())).thenReturn(Optional.empty());
		EmployeeAttendanceResponse response = attendanceServiceImpl.getAttendance(request);
		Assertions.assertNotNull(response);
		Assertions.assertNotNull(response.getStatus());
	}

	/**
	 * Test get attendance exception.
	 */
	@Test
	void testGetAttendanceException() {
		AttendanceDetailsRequest request = new AttendanceDetailsRequest();
		request.setEmpId(123456);
		request.setAttendanceDate("2023-03-31");

		EmployeeEntity emp = new EmployeeEntity();
		emp.setFirstName("AJAY");
		emp.setFirstName("YADAV");
		emp.setEmpId(123456);
		emp.setAge(32);
		emp.setEmail("test@gmail.com");
		when(employeeRepo.findByEmpId(anyInt())).thenReturn(Optional.ofNullable(emp));

		when(empAttendanceRepo.findByEmpIdAndAttendanceDate(anyInt(), anyString())).thenThrow(RuntimeException.class);

		EmployeeAttendanceResponse response = attendanceServiceImpl.getAttendance(request);
		Assertions.assertNotNull(response);
		Assertions.assertNotNull(response.getStatus());
	}

	/**
	 * Builds the attendance message.
	 *
	 * @param empId the emp id
	 * @param date the date
	 * @param totalHours the total hours
	 * @return the attendance message
	 */
	private AttendanceMessage buildAttendanceMessage(long empId, String date, double totalHours) {
		AttendanceMessage msg = new AttendanceMessage();
		msg.setEmpId(empId);
		msg.setAttendanceDate(date);
		msg.setTotalHours(totalHours);
		return msg;
	}
}
