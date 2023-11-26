package com.demo.airport.dao;

import java.util.List;

import com.demo.airport.entity.AirportEntity;


public interface AirportDAO {
	
	boolean saveAirportEntity(AirportEntity entity);
	AirportEntity getAirportEntityById(int id);
	List getAirportEntityByName(String name);
	boolean deleteAirportEntityById(int id);
	List<AirportEntity> getAllAirportEntities();
	boolean updateAirportEntityById(AirportEntity entity); 
}
