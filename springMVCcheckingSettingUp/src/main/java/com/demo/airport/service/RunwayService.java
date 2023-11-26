package com.demo.airport.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.demo.airport.dao.AirportDAO;
import com.demo.airport.dao.RunwayDAO;
import com.demo.airport.entity.RunwayEntity;

@Component
public class RunwayService {
	
	private RunwayDAO runwayDAO;
	
	@Autowired
	public RunwayService(RunwayDAO runwayDAO) {
		this.runwayDAO = runwayDAO;
	}
	
	public boolean validate(long runwayLength,long runwayWidth,String surfaceType,String availability) {
		boolean flag = false;
		
		if(runwayLength > 0) {
			flag = true;
		}else {
			flag = false;
		}
		
		if(runwayWidth > 0) {
			flag = true;
		}else {
			flag = false;
		}
		
		if(surfaceType != null && !surfaceType.isEmpty() && !surfaceType.isBlank()) {
			flag = true;
		}else {
			flag = false;
		}
		
		if(availability != null && !availability.isEmpty() && !availability.isBlank()) {
			flag = true;
		}else {
			flag = false;
		}
		
		if(flag) {
			RunwayEntity entity = new RunwayEntity(runwayLength, runwayWidth, surfaceType, availability);
			boolean result = runwayDAO.saveRunwayEntity(entity);
			return result;
		}
		return flag;
	}
	
	public boolean validateId(int runwayID) {
		return runwayID > 0 ? true : false;
	}
	
	public RunwayEntity getRunwayById(int runwayID) {
		return runwayDAO.getRunwayById(runwayID);
	}
	
	public List<RunwayEntity> getAllRunwayEntities(){
		return runwayDAO.getAllRunwayDetails();
	}
	
	public boolean updateRunway(int id,long length,long width,String surface,String availability) {
		System.out.println("Runway Update by service");
		RunwayEntity entity = new RunwayEntity(id, length, width, surface, availability);
		return runwayDAO.updateRunwayEntityByID(entity);
	}
	
	public boolean deleteRunwayById(int id) {
		return runwayDAO.deleteRunwayById(id);
	}
}
