package com.centrelead.Centre_Lead_Project.repositories;


import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.centrelead.Centre_Lead_Project.entities.Lead;

public interface LeadRepository extends JpaRepository<Lead, Long>{
	
	 Optional<Lead> findByPhoneAndArchivedFalse(String phone);

	    Page<Lead> findByArchivedFalse(Pageable pageable);
	    
	    long countByArchivedFalse();

	    long countByLeadStatusStatusNameIgnoreCaseAndArchivedFalse(String statusName);

}
