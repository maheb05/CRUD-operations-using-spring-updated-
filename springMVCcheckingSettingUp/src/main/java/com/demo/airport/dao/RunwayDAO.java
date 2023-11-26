package com.demo.airport.dao;

import java.util.List;

import com.demo.airport.entity.RunwayEntity;

public interface RunwayDAO {
	boolean saveRunwayEntity(RunwayEntity entity);
	RunwayEntity  getRunwayById(int id);
	List<RunwayEntity> getAllRunwayDetails();
	boolean updateRunwayEntityByID(RunwayEntity entity);
	boolean deleteRunwayById(int id);
}
