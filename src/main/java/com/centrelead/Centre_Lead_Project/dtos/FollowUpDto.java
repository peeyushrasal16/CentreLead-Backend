package com.centrelead.Centre_Lead_Project.dtos;

import java.time.LocalDateTime;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FollowUpDto {
	
	private Long followUpId;

    private Long leadId;

    private LocalDateTime followUpDateTime;

    @NotBlank(message = "Channel is required") //medium call whatup
    private String channel;

    @NotBlank(message = "Outcome is required") //Outcome means what happened after the follow-up.
    private String outcome;

    private String notes;

    private LocalDateTime nextFollowUpDate;

}
