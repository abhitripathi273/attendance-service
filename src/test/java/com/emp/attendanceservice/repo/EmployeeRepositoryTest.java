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

import com.emp.attendanceservice.entity.EmployeeEntity;

/**
 * The Class EmployeeRepositoryTest.
 */
@ExtendWith(SpringExtension.class)
@DataJpaTest
public class EmployeeRepositoryTest {

	/** The entity manager. */
	@Autowired
	private TestEntityManager entityManager;

	/** The employee repository. */
	@Autowired
	private EmployeeRepository employeeRepository;

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
		EmployeeEntity entity = new EmployeeEntity();
		entity.setEmpId(23423);
		entity.setFirstName("test");
		entity.setLastName("test");
		entity.setEmail("abhc@test.com");
		entity.setAge(32);
		employeeRepository.save(entity);
		List<EmployeeEntity> empList = employeeRepository.findAll();
		assertThat(empList).isNotEmpty();
		assertThat(empList.size()).isEqualTo(1);
	}

	/**
	 * Should return employee for emp id.
	 */
	@Test
	void should_return_employee_for_emp_id() {
		EmployeeEntity entity = new EmployeeEntity();
		entity.setEmpId(23423);
		entity.setFirstName("test");
		entity.setLastName("test");
		entity.setEmail("abhc@test.com");
		entity.setAge(32);
		employeeRepository.save(entity);
		Optional<EmployeeEntity> empOptional = employeeRepository.findByEmpId(23423);
		assertTrue(empOptional.isPresent());
		assertThat(empOptional.get()).isNotNull();
		assertThat(empOptional.get().getEmpId()).isEqualTo(23423);
	}

}
