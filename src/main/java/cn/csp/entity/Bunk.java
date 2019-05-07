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
public class Bunk {

	private String bunkId;// BunkID

	private String bunkName;// bunk名称
	
	private String bunkVol;// bunk容量

}
