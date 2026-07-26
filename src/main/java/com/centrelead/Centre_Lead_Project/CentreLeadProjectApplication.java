package com.centrelead.Centre_Lead_Project;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.centrelead.Centre_Lead_Project.dtos.LeadDto;
import com.centrelead.Centre_Lead_Project.entities.Lead;

@SpringBootApplication
public class CentreLeadProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(CentreLeadProjectApplication.class, args);
	}
	
	@Bean
	public ModelMapper modelMapper()
	{
		ModelMapper modelMapper = new ModelMapper();

		modelMapper.createTypeMap(Lead.class, LeadDto.class)
				.addMappings(mapper -> {
					mapper.map(src -> src.getCentre().getCentreId(), LeadDto::setCentreId);
					mapper.map(src -> src.getOwner().getOwnerId(), LeadDto::setOwnerId);
					mapper.map(src -> src.getLeadStatus().getStatusId(), LeadDto::setStatusId);
					mapper.map(src -> src.getLeadSource().getSourceId(), LeadDto::setSourceId);
				});

		return modelMapper;
	}

}
