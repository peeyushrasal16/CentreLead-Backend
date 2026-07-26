package com.centrelead.Centre_Lead_Project.services.impls;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.centrelead.Centre_Lead_Project.dtos.OwnerDto;
import com.centrelead.Centre_Lead_Project.entities.Owner;
import com.centrelead.Centre_Lead_Project.repositories.OwnerRepository;
import com.centrelead.Centre_Lead_Project.services.OwnerService;

@Service
public class OwnerServiceImpl implements OwnerService{
	
	@Autowired
	private OwnerRepository ownerRepository;
	
	@Autowired
	private ModelMapper modelMapper;

	@Override
	public OwnerDto addOwner(OwnerDto ownerDto) {
		
		Owner owner = modelMapper.map(ownerDto, Owner.class);
        Owner savedOwner = ownerRepository.save(owner);
        
        return modelMapper.map(savedOwner, OwnerDto.class);
	}

	@Override
	public List<OwnerDto> getAllOwners() {
		
		List<Owner> owners = ownerRepository.findAll();

        return owners.stream().map(owner -> modelMapper.map(owner, OwnerDto.class))
                .collect(Collectors.toList());
	}

	@Override
	public OwnerDto getOwnerById(Long ownerId) {
		
		 Owner owner = ownerRepository.findById(ownerId).orElseThrow(() -> new RuntimeException("Owner not found"));

	        return modelMapper.map(owner, OwnerDto.class);
	}

	@Override
	public OwnerDto updateOwner(Long ownerId, OwnerDto ownerDto) {
		
		 Owner owner = ownerRepository.findById(ownerId).orElseThrow(() -> new RuntimeException("Owner not found"));

	        //  update jo mere owner entitity mai hai 
	        owner.setOwnerName(ownerDto.getOwnerName());
	        owner.setEmail(ownerDto.getEmail());
	        owner.setPhone(ownerDto.getPhone());
	        Owner updatedOwner = ownerRepository.save(owner);

	        return modelMapper.map(updatedOwner, OwnerDto.class);
	}

	@Override
	public void deleteOwner(Long ownerId) {
		
		Owner owner = ownerRepository.findById(ownerId).orElseThrow(() -> new RuntimeException("Owner not found"));
        ownerRepository.delete(owner);
		
	}
	
	

}
