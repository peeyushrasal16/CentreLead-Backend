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

import com.centrelead.Centre_Lead_Project.dtos.OwnerDto;
import com.centrelead.Centre_Lead_Project.services.OwnerService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/owners")
@CrossOrigin(origins = "http://localhost:5173")
public class OwnerController {
	
	@Autowired
    private OwnerService ownerService;

    @PostMapping
    public OwnerDto addOwner(@RequestBody OwnerDto ownerDto) {
        return ownerService.addOwner(ownerDto);
    }

    @GetMapping
    public List<OwnerDto> getAllOwners() {
        return ownerService.getAllOwners();
    }

    @GetMapping("/{ownerId}")
    public OwnerDto getOwnerById(@PathVariable Long ownerId) {
        return ownerService.getOwnerById(ownerId);
    }

    @PutMapping("/{ownerId}")
    public OwnerDto updateOwner(@PathVariable Long ownerId,
                                @Valid @RequestBody OwnerDto ownerDto) {
        return ownerService.updateOwner(ownerId, ownerDto);
    }

    @DeleteMapping("/{ownerId}")
    public String deleteOwner(@PathVariable Long ownerId) {
        ownerService.deleteOwner(ownerId);
        return "Owner deleted successfully";
    }


}
