package com.centrelead.Centre_Lead_Project.services.impls;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.centrelead.Centre_Lead_Project.dtos.LeadDto;
import com.centrelead.Centre_Lead_Project.entities.Centre;
import com.centrelead.Centre_Lead_Project.entities.Lead;
import com.centrelead.Centre_Lead_Project.entities.LeadSource;
import com.centrelead.Centre_Lead_Project.entities.LeadStatus;
import com.centrelead.Centre_Lead_Project.entities.Owner;
import com.centrelead.Centre_Lead_Project.repositories.CentreRepository;
import com.centrelead.Centre_Lead_Project.repositories.LeadRepository;
import com.centrelead.Centre_Lead_Project.repositories.LeadSourceRepository;
import com.centrelead.Centre_Lead_Project.repositories.LeadStatusRepository;
import com.centrelead.Centre_Lead_Project.repositories.OwnerRepository;
import com.centrelead.Centre_Lead_Project.services.LeadService;

@Service
public class LeadServiceImpl implements LeadService {

	@Autowired
	private LeadRepository leadRepository;

	@Autowired
	private CentreRepository centreRepository;

	@Autowired
	private OwnerRepository ownerRepository;

	@Autowired
	private LeadStatusRepository leadStatusRepository;

	@Autowired
	private LeadSourceRepository leadSourceRepository;

	@Autowired
	private ModelMapper modelMapper;

	@Override
	public LeadDto addLead(LeadDto leadDto) {

		String normalizedPhone = normalizePhone(leadDto.getPhone());
		checkDuplicatePhone(normalizedPhone, null);

		Lead lead = modelMapper.map(leadDto, Lead.class);
		lead.setArchived(false);
		lead.setPhone(normalizedPhone);
		lead.setCentre(getCentre(leadDto.getCentreId()));
		lead.setOwner(getOwner(leadDto.getOwnerId()));
		lead.setLeadStatus(getLeadStatus(leadDto.getStatusId()));
		lead.setLeadSource(getLeadSource(leadDto.getSourceId()));

		Lead savedLead = leadRepository.save(lead);
		return modelMapper.map(savedLead, LeadDto.class);
	}

	@Override
	public Page<LeadDto> getAllLeads(int page, int size) {

	    Pageable pageable = PageRequest.of(page, size);
	    
	    Page<Lead> leads = leadRepository.findByArchivedFalse(pageable);

	    return leads.map(lead -> modelMapper.map(lead, LeadDto.class));
	}

	@Override
	public LeadDto getLeadById(Long leadId) {

		Lead lead = leadRepository.findById(leadId).orElseThrow(() -> new RuntimeException("Lead not found"));

		return modelMapper.map(lead, LeadDto.class);
	}

	@Override
	public LeadDto updateLead(Long leadId, LeadDto leadDto) {

		Lead lead = leadRepository.findById(leadId).orElseThrow(() -> new RuntimeException("Lead not found"));

		// Converted ya Lost lead sirf notes edit ho sakti hai
		if (isClosedLead(lead)) {
			lead.setNotes(leadDto.getNotes());
			Lead updatedLead = leadRepository.save(lead);
			return modelMapper.map(updatedLead, LeadDto.class);
		}

		String normalizedPhone = normalizePhone(leadDto.getPhone());
		checkDuplicatePhone(normalizedPhone, leadId);

		lead.setParentName(leadDto.getParentName());
		lead.setChildName(leadDto.getChildName());
		lead.setChildAge(leadDto.getChildAge());
		lead.setPhone(normalizedPhone);
		lead.setEmail(leadDto.getEmail());
		lead.setNextFollowUpDate(leadDto.getNextFollowUpDate());
		lead.setNotes(leadDto.getNotes());
		lead.setCentre(getCentre(leadDto.getCentreId()));
		lead.setOwner(getOwner(leadDto.getOwnerId()));
		lead.setLeadStatus(getLeadStatus(leadDto.getStatusId()));
		lead.setLeadSource(getLeadSource(leadDto.getSourceId()));

		Lead updatedLead = leadRepository.save(lead);

		return modelMapper.map(updatedLead, LeadDto.class);
	}

	@Override
	public void archiveLead(Long leadId) {

		Lead lead = leadRepository.findById(leadId).orElseThrow(() -> new RuntimeException("Lead not found"));

		lead.setArchived(true);
		leadRepository.save(lead);
	}

	// +91, spaces, leading 0 hata kar phone normalize karta hai
	private String normalizePhone(String phone) {
		if (phone == null) {
			return null;
		}

		String cleaned = phone.replaceAll("[\\s\\-]", "");

		if (cleaned.startsWith("+91")) {
			cleaned = cleaned.substring(3);
		} else if (cleaned.startsWith("91") && cleaned.length() == 12) {
			cleaned = cleaned.substring(2);
		}

		if (cleaned.startsWith("0") && cleaned.length() == 11) {
			cleaned = cleaned.substring(1);
		}

		return cleaned;
	}

	private void checkDuplicatePhone(String phone, Long currentLeadId) {
		leadRepository.findByPhoneAndArchivedFalse(phone)
				.filter(existing -> currentLeadId == null || !existing.getLeadId().equals(currentLeadId))
				.ifPresent(existing -> {
					throw new RuntimeException("Active lead with this phone number already exists");
				});
	}

	private boolean isClosedLead(Lead lead) {
		String statusName = lead.getLeadStatus().getStatusName();
		return "Converted".equalsIgnoreCase(statusName) || "Lost".equalsIgnoreCase(statusName);
	}

	private Centre getCentre(Long centreId) {
		return centreRepository.findById(centreId)
				.orElseThrow(() -> new RuntimeException("Centre not found"));
	}

	private Owner getOwner(Long ownerId) {
		return ownerRepository.findById(ownerId)
				.orElseThrow(() -> new RuntimeException("Owner not found"));
	}

	private LeadStatus getLeadStatus(Long statusId) {
		return leadStatusRepository.findById(statusId)
				.orElseThrow(() -> new RuntimeException("Lead Status not found"));
	}

	private LeadSource getLeadSource(Long sourceId) {
		return leadSourceRepository.findById(sourceId)
				.orElseThrow(() -> new RuntimeException("Lead Source not found"));
	}

}
