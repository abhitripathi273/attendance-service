package com.emp.attendanceservice.entity;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;


/**
 * The Class EmployeeEntity.
 */
@Entity
@Table(name = "EMPLOYEE")
@Data
public class EmployeeEntity implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -397200297657952760L;

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

	@Column(name = "EMP_ID")
	private int empId;

	@Column(name = "FIRST_NAME", length = 25, nullable = false)
	private String firstName;

	@Column(name = "LAST_NAME", length = 25, nullable = false)
	private String lastName;

	@Column(name = "EMAIL", length = 50, nullable = false)
	private String email;

	@Column(name = "AGE", length = 3)
	private int age;
}
