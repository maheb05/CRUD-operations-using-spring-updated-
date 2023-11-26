package com.demo.airport.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.demo.airport.entity.TaxiEntity;
import com.demo.airport.service.TaxiService;

@Controller
public class TaxiController {
	
	private TaxiService taxiService;
	
	@Autowired
	public TaxiController(TaxiService taxiService) {
		this.taxiService = taxiService;
	}
	
	public TaxiController() {
		System.out.println("Default Controller ");
	}
	
	@RequestMapping(value = "saveTaxiDetails")
	public String saveDetails(@RequestParam String driverName,
			@RequestParam long driverContact,
			@RequestParam String model,
			@RequestParam String taxiColor,Model mode) {
		
		boolean validate = taxiService.validate(driverName, driverContact, model, taxiColor);
		
		if(validate) {
			mode.addAttribute("saveMessage", "Data SuccessFully Saved");
		}
		else {
			mode.addAttribute("saveMessage", "Something went wrong , Data not Saved");
		}
		return "/taxi.jsp";
	}
	
	@RequestMapping(value = "/getTaxiById")
	public String getTaxiById(@RequestParam int taxiID,Model mode) {
		System.out.println("Get Taxi By Id");
		
		boolean validateId = taxiService.validateId(taxiID);
		if(validateId) {
			TaxiEntity entity = taxiService.getTaxiById(taxiID);
			if(entity != null) {
				mode.addAttribute("ID", entity.getTaxiID());
				mode.addAttribute("NAME", entity.getDriverName());
				mode.addAttribute("CONTACT", entity.getDriverContact());
				mode.addAttribute("MODEL", entity.getModel());
				mode.addAttribute("COLOR", entity.getTaxiColor());
			}
			else {
				mode.addAttribute("fetchMessage", "No Record Found with that id"+taxiID);
			}
		}
		else {
			mode.addAttribute("fetchMessage", "Id Should Not be Null");
		}
		return "/taxi.jsp";
	}
	
	@RequestMapping(value = "/getAllTaxiDetails")
	public String getAllTaxiDetails(Model mode) {
		System.out.println("All Taxi Details");
		List<TaxiEntity> details = taxiService.getAllTaxiDetails();
		mode.addAttribute("taxiDetails", details);
		return "/taxi.jsp";
	}
	
	@RequestMapping(value = "editTaxiById/{id}")
	public String editTaxiById(@PathVariable int id,Model mode) {
		System.out.println("Editing Taxi");
		TaxiEntity entity = taxiService.getTaxiById(id);
		mode.addAttribute("Id", entity.getTaxiID());
		mode.addAttribute("Name", entity.getDriverName());
		mode.addAttribute("Contact", entity.getDriverContact());
		mode.addAttribute("Model", entity.getModel());
		mode.addAttribute("Color", entity.getTaxiColor());
		
		return "/WEB-INF/TaxiEdit.jsp";
	}
	
	@RequestMapping(value = "/updateTaxi")
	public String updateTaxiEntity(@RequestParam int taxiID,
			@RequestParam String driverName,
			@RequestParam long driverContact,
			@RequestParam String model,
			@RequestParam String taxiColor,Model mode) {
		
		boolean entityById = taxiService.updateTaxiEntityById(taxiID, driverName, driverContact, model, taxiColor);
		if(entityById) {
			mode.addAttribute("updated", "SuccessFully Updated");
			System.out.println("updated");
		}
		else {
			mode.addAttribute("updated", "Something Went Wrong please try again");
			System.out.println("Not updated");
		}
		return"redirect:/taxi.jsp";
	}
	
	@RequestMapping(value = "deleteTaxiById/{id}")
	public String deleteTaxiEntityById(@PathVariable int id, Model mode) {
		
		boolean validateId = taxiService.validateId(id);
		if(validateId) {
			boolean taxiEntityById = taxiService.deleteTaxiEntityById(id);
			if(taxiEntityById) {
				mode.addAttribute("delete", "SuccessFully Deleted");
			}
			else {
				mode.addAttribute("delete", "Id Not Found");
			}
		}
		else {
			mode.addAttribute("delete", "ID Should not be null and it must greater than 0");
		}
		
		return "redirect:/taxi.jsp";
	}
}
