package com.activitylogger.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;
import com.activitylogger.dto.ActivityLogDTO;	
import com.activitylogger.model.ActivityLog;
import com.activitylogger.repository.ActivityLogRepository;

@Service	
public class ActivityLogService {
	
	
	private final ActivityLogRepository repository;
	
	public ActivityLogService(ActivityLogRepository repository) {
		this.repository = repository;
	}
	
	public ActivityLogDTO create(ActivityLogDTO activityLogDTO) {
		
		ActivityLog activityLog = activityLogDTO.toEntity();
		return activityLogDTO.fromEntity(activityLog);
		
	}
	
	public List<ActivityLogDTO> getAll(){
		List<ActivityLog> logs = repository.findAll();
		List<ActivityLogDTO> logDTO = new ArrayList<>();
		
		for(ActivityLog log : logs) {
			ActivityLogDTO dto = new ActivityLogDTO(log.getUser(), log.getAction(), log.getTimeStamp());
			logDTO.add(dto);
		}
		
		return logDTO;
	}
	
	public ActivityLogDTO update(Long id, ActivityLogDTO updateLog) {
		
		Optional<ActivityLog> existLog = repository.findById(id);
		if (existLog.isEmpty()) {
			return null;
		}
		
		ActivityLog existingLog = existLog.get();
		existingLog.setUser(updateLog.getUser());
		existingLog.setAction(updateLog.getAction());
		existingLog.setTimeStamp(updateLog.getTimeStamp());
		
		ActivityLog saveLog = repository.save(existingLog);
		ActivityLogDTO dto = new ActivityLogDTO();
		
		return dto.fromEntity(saveLog);
	}
	
	public boolean delete(Long id) {
		
		Optional<ActivityLog> existLog = repository.findById(id);
		if (existLog.isEmpty()) {
			return false;
		}
		
		repository.deleteById(id);
		return true;
	}
}
