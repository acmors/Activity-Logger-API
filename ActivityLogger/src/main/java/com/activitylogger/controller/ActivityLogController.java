package com.activitylogger.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.activitylogger.dto.ActivityLogDTO;
import com.activitylogger.service.ActivityLogService;

import jakarta.validation.Valid;
	
@RestController
@RequestMapping("/api/activity")
public class ActivityLogController {

	private final ActivityLogService service;
	
		
	public ActivityLogController(ActivityLogService service) {
		this.service = service;
	}
	
	@PostMapping
	public ResponseEntity<ActivityLogDTO> create(@Valid @RequestBody ActivityLogDTO dto){
		
		ActivityLogDTO createLog = service.create(dto);
		return ResponseEntity.status(HttpStatus.CREATED).body(createLog);
	}
	
	@GetMapping
	public ResponseEntity<List<ActivityLogDTO>> getAll(){
		
		List<ActivityLogDTO> logs = service.getAll();
		return ResponseEntity.ok(logs);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<ActivityLogDTO> update(@PathVariable Long id, @Valid @RequestBody ActivityLogDTO update){
		
		ActivityLogDTO updateLog = service.update(id, update);
		
		if (updateLog == null) {
			return ResponseEntity.notFound().build();
		}
		
		return ResponseEntity.ok(updateLog);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id){
		boolean deleted = service.delete(id);
		if (!deleted) {
			return ResponseEntity.notFound().build();
		}
		
		return ResponseEntity.noContent().build();
	}
}
