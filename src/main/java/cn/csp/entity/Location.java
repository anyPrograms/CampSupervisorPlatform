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
public class Location {

	private String locationId;// LocationID,自增

	private String locationName;// Location名称

	private String locationIntro;//Location介绍

}


