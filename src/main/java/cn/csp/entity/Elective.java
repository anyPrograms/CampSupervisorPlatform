package cn.csp.entity;

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

	private String electiveId;// ElectiveID,自增

	private String electiveName;// Elective名称

	private String electiveVolume;//Elective最大人数

}


