package com.centrelead.Centre_Lead_Project.services;

import java.util.List;

import com.centrelead.Centre_Lead_Project.dtos.LeadSourceDto;

public interface LeadSourceService {
	
	LeadSourceDto addLeadSource(LeadSourceDto leadSourceDto);

    List<LeadSourceDto> getAllLeadSources();

    LeadSourceDto getLeadSourceById(Long sourceId);

    LeadSourceDto updateLeadSource(Long sourceId, LeadSourceDto leadSourceDto);

    void deleteLeadSource(Long sourceId);

}
