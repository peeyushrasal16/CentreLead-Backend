package com.centrelead.Centre_Lead_Project.services;

import java.util.List;

import org.springframework.data.domain.Page;

import com.centrelead.Centre_Lead_Project.dtos.LeadDto;

public interface LeadService {
	
	LeadDto addLead(LeadDto leadDto);

	Page<LeadDto> getAllLeads(int page, int size);

    LeadDto getLeadById(Long leadId);

    LeadDto updateLead(Long leadId, LeadDto leadDto);

    void archiveLead(Long leadId);

}
