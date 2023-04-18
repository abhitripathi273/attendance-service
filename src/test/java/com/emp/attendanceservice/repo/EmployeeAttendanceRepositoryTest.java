package com.emp.attendanceservice.repo;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.emp.attendanceservice.entity.EmployeeAttendanceEntity;

/**
 * The Class EmployeeAttendanceRepositoryTest.
 */
@ExtendWith(SpringExtension.class)
@DataJpaTest
public class EmployeeAttendanceRepositoryTest {

	/** The entity manager. */
	@Autowired
	private TestEntityManager entityManager;

	/** The employee attendance repository. */
	@Autowired
	private EmployeeAttendanceRepository employeeAttendanceRepository;

	/**
	 * Entity manager is not null.
	 */
	@Test
	void entityManager_is_not_null() {
		assertThat(entityManager).isNotNull();
	}

	/**
	 * Testshould find no employee if repository is empty.
	 */
	@Test
	void testshould_find_no_employee_if_repository_is_empty() {
		EmployeeAttendanceEntity entity = new EmployeeAttendanceEntity();
		entity.setAttendanceDate("2023-04-06");
		entity.setEmpId(24234);
		entity.setTotalHours(8.5);
		entity.setStatus("PRESENT");
		employeeAttendanceRepository.save(entity);
		List<EmployeeAttendanceEntity> empAttendList = employeeAttendanceRepository.findAll();
		assertThat(empAttendList).isNotEmpty();
		assertThat(empAttendList.size()).isEqualTo(1);
	}

	/**
	 * Should return employee for emp id.
	 */
	@Test
	void should_return_employee_for_emp_id() {
		EmployeeAttendanceEntity entity = new EmployeeAttendanceEntity();
		entity.setAttendanceDate("2023-04-06");
		entity.setEmpId(24234);
		entity.setTotalHours(8.5);
		entity.setStatus("PRESENT");
		employeeAttendanceRepository.save(entity);
		List<EmployeeAttendanceEntity> empAttendList = employeeAttendanceRepository.findByEmpId(24234);
		assertThat(empAttendList).isNotNull();
		assertThat(empAttendList.size()).isEqualTo(1);
	}

	/**
	 * Should return employee for emp id and attendance date.
	 */
	@Test
	void should_return_employee_for_emp_id_and_attendance_date() {
		EmployeeAttendanceEntity entity = new EmployeeAttendanceEntity();
		entity.setAttendanceDate("2023-04-06");
		entity.setEmpId(24234);
		entity.setTotalHours(8.5);
		entity.setStatus("PRESENT");
		employeeAttendanceRepository.save(entity);
		Optional<EmployeeAttendanceEntity> empAttedOptional = employeeAttendanceRepository
				.findByEmpIdAndAttendanceDate(24234, "2023-04-06");
		assertTrue(empAttedOptional.isPresent());
		assertThat(empAttedOptional.get()).isNotNull();
		assertThat(empAttedOptional.get().getEmpId()).isEqualTo(24234);
		assertThat(empAttedOptional.get().getAttendanceDate()).isEqualTo("2023-04-06");
	}
}
