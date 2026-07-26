package com.centrelead.Centre_Lead_Project.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LeadSourceDto {
	
	private Long sourceId;

    @NotBlank(message = "Source is required")
    @Size(max = 50)
    private String sourceName;

}
