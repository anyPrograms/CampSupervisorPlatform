package cn.csp.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 选修实体
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ElectiveSchedule {
	
	private String scheduleId;
	
	private String period;

	private String electiveId;

	private String ageGroup;

}


