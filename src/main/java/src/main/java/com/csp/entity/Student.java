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

	private String s_id;// 学生ID

	private String s_name;// 学生名称

	private Bunk s_bunk;
	
	private String s_status;//0 未参加  1 正常参加  2 外出就医  3 意外退出

}
