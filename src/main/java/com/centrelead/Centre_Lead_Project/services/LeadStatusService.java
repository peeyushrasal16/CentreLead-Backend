package com.centrelead.Centre_Lead_Project.services;

import java.util.List;

import com.centrelead.Centre_Lead_Project.dtos.LeadStatusDto;

public interface LeadStatusService {
	
	LeadStatusDto addLeadStatus(LeadStatusDto leadStatusDto);

    List<LeadStatusDto> getAllLeadStatus();

    LeadStatusDto getLeadStatusById(Long statusId);

    LeadStatusDto updateLeadStatus(Long statusId, LeadStatusDto leadStatusDto);

    void deleteLeadStatus(Long statusId);

}
