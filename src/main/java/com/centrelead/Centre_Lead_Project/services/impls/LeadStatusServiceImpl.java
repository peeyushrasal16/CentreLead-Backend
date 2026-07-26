package com.centrelead.Centre_Lead_Project.services.impls;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;

import com.centrelead.Centre_Lead_Project.dtos.LeadStatusDto;
import com.centrelead.Centre_Lead_Project.entities.LeadStatus;
import com.centrelead.Centre_Lead_Project.repositories.LeadStatusRepository;
import com.centrelead.Centre_Lead_Project.services.LeadStatusService;

@Service
public class LeadStatusServiceImpl implements LeadStatusService{
	
	@Autowired
	private LeadStatusRepository leadStatusRepository;
	
	@Autowired
	private ModelMapper modelMapper;

	@Override
	public LeadStatusDto addLeadStatus(LeadStatusDto leadStatusDto) {
		
		LeadStatus leadStatus = modelMapper.map(leadStatusDto, LeadStatus.class);
        LeadStatus savedLeadStatus = leadStatusRepository.save(leadStatus);

        return modelMapper.map(savedLeadStatus, LeadStatusDto.class);
	}

	@Override
	public List<LeadStatusDto> getAllLeadStatus() {
		 List<LeadStatus> leadStatusList = leadStatusRepository.findAll();

	        return leadStatusList.stream().map(status -> modelMapper.map(status, LeadStatusDto.class))
	                .collect(Collectors.toList());
	}

	@Override
	public LeadStatusDto getLeadStatusById(Long statusId) {
		
		 LeadStatus leadStatus = leadStatusRepository.findById(statusId).orElseThrow(() -> new RuntimeException("Lead Status not found"));

	        return modelMapper.map(leadStatus, LeadStatusDto.class);
	}

	@Override
	public LeadStatusDto updateLeadStatus(Long statusId, LeadStatusDto leadStatusDto) {
		
		 LeadStatus leadStatus = leadStatusRepository.findById(statusId).orElseThrow(() -> new RuntimeException("Lead Status not found"));
	        leadStatus.setStatusName(leadStatusDto.getStatusName());
	        LeadStatus updatedLeadStatus = leadStatusRepository.save(leadStatus);

	        return modelMapper.map(updatedLeadStatus, LeadStatusDto.class);
	}

	@Override
	public void deleteLeadStatus(Long statusId) {
		
		 LeadStatus leadStatus = leadStatusRepository.findById(statusId).orElseThrow(() -> new RuntimeException("Lead Status not found"));
	        leadStatusRepository.delete(leadStatus);
		
	}

}
