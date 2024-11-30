package com.activitylogger.dto;

import java.time.LocalDateTime;

import com.activitylogger.model.ActivityLog;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class ActivityLogDTO {

	@NotNull(message = "Username is required.")
	@Size(min = 3, max = 50)
	private String username;
	
	@NotNull(message = "Action is required.")
	@Size(min = 3, max = 100)
	private String action;
	
	@NotNull(message = "Timestamp is required.")
	private LocalDateTime timeStamp;
	
	public ActivityLogDTO(String username, String action, LocalDateTime timeStamp) {
		this.username = username;
		this.action = action;
		this.timeStamp = timeStamp;
	}
	
	public ActivityLogDTO() {
		
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getAction() {
		return action;
	}

	public void setAction(String action) {
		this.action = action;
	}

	public LocalDateTime getTimeStamp() {
		return timeStamp;
	}

	public void setTimeStamp(LocalDateTime timeStamp) {
		this.timeStamp = timeStamp;
	}
	
	
	public ActivityLogDTO fromEntity(ActivityLog activityLog) {
		return new ActivityLogDTO(activityLog.getUsername(), activityLog.getAction(), activityLog.getTimeStamp());
	}
	
	
	public ActivityLog toEntity() {
		
		return new ActivityLog(this.username, this.action, this.timeStamp);
	}
	
	
	
}
