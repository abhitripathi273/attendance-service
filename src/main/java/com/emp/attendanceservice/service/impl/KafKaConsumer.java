package com.emp.attendanceservice.service.impl;

import java.util.Objects;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.emp.attendanceservice.constants.AttendanceConstants;
import com.emp.attendanceservice.domain.AttendanceMessage;
import com.emp.attendanceservice.service.AttendanceService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * The Class KafKaConsumer.
 */
@Service
public class KafKaConsumer {

	/** The Constant LOGGER. */
	private static final Logger LOGGER = LoggerFactory.getLogger(KafKaConsumer.class);

	/** The attendance service. */
	@Autowired
	private AttendanceService attendanceService;

	/**
	 * Consume.
	 *
	 * @param message the message
	 */
	@KafkaListener(topics = AttendanceConstants.TOPIC_NAME, groupId = AttendanceConstants.GROUP_ID)
	public void consume(String message) {
		LOGGER.info(String.format("Message received -> %s", message));
		try {
			LOGGER.info("Message recieved from topic: {}", message);
			if (StringUtils.isNotBlank(message)) {
				AttendanceMessage attendanceMessage = null;
				attendanceMessage = new ObjectMapper().readValue(message, AttendanceMessage.class);
				if (Objects.nonNull(attendanceMessage)) {
					attendanceService.processAttendanceMessage(attendanceMessage);
				} else {
					LOGGER.info("Message is null");
				}
			} else {
				LOGGER.info("Recieved Message is empty or null or blank");
			}
		} catch (JsonProcessingException e) {
			LOGGER.error("Exception occurred, while consuming message from: {} topic, exception is: {}",
					AttendanceConstants.TOPIC_NAME, e);
		}
	}
}