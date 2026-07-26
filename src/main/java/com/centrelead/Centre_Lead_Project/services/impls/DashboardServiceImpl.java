package com.centrelead.Centre_Lead_Project.services.impls;

import java.time.LocalDate;
import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.centrelead.Centre_Lead_Project.dtos.DashboardDto;
import com.centrelead.Centre_Lead_Project.repositories.FollowUpRepository;
import com.centrelead.Centre_Lead_Project.repositories.LeadRepository;
import com.centrelead.Centre_Lead_Project.services.DashboardService;

@Service
public class DashboardServiceImpl implements DashboardService{
	
	@Autowired
    private LeadRepository leadRepository;

    @Autowired
    private FollowUpRepository followUpRepository;


	@Override
	public DashboardDto getDashboardData() {
		DashboardDto dashboard = new DashboardDto();

        dashboard.setTotalLeads(leadRepository.count());

        dashboard.setActiveLeads(
                leadRepository.countByArchivedFalse());

        dashboard.setConvertedLeads(
                leadRepository.countByLeadStatusStatusNameIgnoreCaseAndArchivedFalse("Converted"));

        dashboard.setLostLeads(
                leadRepository.countByLeadStatusStatusNameIgnoreCaseAndArchivedFalse("Lost"));

        LocalDate today = LocalDate.now();

        LocalDateTime start = today.atStartOfDay();

        LocalDateTime end = today.atTime(23, 59, 59);

        dashboard.setTodayFollowUps(
                followUpRepository.countByFollowUpDateTimeBetween(start, end));

        return dashboard;
    }
	}


