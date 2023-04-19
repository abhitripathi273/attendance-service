package com.emp.attendanceservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * The Class AttendanceServiceApplication.
 */
@SpringBootApplication
@EnableDiscoveryClient 
public class AttendanceServiceApplication {
	/**
	 * The main method.
	 *
	 * @param args the arguments
	 */
	
	public static void main(String[] args) {
		SpringApplication.run(AttendanceServiceApplication.class, args);
	}

}
