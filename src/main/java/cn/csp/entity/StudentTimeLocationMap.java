package cn.csp.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Bunk实体
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentTimeLocationMap {

	private String studentId;// 营员Id

	private String locationId;// 位置Id
	
	private String period;// 当天阶段
	
	private String date;// 当天日期

}
