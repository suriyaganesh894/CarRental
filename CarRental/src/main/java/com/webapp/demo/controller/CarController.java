package com.webapp.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.webapp.demo.car.Car;
import com.webapp.demo.dao.CarDao;

@RestController
public class CarController {
	
	@Autowired
	CarDao dao;
	@RequestMapping("/saveCar")
	@ResponseBody
	public void saveCar(@RequestParam String id,String model, String no,Car obj) {
		
		obj.setCardId(id);
		obj.setCarModel(model);
		obj.setCarNo(no);
		obj.setStatus("available");
		dao.save(obj);
		
	}
	
	@RequestMapping("/editCar")
	@ResponseBody
	public void editCar(@RequestParam String id,String model, String no) {
		
		
		dao.editCarDetails(id,model,no);
		
	}
	
	@RequestMapping("/deleteCar")
	@ResponseBody
	public void deleteCar(@RequestParam String id) {
		
		
		dao.deleteCar(id);
		
	}
	

	@RequestMapping("/getAll")
	@ResponseBody
	public List<Car> getAll() {
		
		return dao.findAll();
		
		
	}
	
	@RequestMapping("/getById")
	@ResponseBody
	public List<Car> getCarById(String id) {
		
		return dao.findById(id);
		
		
	}

}
