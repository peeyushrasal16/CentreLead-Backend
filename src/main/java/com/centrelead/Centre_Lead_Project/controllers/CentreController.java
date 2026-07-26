package com.centrelead.Centre_Lead_Project.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.centrelead.Centre_Lead_Project.dtos.CentreDto;
import com.centrelead.Centre_Lead_Project.services.CentreService;

@RestController
@RequestMapping("/centres")
@CrossOrigin(origins = "http://localhost:5173")
public class CentreController {
	
	@Autowired
	private CentreService centreService;
	
	@PostMapping
    public CentreDto addCentre(@RequestBody CentreDto centreDto) {
        return centreService.addCentre(centreDto);
    }
	
	@GetMapping
    public List<CentreDto> getAllCentres() {
        return centreService.getAllCentres();
    }
	
	@GetMapping("/{centreId}")
    public CentreDto getCentreById(@PathVariable Long centreId) {
        return centreService.getCentreById(centreId);
    }
	
	@PutMapping("/{centreId}")
    public CentreDto updateCentre(@PathVariable Long centreId,
                                  @RequestBody CentreDto centreDto) {
        return centreService.updateCentre(centreId, centreDto);
    }
	
	 @DeleteMapping("/{centreId}")
	    public String deleteCentre(@PathVariable Long centreId) {
	        centreService.deleteCentre(centreId);
	        return "Centre deleted successfully";
	    }

}
