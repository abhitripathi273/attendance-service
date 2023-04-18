package com.emp.attendanceservice.mapper;


import org.mapstruct.Mapper;

import com.emp.attendanceservice.domain.AttendanceMessage;
import com.emp.attendanceservice.domain.EmployeeAttendanceDetails;
import com.emp.attendanceservice.entity.EmployeeAttendanceEntity;


/**
 * The Interface AttendanceMapper.
 */
@Mapper(componentModel = "spring")
public interface AttendanceMapper {
	
	/**
	 * Map domain to entity.
	 *
	 * @param msg the msg
	 * @return the employee attendance entity
	 */
	EmployeeAttendanceEntity mapDomainToEntity(AttendanceMessage msg);

	/**
	 * Map entity to domain.
	 *
	 * @param empAttenEntity the emp atten entity
	 * @return the employee attendance details
	 */
	EmployeeAttendanceDetails mapEntityToDomain(EmployeeAttendanceEntity empAttenEntity);
}
