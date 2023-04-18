package com.emp.attendanceservice.service.imp;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.springframework.boot.test.context.SpringBootTest;

import com.emp.attendanceservice.service.AttendanceService;
import com.emp.attendanceservice.service.impl.KafKaConsumer;

/**
 * The Class KafkaConsumerTest.
 */
@SpringBootTest
class KafkaConsumerTest {

	/** The kafka consumer. */
	@InjectMocks
	@Spy
	private KafKaConsumer kafkaConsumer;
	
	/** The service. */
	@Mock
	private AttendanceService service;
	
	/**
	 * Test.
	 */
	@Test
	void test() {
		String msg ="{\r\n" + 
				"	\"empId\": 123400,\r\n" + 
				"	\"attendanceDate\": \"2023-03-29\",\r\n" + 
				"	\"totalHours\": 4.8\r\n" + 
				"}";
		kafkaConsumer.consume(msg);
	}
	
	/**
	 * Test empty message.
	 */
	@Test
	void testEmptyMessage() {
		String msg ="";
		kafkaConsumer.consume(msg);
	}
	
	/**
	 * Test invalid message.
	 */
	@Test
	void testInvalidMessage() {
		String msg ="{\r\n" + 
				"	\"empId\": 123400,\r\n" + 
				"	\"attendanceDate\": \"2023-03-29\",\r\n" + 
				"	\"totalHours\": 4.8" + 
				"}";
		kafkaConsumer.consume(msg);
	}
}
