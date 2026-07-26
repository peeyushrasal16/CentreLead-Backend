package com.centrelead.Centre_Lead_Project.services.impls;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.centrelead.Centre_Lead_Project.dtos.LeadSourceDto;
import com.centrelead.Centre_Lead_Project.entities.LeadSource;
import com.centrelead.Centre_Lead_Project.repositories.LeadSourceRepository;
import com.centrelead.Centre_Lead_Project.services.LeadSourceService;

@Service
public class LeadSourceServiceImpl implements LeadSourceService{
	
	@Autowired
    private LeadSourceRepository leadSourceRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public LeadSourceDto addLeadSource(LeadSourceDto leadSourceDto) {

        LeadSource leadSource = modelMapper.map(leadSourceDto, LeadSource.class);
        LeadSource savedLeadSource = leadSourceRepository.save(leadSource);

        return modelMapper.map(savedLeadSource, LeadSourceDto.class);
    }

    @Override
    public List<LeadSourceDto> getAllLeadSources() {

        List<LeadSource> leadSources = leadSourceRepository.findAll();

        return leadSources.stream().map(source -> modelMapper.map(source, LeadSourceDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public LeadSourceDto getLeadSourceById(Long sourceId) {

        LeadSource leadSource = leadSourceRepository.findById(sourceId).orElseThrow(() -> new RuntimeException("Lead Source not found"));

        return modelMapper.map(leadSource, LeadSourceDto.class);
    }

    @Override
    public LeadSourceDto updateLeadSource(Long sourceId, LeadSourceDto leadSourceDto) {

        LeadSource leadSource = leadSourceRepository.findById(sourceId).orElseThrow(() -> new RuntimeException("Lead Source not found"));
        leadSource.setSourceName(leadSourceDto.getSourceName());
        LeadSource updatedLeadSource = leadSourceRepository.save(leadSource);

        return modelMapper.map(updatedLeadSource, LeadSourceDto.class);
    }

    @Override
    public void deleteLeadSource(Long sourceId) {

        LeadSource leadSource = leadSourceRepository.findById(sourceId).orElseThrow(() -> new RuntimeException("Lead Source not found"));

        leadSourceRepository.delete(leadSource);

}
}
