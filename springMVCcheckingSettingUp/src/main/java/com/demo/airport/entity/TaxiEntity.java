package com.demo.airport.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="taxi_table")
public class TaxiEntity {
	
	@Column(name="TAXI_ID")
	@Id
	private int taxiID;
	
	@Column(name="DRIVER_NAME")
	private String driverName;
	
	@Column(name = "DRIVER_CONTACT")
	private long driverContact;
	
	@Column(name="TAXI_MODEL")
	private String model;
	
	@Column(name="TAXI_COLOR")
	private String taxiColor;
	
	public TaxiEntity(){
		System.out.println("Taxi entity Default");
	}
	public TaxiEntity(String driverName, long driverContact, String model, String taxiColor) {
		super();
		this.driverName = driverName;
		this.driverContact = driverContact;
		this.model = model;
		this.taxiColor = taxiColor;
	}
	
	public TaxiEntity(int taxiID, String driverName, long driverContact, String model, String taxiColor) {
		super();
		this.taxiID = taxiID;
		this.driverName = driverName;
		this.driverContact = driverContact;
		this.model = model;
		this.taxiColor = taxiColor;
	}
	public int getTaxiID() {
		return taxiID;
	}
	public void setTaxiID(int taxiID) {
		this.taxiID = taxiID;
	}
	public String getDriverName() {
		return driverName;
	}
	public void setDriverName(String driverName) {
		this.driverName = driverName;
	}
	public long getDriverContact() {
		return driverContact;
	}
	public void setDriverContact(long driverContact) {
		this.driverContact = driverContact;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public String getTaxiColor() {
		return taxiColor;
	}
	public void setTaxiColor(String taxiColor) {
		this.taxiColor = taxiColor;
	}
	
	@Override
	public String toString() {
		return getTaxiID()+" "+getDriverName()+" "+getDriverContact()+" "+getModel()+" "+getTaxiColor();
	}
}
