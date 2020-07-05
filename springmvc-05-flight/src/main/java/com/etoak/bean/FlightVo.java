package com.etoak.bean;

import java.util.List;
import java.util.Map;

import lombok.Data;
@Data
public class FlightVo extends Flight {
	
	//页面显示:机型
	private String planeTypeName;
	//页面显示:出发城市-到达城市
	private String departureArriveCity;
	//页面显示:出发时间-到达时间
	private String departureArriveDate;
	//页面显示:里程
	private String mileageName;
	//页面显示:所属公司
	private String airlineName;
	//页面显示:价格
	private String priceName;
	//页面显示:剩余票数
	private String ticketCountName;
	
	private List<Integer> planeTypeList;
	
	private List<String> priceList;
	
	private List<Map<String ,Object>> priceMapList;
	  


}
