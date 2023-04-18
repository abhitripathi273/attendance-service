package com.emp.attendanceservice.repo;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.emp.attendanceservice.entity.EmployeeAttendanceEntity;

/**
 * Repository for EmployeeAttendanceEntity.
 * 
 * @author abhtripa
 */
@Repository
public interface EmployeeAttendanceRepository extends JpaRepository<EmployeeAttendanceEntity, Long> {
	
	/**
	 * Find by emp id and attendance date.
	 *
	 * @param empId the emp id
	 * @param attendanceDate the attendance date
	 * @return the optional
	 */
	public Optional<EmployeeAttendanceEntity> findByEmpIdAndAttendanceDate(@Param("empId") int empId,
			@Param("attendanceDate") String attendanceDate);

	/**
	 * Find by emp id.
	 *
	 * @param empId the emp id
	 * @return the list
	 */
	public List<EmployeeAttendanceEntity> findByEmpId(@Param("empId") int empId);
}
