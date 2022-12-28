  package com.webapp.demo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.webapp.demo.car.Car;

import jakarta.transaction.Transactional;

public interface CarDao extends JpaRepository<Car, Integer>{
	
	@Modifying
	@Transactional
	@Query(value="update car set car_model=?2,car_no=?3,status='booked' where card_id=?1",nativeQuery = true)
	public void editCarDetails(String id,String model,String no);
	
	@Modifying
	@Transactional
	@Query(value="delete from car where card_id=?1",nativeQuery = true)
	public void deleteCar(String id);
	
	@Query(value="select * from car where card_id=?1",nativeQuery = true)
	public List<Car> findById(String id);

}
