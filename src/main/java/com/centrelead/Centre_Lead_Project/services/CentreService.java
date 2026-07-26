package com.centrelead.Centre_Lead_Project.services;

import java.util.List;

import com.centrelead.Centre_Lead_Project.dtos.CentreDto;

public interface CentreService {
	
	CentreDto addCentre(CentreDto centreDto);

    List<CentreDto> getAllCentres();

    CentreDto getCentreById(Long centreId);

    CentreDto updateCentre(Long centreId, CentreDto centreDto);

    void deleteCentre(Long centreId);

}
