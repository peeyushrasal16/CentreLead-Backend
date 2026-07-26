package com.centrelead.Centre_Lead_Project.responses;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ErrorResponse {
	
	private String message;
    private int status;
    private LocalDateTime timestamp;

}
