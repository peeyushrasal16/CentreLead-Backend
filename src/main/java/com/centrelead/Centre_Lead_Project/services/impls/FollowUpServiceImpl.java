package com.centrelead.Centre_Lead_Project.services.impls;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.centrelead.Centre_Lead_Project.dtos.FollowUpDto;
import com.centrelead.Centre_Lead_Project.entities.FollowUp;
import com.centrelead.Centre_Lead_Project.entities.Lead;
import com.centrelead.Centre_Lead_Project.repositories.FollowUpRepository;
import com.centrelead.Centre_Lead_Project.repositories.LeadRepository;
import com.centrelead.Centre_Lead_Project.services.FollowUpService;

@Service
public class FollowUpServiceImpl implements FollowUpService{
	
	@Autowired
    private FollowUpRepository followUpRepository;

    @Autowired
    private LeadRepository leadRepository;

    @Autowired
    private ModelMapper modelMapper;


	@Override
	public FollowUpDto addFollowUp(FollowUpDto followUpDto) {
		
		FollowUp followUp = modelMapper.map(followUpDto, FollowUp.class);
		followUp.setLead(getLeadById(followUpDto.getLeadId()));
		FollowUp savedFollowUp = followUpRepository.save(followUp);

		return modelMapper.map(savedFollowUp, FollowUpDto.class);
	}

	private Lead getLeadById(Long leadId) {
		
		return leadRepository.findById(leadId).orElseThrow(() -> new RuntimeException("Lead not found"));
	}

	@Override
	public List<FollowUpDto> getFollowUpsByLead(Long leadId) {
		
		List<FollowUp> followUps = followUpRepository.findByLeadLeadIdOrderByFollowUpDateTimeDesc(leadId);

		return followUps.stream().map(followUp -> modelMapper.map(followUp, FollowUpDto.class))
				.collect(Collectors.toList());

	}
	
	

}
