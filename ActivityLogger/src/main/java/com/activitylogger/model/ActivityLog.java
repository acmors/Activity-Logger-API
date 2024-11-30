package com.activitylogger.model;

import java.time.LocalDateTime;

import com.activitylogger.dto.ActivityLogDTO;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class ActivityLog {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String user;
	private String action;
	private LocalDateTime timeStamp;
	
	public ActivityLog() {
		
	}
	
	public ActivityLog(Long id, String user, String action, LocalDateTime timeStamp) {
		this.id = id;
		this.user = user;
		this.action = action;
		this.timeStamp = timeStamp;
	}

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
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
	
	
	public ActivityLogDTO toDTO() {
		return new ActivityLogDTO(user, action, timeStamp);
	}
	
}
