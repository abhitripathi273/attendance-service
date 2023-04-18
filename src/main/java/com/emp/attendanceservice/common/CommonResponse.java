package com.emp.attendanceservice.common;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

/**
 * This class is common response for this service.
 * 
 * @author abhtripa
 */
@JsonAutoDetect
@JsonInclude(Include.NON_NULL)
@Data
@Getter
@Setter
public class CommonResponse implements Serializable {
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 8833540884140100611L;
	
	/** The status. */
	private ServiceStatus status;
	
	/** The validation errors. */
	private List<ValidationError> validationErrors;

	/**
	 * Adds the validation error.
	 *
	 * @param msg the msg
	 */
	public void addValidationError(String msg) {
		if (Objects.isNull(this.validationErrors)) {
			this.validationErrors = new ArrayList<>();
		}
		this.validationErrors.add(new ValidationError(msg));
	}

	/**
	 * Adds the validation error.
	 *
	 * @param validationError the validation error
	 */
	public void addValidationError(ValidationError validationError) {
		if (Objects.isNull(this.validationErrors)) {
			this.validationErrors = new ArrayList<>();
		}
		this.validationErrors.add(validationError);
	}
}
