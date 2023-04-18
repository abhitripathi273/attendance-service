package com.emp.attendanceservice.service.impl;

import static com.emp.attendanceservice.constants.AttendanceConstants.ABSENT;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.emp.attendanceservice.constants.AttendanceConstants;
import com.emp.attendanceservice.domain.AttendanceDetailsRequest;
import com.emp.attendanceservice.domain.AttendanceMessage;
import com.emp.attendanceservice.domain.EmployeeAttendanceDetails;
import com.emp.attendanceservice.domain.EmployeeAttendanceResponse;
import com.emp.attendanceservice.entity.EmployeeAttendanceEntity;
import com.emp.attendanceservice.entity.EmployeeEntity;
import com.emp.attendanceservice.mapper.AttendanceMapper;
import com.emp.attendanceservice.repo.EmployeeAttendanceRepository;
import com.emp.attendanceservice.repo.EmployeeRepository;
import com.emp.attendanceservice.service.AttendanceService;
import com.emp.attendanceservice.utils.CommonUtils;

import lombok.extern.slf4j.Slf4j;

/**
 * This class provides implementation for AttendanceService.
 * 
 * @author abhtripa
 */
@Service
@Slf4j
public class AttendanceServiceImpl implements AttendanceService {

	/** The emp attendance repo. */
	@Autowired
	private EmployeeAttendanceRepository empAttendanceRepo;

	/** The employee repo. */
	@Autowired
	private EmployeeRepository employeeRepo;

	/** The mapper. */
	@Autowired
	private AttendanceMapper mapper;

	/**
	 * Get the attendance details of employee for given date.
	 *
	 * @param request the request
	 * @return the attendance
	 */
	@Override
	public EmployeeAttendanceResponse getAttendance(AttendanceDetailsRequest request) {
		EmployeeAttendanceResponse response = new EmployeeAttendanceResponse();
		try {

			Optional<EmployeeEntity> empOptional = employeeRepo.findByEmpId(request.getEmpId());

			if (empOptional.isPresent()) {
				EmployeeEntity employee = empOptional.get();
				response.setEmpId(employee.getEmpId());
				response.setFirstName(employee.getFirstName());
				response.setLastName(employee.getLastName());
				Optional<EmployeeAttendanceEntity> empAttendanceOptional = empAttendanceRepo
						.findByEmpIdAndAttendanceDate(request.getEmpId(), request.getAttendanceDate());
				EmployeeAttendanceDetails details = new EmployeeAttendanceDetails();
				if (empAttendanceOptional.isPresent()) {
					EmployeeAttendanceEntity empAttenEntity = empAttendanceOptional.get();
					details = mapper.mapEntityToDomain(empAttenEntity);
					details.setDay(getDay(request.getAttendanceDate()));
					response.setEmployeeAttendanceDetails(details);
				} else {
					details.setEmpId(request.getEmpId());
					details.setAttendanceDate(request.getAttendanceDate());
					details.setTotalHours(AttendanceConstants.ZERO_HOURS);
					details.setStatus(ABSENT);
					details.setDay(getDay(request.getAttendanceDate()));
					response.setEmployeeAttendanceDetails(details);
				}
				String msg = "Attendance details fetched successfully for empId: " + request.getEmpId();
				response.setStatus(CommonUtils.getServiceStatus(Boolean.TRUE));
				response.getStatus().setStatusMsg(msg);
			} else {
				response.setStatus(CommonUtils.getServiceStatus(Boolean.TRUE,
						"Employee not found for empId: " + request.getEmpId()));
			}
		} catch (Exception e) {
			String erroMsg = "Exception occurred, while fetching attendance details for empId: " + request.getEmpId()
					+ ", date: " + request.getAttendanceDate() + " exception is: " + e.getMessage();
			log.error(erroMsg);
			response.setStatus(CommonUtils.getServiceStatus(Boolean.FALSE, erroMsg));
			response.addValidationError(erroMsg);
		}

		return response;
	}

	/**
	 * Save the attendance status.
	 *
	 * @param msg the msg
	 */
	@Override
	public void processAttendanceMessage(AttendanceMessage msg) {
		try {
			EmployeeAttendanceEntity entity = mapper.mapDomainToEntity(msg);
			entity.setStatus(getAttendanceStatus(msg.getTotalHours()));
			empAttendanceRepo.save(entity);
			log.info("Attendance status saved successfully.");
		} catch (Exception e) {
			log.error("Exception occurred while processing AttendanceMessage, exception is: {}", e);
		}
	}

	/**
	 * Get day name form LocalDate.
	 *
	 * @param attendanceDate the attendance date
	 * @return String
	 */
	private String getDay(String attendanceDate) {
		LocalDate date = LocalDate.parse(attendanceDate);
		DayOfWeek dayName = date.getDayOfWeek();
		return dayName.toString();
	}

	/**
	 * Get attendance status for total hours for a day.
	 *
	 * @param totalHours - double
	 * @return String
	 */
	private String getAttendanceStatus(Double totalHours) {
		if (totalHours < AttendanceConstants.FOUR_HOURS) {
			return ABSENT;
		} else if (AttendanceConstants.FOUR_HOURS < totalHours && totalHours < AttendanceConstants.EIGHT_HOURS) {
			return AttendanceConstants.HALF_DAY;
		} else {
			return AttendanceConstants.PRESENT;
		}
	}

}
