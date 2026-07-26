package com.centrelead.Centre_Lead_Project.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "owners")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Owner {
	
	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long ownerId;

	    @Column(nullable = false, length = 100)
	    private String ownerName;

	    @Column(nullable = false, unique = true, length = 100)
	    private String email;

	    @Column(nullable = false, unique = true, length = 15)
	    private String phone;

}
