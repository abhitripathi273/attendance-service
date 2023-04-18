package com.emp.attendanceservice.common;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

/**
 * This class is service status for this service.
 * 
 * @author abhtripa
 */
@JsonAutoDetect
@JsonInclude(Include.NON_NULL)
@Data
@Builder
@Getter
@Setter
public class ServiceStatus implements Serializable {
	
	private static final long serialVersionUID = 75269209968312979L;
	private boolean success;
	private String statusMsg;
}
