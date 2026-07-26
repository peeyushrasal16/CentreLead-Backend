package com.centrelead.Centre_Lead_Project.services;

import java.util.List;

import com.centrelead.Centre_Lead_Project.dtos.OwnerDto;

public interface OwnerService {
	
	OwnerDto addOwner(OwnerDto ownerDto);

    List<OwnerDto> getAllOwners();

    OwnerDto getOwnerById(Long ownerId);

    OwnerDto updateOwner(Long ownerId, OwnerDto ownerDto);

    void deleteOwner(Long ownerId);

}
