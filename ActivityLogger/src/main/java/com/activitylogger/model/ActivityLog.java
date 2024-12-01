package com.activitylogger.model;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;

import com.activitylogger.dto.ActivityLogDTO;
import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class ActivityLog {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String username;
	private String action;
	
	@CreationTimestamp
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm")
	private LocalDateTime timeStamp;
	
	public ActivityLog() {
		
	}
	
	public ActivityLog (String username, String action, LocalDateTime timeStamp) {
		this.username = username;
		this.action = action;
		this.timeStamp = timeStamp;
	}

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
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
	
	
	public ActivityLogDTO toDTO() {
		return new ActivityLogDTO(username, action, timeStamp);
	}
	
}
