package com.centrelead.Centre_Lead_Project.repositories;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.centrelead.Centre_Lead_Project.entities.FollowUp;

public interface FollowUpRepository extends JpaRepository<FollowUp, Long>{
	
	List<FollowUp> findByLeadLeadIdOrderByFollowUpDateTimeDesc(Long leadId);
	
	long countByFollowUpDateTimeBetween(LocalDateTime start, LocalDateTime end);

}
