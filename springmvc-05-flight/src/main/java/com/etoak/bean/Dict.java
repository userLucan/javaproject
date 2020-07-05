package com.etoak.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Dict {

	private Integer id;
	
	private String groupId;
	
	private String name;
	
	private String value;
	
	private Integer sort;
}
