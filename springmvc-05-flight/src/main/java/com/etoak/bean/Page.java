package com.etoak.bean;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Page<T> {
	private int pageNum;
	
	private int pageSize;
	
	private long total;
	
	private int pageCount;

	private List<T> rows;
	
	private  int pre;
	
	private int next;
}
