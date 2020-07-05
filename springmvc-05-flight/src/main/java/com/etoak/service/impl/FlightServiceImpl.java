package com.etoak.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import com.etoak.bean.Flight;
import com.etoak.bean.FlightVo;
import com.etoak.bean.Page;
import com.etoak.mapper.FlightMapper;
import com.etoak.service.FlightService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Service
public class FlightServiceImpl implements FlightService {

	@Autowired
	FlightMapper flightMapper;
	@Override
	public Flight queryByFlightNo(String flightNo) {
		return flightMapper.queryByFlightNo(flightNo);
	}
	@Override
	@Transactional //添加事务
	public int addFlight(Flight flight) {
		
		return flightMapper.addFlight(flight);
	}
	@Override
	public Page<FlightVo> queryList(int pageNum, int pageSize, FlightVo flightVo) {
		//先封装价格查询
			if(!CollectionUtils.isEmpty(flightVo.getPriceList())){
				List<Map<String, Object>> priceMapList = new ArrayList<Map<String,Object>>();
				for(String priceDict : flightVo.getPriceList()){
					String[] prices = priceDict.split("-");
					Map<String,Object> priceMap = new HashMap();
					priceMap.put("start",prices[0]);
					priceMap.put("end",prices[1]);
					priceMapList.add(priceMap);
				}
				flightVo.setPriceMapList(priceMapList);
			}
		PageHelper.startPage(pageNum,pageSize);
		List<FlightVo> flightList = flightMapper.queryList(flightVo);
		PageInfo<FlightVo> info = new PageInfo<>(flightList);
		Page<FlightVo> page = new Page<>(info.getPageNum(),//
				info.getPageSize(),//
				info.getTotal(),//
				info.getPages(),//
				flightList,//
				info.getPrePage(),//
				info.getNextPage());
		return page;
	}
	
	@Override
	@Transactional
	public int deletaById(int id) {
		return flightMapper.deleteById(id);
	}
	@Override
	@Transactional
	public int updateFlight(Flight flight) {
		return flightMapper.updateFlight(flight);
	}
	
	

}
