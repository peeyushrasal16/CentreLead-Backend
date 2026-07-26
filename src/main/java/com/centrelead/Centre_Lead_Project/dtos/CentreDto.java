package com.centrelead.Centre_Lead_Project.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CentreDto {
	
	private Long centreId;

    @NotBlank(message = "Centre name is required")
    @Size(max = 100, message = "Centre name cannot exceed 100 characters")
    private String centreName;

    @NotBlank(message = "City is required")
    @Size(max = 50, message = "City cannot exceed 50 characters")
    private String city;

}
