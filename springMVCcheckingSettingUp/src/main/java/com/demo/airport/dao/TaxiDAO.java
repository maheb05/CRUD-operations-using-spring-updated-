package com.demo.airport.dao;

import java.util.List;

import com.demo.airport.entity.TaxiEntity;

public interface TaxiDAO {
	boolean saveTaxiDetails(TaxiEntity entity);
	TaxiEntity getTaxiEntityById(int id);
	List<TaxiEntity> getAllTaxiDetails();
	boolean updateTaxiEntityById(TaxiEntity entity);
	boolean deleteTaxiEntityById(int id);
}
