package com.util;

import java.util.Map;

/**
 * Ajax 响应统一消息格式。
 * 
 * @author Administrator
 * 
 */
public class AjaxMessage {

	private int success = 0;
	String message;
	private Map<String, Object> data;

	public AjaxMessage() {
		success = 1;
		message = "success";
	}

	public int getSuccess() {
		return success;
	}

	public void setSuccess(int success) {
		this.success = success;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Map<String, Object> getData() {
		return data;
	}

	public void setData(Map<String, Object> data) {
		this.data = data;
	}

}
