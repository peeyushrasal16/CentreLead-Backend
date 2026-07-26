package com.centrelead.Centre_Lead_Project.services.impls;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.centrelead.Centre_Lead_Project.dtos.CentreDto;
import com.centrelead.Centre_Lead_Project.entities.Centre;
import com.centrelead.Centre_Lead_Project.repositories.CentreRepository;
import com.centrelead.Centre_Lead_Project.services.CentreService;

@Service
public class CentreServiceImpl implements CentreService{
	
	@Autowired
	private CentreRepository centreRepository;
	
	
	@Autowired
	private ModelMapper modelMapper;

	@Override
	public CentreDto addCentre(CentreDto centreDto) {
		
		Centre c = modelMapper.map(centreDto, Centre.class);
		Centre sc = centreRepository.save(c);
		return modelMapper.map(sc, CentreDto.class);
	}

	@Override
	public List<CentreDto> getAllCentres() {
		
		List<Centre> centres = centreRepository.findAll();
		
		return centres.stream().map(centre->modelMapper.map(centre, CentreDto.class))
				.collect(Collectors.toList());
	}

	@Override
	public CentreDto getCentreById(Long centreId) {
		
		Centre centree = centreRepository.findById(centreId).orElseThrow(()-> new RuntimeException("Centre Not Found"));
		return modelMapper.map(centree, CentreDto.class);
	}

	@Override
	public CentreDto updateCentre(Long centreId, CentreDto centreDto) {
		
		Centre centrre = centreRepository.findById(centreId).orElseThrow(() -> new RuntimeException("Centre not found"));
    centrre.setCentreName(centreDto.getCentreName());
    centrre.setCity(centreDto.getCity());

        Centre updatedCentre = centreRepository.save(centrre);

        return modelMapper.map(updatedCentre, CentreDto.class);
	}

	@Override
	public void deleteCentre(Long centreId) {
		Centre cenntre = centreRepository.findById(centreId)
                .orElseThrow(() -> new RuntimeException("Centre not found"));

        centreRepository.delete(cenntre);
		
	}

}
