package cn.csp.entity;

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

	private String staffId;// StaffID

	private String staffName;// Staff名称

}
