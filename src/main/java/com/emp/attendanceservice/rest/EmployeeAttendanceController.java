package com.emp.attendanceservice.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.emp.attendanceservice.domain.AttendanceDetailsRequest;
import com.emp.attendanceservice.domain.EmployeeAttendanceResponse;
import com.emp.attendanceservice.service.AttendanceService;
import com.emp.attendanceservice.service.impl.KafkaProducer;

/**
 * This controller provides the api to get attendance details.
 * 
 * @author abhtripa
 */
@RestController
@RequestMapping(value = "/vz/attendance-service/v1")
public class EmployeeAttendanceController {

	/** The attendance service. */
	@Autowired
	private AttendanceService attendanceService;
	
	@Autowired
	private KafkaProducer kafkaProducer;
	
	/**
	 * Gets the attendance details.
	 *
	 * @param request the request
	 * @return the attendance details
	 */
	@PostMapping(value = "/emp/attendance/get", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public EmployeeAttendanceResponse getAttendanceDetails(@RequestBody AttendanceDetailsRequest request) {
		return attendanceService.getAttendance(request);
	}
	
	@PostMapping(value = "/emp/attendance/send", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public String sendAttendanceDetails(@RequestBody String message) {
		return kafkaProducer.sendMessage(message);
	}
}
