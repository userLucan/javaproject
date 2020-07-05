package com.etoak.controller;

import java.io.File;
import java.util.UUID;

import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.etoak.bean.Flight;
import com.etoak.bean.FlightVo;
import com.etoak.bean.Page;
import com.etoak.service.FlightService;

@Controller
@RequestMapping("/flight")
public class FlightController {
	
	@Autowired
	FlightService flightService;

	@RequestMapping("/to_add")
	public String toAddPage(){
		
		return "flight/add";
	}
	
	@RequestMapping("/flightNo")
	@ResponseBody
	public String checkFlightNo(String flightNo){
		Flight flight = flightService.queryByFlightNo(flightNo);
		return flight == null ? "true" : "false";
	}
	@RequestMapping("/add")
	public String add(@RequestParam("file") MultipartFile pic,Flight flight) throws Exception{
		//上传文件名称
		String originalFilename = pic.getOriginalFilename();
		// 获取文件后缀
		String suffix = FilenameUtils.getExtension(originalFilename);
		//UUID生成新文件名字
		String filenamePrefix = UUID.randomUUID().toString().replaceAll("-","");
		//最终的文件名称
		String destFileName = filenamePrefix+"."+suffix; 
		//创建目标文件
		File destFile = new File("D:/upload",destFileName);
		//上传文件
		pic.transferTo(destFile);
		
		flight.setSavePath("/pics/"+destFileName);
		int i = flightService.addFlight(flight);
		return "redirect:/flight/to_list";
	}
	@RequestMapping("/to_list")
	public String toListPage(){
		
		return "flight/list";
	}
	
	@RequestMapping("/list")
	@ResponseBody
	public Page<FlightVo> queryList(@RequestParam(required=false,defaultValue="1") int pageNum,
			@RequestParam(required=false,defaultValue="5")int pageSize,FlightVo flightVo){
		return flightService.queryList(pageNum, pageSize, flightVo);
	}
	@DeleteMapping("/{id}")
	public String deleteById(@PathVariable("id") int id){
		int i = flightService.deletaById(id);
		return "redirect:/flight/to_list";
	}
	@RequestMapping("/update")
	public String updateFlight(Flight flight){
		flightService.updateFlight(flight);
		
		return "redirect:/flight/to_list";
	}
	
	
	
}
