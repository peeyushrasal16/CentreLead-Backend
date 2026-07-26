package com.centrelead.Centre_Lead_Project.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DashboardDto {
	
	private Long totalLeads;

    private Long activeLeads;

    private Long convertedLeads;

    private Long lostLeads;

    private Long todayFollowUps;

}
