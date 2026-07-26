 package com.centrelead.Centre_Lead_Project.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.centrelead.Centre_Lead_Project.dtos.FollowUpDto;
import com.centrelead.Centre_Lead_Project.services.FollowUpService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/follow-ups")
@CrossOrigin(origins = "http://localhost:5173")
public class FollowUpController {
	

    @Autowired
    private FollowUpService followUpService;

    @PostMapping
    public FollowUpDto addFollowUp(@Valid @RequestBody FollowUpDto followUpDto) {
        return followUpService.addFollowUp(followUpDto);
    }

    @GetMapping("/lead/{leadId}")
    public List<FollowUpDto> getFollowUpsByLead(@PathVariable Long leadId) {
        return followUpService.getFollowUpsByLead(leadId);
    }

}
