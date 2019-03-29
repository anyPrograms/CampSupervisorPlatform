package src.main.java.com.csp.entity;

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

	private String c_id;// CounselorID

	private String c_name;// Counselor名称

	private String c_bunk;
	
	private String c_intro;

}
