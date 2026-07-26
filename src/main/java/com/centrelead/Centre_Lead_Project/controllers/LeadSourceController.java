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

import com.centrelead.Centre_Lead_Project.dtos.LeadSourceDto;
import com.centrelead.Centre_Lead_Project.services.LeadSourceService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/source-lead")
@CrossOrigin(origins = "http://localhost:5173")
public class LeadSourceController {
	
	@Autowired
    private LeadSourceService leadSourceService;

    @PostMapping
    public LeadSourceDto addLeadSource(@Valid @RequestBody LeadSourceDto leadSourceDto) {
        return leadSourceService.addLeadSource(leadSourceDto);
    }

    @GetMapping
    public List<LeadSourceDto> getAllLeadSources() {
        return leadSourceService.getAllLeadSources();
    }

    @GetMapping("/{sourceId}")
    public LeadSourceDto getLeadSourceById(@PathVariable Long sourceId) {
        return leadSourceService.getLeadSourceById(sourceId);
    }

    @PutMapping("/{sourceId}")
    public LeadSourceDto updateLeadSource(@PathVariable Long sourceId,
                                          @Valid @RequestBody LeadSourceDto leadSourceDto) {
        return leadSourceService.updateLeadSource(sourceId, leadSourceDto);
    }

    @DeleteMapping("/{sourceId}")
    public String deleteLeadSource(@PathVariable Long sourceId) {
        leadSourceService.deleteLeadSource(sourceId);
        return "Lead Source deleted successfully";
    }


}
