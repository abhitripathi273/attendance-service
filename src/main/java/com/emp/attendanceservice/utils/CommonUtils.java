package com.emp.attendanceservice.utils;

import com.emp.attendanceservice.common.ServiceStatus;

/**
 * This is common util class.
 * 
 * @author abhtripa
 *
 */
public class CommonUtils {

	/**
	 * Instantiates a new common utils.
	 */
	private CommonUtils() {}
	
	/**
	 * Gets the service status.
	 *
	 * @param isSuccess the is success
	 * @param msg the msg
	 * @return the service status
	 */
	public static ServiceStatus getServiceStatus(boolean isSuccess, String msg) {
		if (isSuccess) {
			return ServiceStatus.builder().statusMsg(msg).success(isSuccess).build();
		} else {
			return ServiceStatus.builder().statusMsg(msg).success(isSuccess).build();
		}
	}

	/**
	 * Gets the service status.
	 *
	 * @param isSuccess the is success
	 * @return the service status
	 */
	public static ServiceStatus getServiceStatus(boolean isSuccess) {
		if (isSuccess) {
			return ServiceStatus.builder().statusMsg("SUCCESS").success(Boolean.TRUE).build();
		} else {
			return ServiceStatus.builder().statusMsg("ERROR").success(Boolean.FALSE).build();
		}
	}
}
