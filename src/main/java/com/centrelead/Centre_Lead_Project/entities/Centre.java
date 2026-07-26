package com.centrelead.Centre_Lead_Project.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "centres")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Centre {

	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long centreId;

	    @Column(nullable = false, unique = true, length = 100)
	    private String centreName;

	    @Column(nullable = false, length = 50)
	    private String city;

}
