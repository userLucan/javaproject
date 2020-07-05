package com.etoak.bean;

import lombok.Data;

@Data
public class Flight {

	private Integer id;
	
	private String flightNo;
	
	private String planeType;
	
	private String airline;
	
	private String departureDate;
	
	private String departureCity;
	
	private String arriveDate;
	
	private String arriveCity;
	
	private Double mileage;
	
	private Integer classes;
	
	private Double price;
	
	private Integer ticketCount;
	
	private String createDate;
	
	private String updateTime;
	
	private String savePath;

	
}
