package com.centrelead.Centre_Lead_Project.dtos;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LeadDto {
	
	private Long leadId;

    @NotBlank(message = "Parent name is required")
    @Size(max = 100)
    private String parentName;

    @NotBlank(message = "Child name is required")
    @Size(max = 100)
    private String childName;

    @Min(value = 2, message = "Child age must be at least 2 years")
    @Max(value = 18, message = "Child age cannot exceed 18 years")
    private Integer childAge;

    @NotBlank(message = "Phone number is required")
    @Pattern(regexp = "^[6-9]\\d{9}$", message = "Enter a valid 10-digit mobile number")
    private String phone;

    @Email(message = "Invalid email address")
    private String email;

    private Long centreId;

    private Long ownerId;

    private Long statusId;

    private Long sourceId;

    private LocalDateTime nextFollowUpDate;

    @Size(max = 1000)
    private String notes;
    
    
    

}
