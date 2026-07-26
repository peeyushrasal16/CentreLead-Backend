package com.centrelead.Centre_Lead_Project.entities;

import java.time.LocalDateTime;

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
@Table(name = "follow_ups")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class FollowUp {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long followUpId;

    @ManyToOne
    @JoinColumn(name = "lead_id", nullable = false)
    private Lead lead;

    @Column(nullable = false)
    private LocalDateTime followUpDateTime;

    @Column(nullable = false, length = 30)
    private String channel;

    @Column(nullable = false, length = 100)
    private String outcome;

    @Column(columnDefinition = "TEXT")
    private String notes;

    private LocalDateTime nextFollowUpDate;
}
