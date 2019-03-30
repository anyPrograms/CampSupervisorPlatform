package src.main.java.com.csp.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 选修实体
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Elective {

	private String electiveId;// ElectiveID

	private String electiveName;// Elective名称

}
