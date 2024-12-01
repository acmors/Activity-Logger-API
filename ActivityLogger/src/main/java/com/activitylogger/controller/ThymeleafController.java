package com.activitylogger.controller;

import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.activitylogger.dto.ActivityLogDTO;
import com.activitylogger.service.ActivityLogService;

@Controller
public class ThymeleafController {

    private final ActivityLogService service;

    public ThymeleafController(ActivityLogService service) {
        this.service = service;
    }

    @GetMapping("/activities")
    public String listActivities(Model model) {
        List<ActivityLogDTO> activities = service.getAll();
        model.addAttribute("activities", activities); 
        return "activities"; 
    }
}
