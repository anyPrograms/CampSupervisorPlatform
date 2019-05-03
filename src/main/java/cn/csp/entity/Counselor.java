package cn.csp.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Counselor实体
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Counselor {

	private String counselorId;// CounselorID

	private String counselorName;// Counselor名称

	private String counselorBunk;
	
	private String counselorIntro;

}
