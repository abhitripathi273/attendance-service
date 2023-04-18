package com.emp.attendanceservice.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.emp.attendanceservice.constants.AttendanceConstants;

/**
 * The Class KafkaProducer.
 */
@Service
public class KafkaProducer {

    /** The Constant LOGGER. */
    private static final Logger LOGGER = LoggerFactory.getLogger(KafkaProducer.class);

    /** The kafka template. */
    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    /**
     * Send message.
     *
     * @param message the message
     * @return the string
     */
    public String sendMessage(String message){
        LOGGER.info(String.format("Message sent -> %s", message));
        kafkaTemplate.send(AttendanceConstants.TOPIC_NAME, message);
        return "success";
    }
}