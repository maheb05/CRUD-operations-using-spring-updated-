package com.demo.airport.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="runway_table")
public class RunwayEntity {
	
	@Column(name="RUNWAY_ID")
	@Id
	private int runwayID;
	
	@Column(name="RUNWAY_LENGTH")
	private long runwayLength;
	
	@Column(name="RUNWAY_WIDTH")
	private long runwayWidth;
	
	@Column(name="SURFACE_TYPE")
	private String surfaceType;
	
	@Column(name="AVAILABILITY")
	private String availability;
	
	public RunwayEntity(){
		System.out.println("Runway Entity Default ");
	}
	
	public RunwayEntity(long runwayLength, long runwayWidth, String surfaceType, String availability) {
		this.runwayLength = runwayLength;
		this.runwayWidth = runwayWidth;
		this.surfaceType = surfaceType;
		this.availability = availability;
	}
	
	public RunwayEntity(int runwayID, long runwayLength, long runwayWidth, String surfaceType, String availability) {
		this.runwayID = runwayID;
		this.runwayLength = runwayLength;
		this.runwayWidth = runwayWidth;
		this.surfaceType = surfaceType;
		this.availability = availability;
	}

	public int getRunwayID() {
		return runwayID;
	}
	public void setRunwayID(int runwayID) {
		this.runwayID = runwayID;
	}
	public long getRunwayLength() {
		return runwayLength;
	}
	public void setRunwayLength(long runwayLength) {
		this.runwayLength = runwayLength;
	}
	public long getRunwayWidth() {
		return runwayWidth;
	}
	public void setRunwayWidth(long runwayWidth) {
		this.runwayWidth = runwayWidth;
	}
	public String getSurfaceType() {
		return surfaceType;
	}
	public void setSurfaceType(String surfaceType) {
		this.surfaceType = surfaceType;
	}
	public String getAvailability() {
		return availability;
	}
	public void setAvailability(String availability) {
		this.availability = availability;
	}
	
	@Override
	public String toString() {
		return getRunwayID()+" "+getRunwayLength()+" "+getRunwayWidth()+" "+getSurfaceType()+" "+getAvailability();
	}
}
