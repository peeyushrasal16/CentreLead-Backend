package com.centrelead.Centre_Lead_Project.services;

import java.util.List;

import com.centrelead.Centre_Lead_Project.dtos.FollowUpDto;

public interface FollowUpService {
	
	FollowUpDto addFollowUp(FollowUpDto followUpDto);

    List<FollowUpDto> getFollowUpsByLead(Long leadId);

}
