package com.demo.airport.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.demo.airport.dao.TaxiDAO;
import com.demo.airport.entity.TaxiEntity;

@Component
public class TaxiService {
	
	private TaxiDAO taxiDAO;
	
	@Autowired
	public TaxiService(TaxiDAO taxiDAO){
		this.taxiDAO = taxiDAO;
	}
	public TaxiService() {
	    System.out.println("Taxi Service Default");
	}
	
	public boolean validate(String driverName,long driverContact,String model,String taxiColor) {
		boolean flag = false;
		
		if(driverName != null && !driverName.isEmpty() && !driverName.isBlank()) {
			flag = true;
		}else {
			flag = false;
		}
		
		if(String.valueOf(driverContact).length()==10) {
			flag = true;
		}else {
			flag = false;
		}
		
		if(model != null && !model.isEmpty() && !model.isBlank()) {
			flag = true;
		}else {
			flag = false;
		}
		
		if(taxiColor != null && !taxiColor.isEmpty() && !taxiColor.isBlank()) {
			flag = true;
		}else {
			flag = false;
		}
		
		if(flag) {
			TaxiEntity entity = new TaxiEntity(driverName, driverContact, model, taxiColor);
			boolean result = taxiDAO.saveTaxiDetails(entity);
			return result;
		}
		
		return flag;
	}
	
	public boolean validateId(int id) {
		return id > 0;
	}
	
	public TaxiEntity getTaxiById(int id) {
		return taxiDAO.getTaxiEntityById(id);
	}
	
	public List<TaxiEntity> getAllTaxiDetails() {
		return taxiDAO.getAllTaxiDetails();
	}
	
	public boolean updateTaxiEntityById(int id,String name,long contact,String model,String color) {
		TaxiEntity entity = new TaxiEntity(id, name, contact, model, color);
		return taxiDAO.updateTaxiEntityById(entity);
	}
	
	public boolean deleteTaxiEntityById(int id) {
		return taxiDAO.deleteTaxiEntityById(id);
	}
}
