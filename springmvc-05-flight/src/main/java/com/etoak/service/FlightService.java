package com.etoak.service;

import com.etoak.bean.Flight;
import com.etoak.bean.FlightVo;
import com.etoak.bean.Page;

public interface FlightService {
	
	Flight queryByFlightNo(String flight);
	
	int addFlight(Flight flight);
	
	Page<FlightVo> queryList(int pageNum,int pageSize,FlightVo flightVo);
	
	int deletaById(int id);
	
	int updateFlight(Flight flight);
}
