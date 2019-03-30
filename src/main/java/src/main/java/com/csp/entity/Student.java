package src.main.java.com.csp.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 学生实体
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student {

	private String studentId;// 学生ID

	private String studentName;// 学生名称

	private String studentBunk;
	
	private String studentStatus;//0 未参加  1 正常参加  2 外出就医  3 意外退出

}
