package com.centrelead.Centre_Lead_Project.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.centrelead.Centre_Lead_Project.dtos.DashboardDto;
import com.centrelead.Centre_Lead_Project.services.DashboardService;

@RestController
@RequestMapping("/dashboard")
@CrossOrigin(origins = "http://localhost:5173")
public class DashboardController {
	
	 @Autowired
	    private DashboardService dashboardService;

	    @GetMapping
	    public DashboardDto getDashboardData() {
	        return dashboardService.getDashboardData();
	    }
}
