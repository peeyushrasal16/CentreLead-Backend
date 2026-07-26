package com.centrelead.Centre_Lead_Project.entities;

import java.time.LocalDateTime;

import jakarta.annotation.Generated;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "leads")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Lead {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long leadId;

    @Column(nullable = false, length = 100)
    private String parentName;

    @Column(nullable = false, length = 100)
    private String childName;

    @Column(nullable = false)
    private Integer childAge;

    @Column(nullable = false, unique = true, length = 15)
    private String phone;

    @Column(length = 100)
    private String email;
    
    @ManyToOne //many parent one centre
    @JoinColumn(name="centre_id",nullable = false)
    private Centre centre;
    
    @ManyToOne //many parent one owner
    @JoinColumn(name="owner_id",nullable = false)
    private Owner owner;
    
    @ManyToOne 
    @JoinColumn(name = "status_id", nullable = false)
    private LeadStatus leadStatus;
    
    @ManyToOne
    @JoinColumn(name = "source_id", nullable = false)
    private LeadSource leadSource;
    
    
    private LocalDateTime nextFollowUpDate;

    @Column(columnDefinition = "TEXT")
    private String notes;
    
    @Column(nullable = false)
    private Boolean archived = false;
    

}
