package com.etoak.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.etoak.bean.Flight;
import com.etoak.bean.FlightVo;

import net.sf.jsqlparser.statement.delete.Delete;

public interface FlightMapper {
	
	Flight queryByFlightNo(@Param("flightNo")String flightNo);
	
	int addFlight(Flight flight);
	
	List<FlightVo> queryList(FlightVo flightVo);
	
	int deleteById(int id);
	
	int updateFlight(Flight flight);
	
}
