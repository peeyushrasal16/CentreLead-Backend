package com.centrelead.Centre_Lead_Project.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.centrelead.Centre_Lead_Project.dtos.LeadStatusDto;
import com.centrelead.Centre_Lead_Project.services.LeadStatusService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/status-lead")
@CrossOrigin(origins = "http://localhost:5173")
public class LeadStatusController {
	
	@Autowired
    private LeadStatusService leadStatusService;

    @PostMapping
    public LeadStatusDto addLeadStatus(@Valid @RequestBody LeadStatusDto leadStatusDto) {
        return leadStatusService.addLeadStatus(leadStatusDto);
    }

    @GetMapping
    public List<LeadStatusDto> getAllLeadStatus() {
        return leadStatusService.getAllLeadStatus();
    }

    @GetMapping("/{statusId}")
    public LeadStatusDto getLeadStatusById(@PathVariable Long statusId) {
        return leadStatusService.getLeadStatusById(statusId);
    }

    @PutMapping("/{statusId}")
    public LeadStatusDto updateLeadStatus(@PathVariable Long statusId,
                                          @Valid @RequestBody LeadStatusDto leadStatusDto) {
        return leadStatusService.updateLeadStatus(statusId, leadStatusDto);
    }

    @DeleteMapping("/{statusId}")
    public String deleteLeadStatus(@PathVariable Long statusId) {
        leadStatusService.deleteLeadStatus(statusId);
        return "Lead Status deleted successfully";
    }

}
