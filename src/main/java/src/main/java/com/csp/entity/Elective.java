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

	private String e_id;// ElectiveID

	private String e_name;// Elective名称

}
