package src.main.java.com.csp.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 员工实体
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Staff {

	private String st_id;// StaffID

	private String st_name;// Staff名称

}
