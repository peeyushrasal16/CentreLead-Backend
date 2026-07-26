package com.centrelead.Centre_Lead_Project.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.centrelead.Centre_Lead_Project.dtos.LeadDto;
import com.centrelead.Centre_Lead_Project.services.LeadService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/lead")
@CrossOrigin(origins = "http://localhost:5173")
public class LeadController {
	
	    @Autowired
	    private LeadService leadService;

	    @PostMapping
	    public LeadDto addLead(@Valid @RequestBody LeadDto leadDto) {
	        return leadService.addLead(leadDto);
	    }

	    @GetMapping
	    public Page<LeadDto> getAllLeads(
	            @RequestParam(defaultValue = "0") int page,
	            @RequestParam(defaultValue = "10") int size) {

	        return leadService.getAllLeads(page, size);
	    }

	    @GetMapping("/{leadId}")
	    public LeadDto getLeadById(@PathVariable Long leadId) {
	        return leadService.getLeadById(leadId);
	    }

	    @PutMapping("/{leadId}")
	    public LeadDto updateLead(@PathVariable Long leadId,
	                              @Valid @RequestBody LeadDto leadDto) {
	        return leadService.updateLead(leadId, leadDto);
	    }

	    @DeleteMapping("/{leadId}")
	    public String archiveLead(@PathVariable Long leadId) {
	        leadService.archiveLead(leadId);
	        return "Lead archived successfully";
	    }


}
