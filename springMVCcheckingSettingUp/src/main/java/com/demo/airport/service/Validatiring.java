package com.demo.airport.service;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.demo.airport.dao.AirportDAO;
import com.demo.airport.entity.AirportEntity;

@Component("validating")
public class Validatiring {
	
	private AirportDAO airportDao;
	
	@Autowired
	public Validatiring(AirportDAO airportDAO) {
		this.airportDao = airportDAO;
	}
	
	public Validatiring() {
		System.out.println("This IS Service Method ");
	}

	public boolean validate(String airportName, String location, int noOfPlanes, int noOfRunways) {

		boolean flag = false;

		if (Objects.nonNull(airportName) && !airportName.isEmpty() && !airportName.isBlank()) {
			flag = true;
		} else {
			flag = false;
		}

		if (Objects.nonNull(location) && !location.isEmpty() && !location.isBlank()) {
			flag = true;
		} else {
			flag = false;
		}

		if (noOfPlanes > 0) {
			flag = true;
		} else {
			flag = false;
		}

		if (noOfRunways > 0) {
			flag = true;
		} else {
			flag = false;
		}

		
		if(flag) {
			AirportEntity entity = new AirportEntity(airportName, location, noOfPlanes, noOfRunways);
			boolean result = airportDao.saveAirportEntity(entity);
			return result;
		} 
		
		return flag;

	}
	
	public boolean validateId(int id) {
		return id > 0 ? true : false;
	}
	
	public boolean deleteAirportEntityById(int id) {
		return airportDao.deleteAirportEntityById(id);
	}
	
	public AirportEntity getAirportEntityById(int id) {
		return airportDao.getAirportEntityById(id);
	}
	
	public boolean validateName(String name) {
		return !name.isEmpty() && !name.isBlank() ? true : false;
	}
	
	public List getAirportEntityByName(String name) {
		return airportDao.getAirportEntityByName(name);
	}
	
	public List<AirportEntity> getAllAirportEntities(){
		return airportDao.getAllAirportEntities();
	}
	
	public boolean updateAirport(int id,String name,String location,int planes,int runways) {
		System.out.println("This is service update");
		AirportEntity entity = new AirportEntity(id,name,location,planes,runways);
		return airportDao.updateAirportEntityById(entity);
	}
}
