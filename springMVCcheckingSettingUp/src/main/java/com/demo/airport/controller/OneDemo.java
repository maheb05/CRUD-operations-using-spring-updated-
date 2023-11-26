package com.demo.airport.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.demo.airport.entity.AirportEntity;
import com.demo.airport.service.Validatiring;

@Controller
public class OneDemo {
	
	public OneDemo() {
		System.out.println("This is inform to you is created by Spring MVC from IOC Container , it is one Bean ");
	}
	
	private Validatiring validatiring;
	
	@Autowired
	public OneDemo(Validatiring validatiring) {
		this.validatiring = validatiring;
	}
	
	@RequestMapping(value="/gotoForm")
	public String acceptFirstReq(@RequestParam String airportName,@RequestParam String location,@RequestParam int noOfPlanes,@RequestParam int noOfRunways,Model model) {
		System.out.println(airportName);
		System.out.println(location);
		System.out.println(noOfPlanes);
		System.out.println(noOfRunways);
		
		boolean validate = validatiring.validate(airportName, location, noOfPlanes, noOfRunways);
		
		if(validate) {
			model.addAttribute("responseMessage", "Data IS valid & Saved Successfully");
			return "/index.jsp";
		}
		else {
			model.addAttribute("responseMessage", "Data is InValid & try again");
			return "/index.jsp";
		}
		
	}	
	
	@RequestMapping(value = "/gotoSearch")
	public String searchById(@RequestParam int airportId,Model model) {
		
		boolean validateId = validatiring.validateId(airportId);
		
		if(validateId) {
			AirportEntity entityById = validatiring.getAirportEntityById(airportId);
			
			if(entityById != null) {
				model.addAttribute("ID",entityById.getAirportId());
				model.addAttribute("NAME", entityById.getAirportName());
				model.addAttribute("LOCATION", entityById.getAirportLocation());
				model.addAttribute("PLANES", entityById.getNoOfPlanes());
				model.addAttribute("RUNWAYS", entityById.getNoOfRunways());
			}
			else {
				model.addAttribute("responseMessage", "Id does not exist please try with valid ID");
			}
		}
		else {
			model.addAttribute("responseMessage", "Invalid Id , id cannot be Zero , id cannot Negative");
		}
		
		return "/index.jsp";
	}
	
	@RequestMapping(value = "/search")
	public String searchByName(@RequestParam String airportName,Model model) {
		
		boolean validateName = validatiring.validateName(airportName);
		
		if(validateName) {
			List<AirportEntity> entityByName = validatiring.getAirportEntityByName(airportName);
			
			if(! entityByName.isEmpty()) {
				
				for(int i=0;i<entityByName.size();i++) {
					AirportEntity entity = entityByName.get(i);
					model.addAttribute("id", entity.getAirportId());
					model.addAttribute("name", entity.getAirportName());
					model.addAttribute("location", entity.getAirportLocation());
					model.addAttribute("planes", entity.getNoOfPlanes());
					model.addAttribute("runway", entity.getNoOfRunways());
				}
			}
			else {
				model.addAttribute("responseMessage", "No record found with the Name,please try with valid name");
			}
		}
		else {
			model.addAttribute("responseMessage", "Name should not be null ");
		}
		return "/index.jsp"; 
	}
	
	@RequestMapping(value = "/deleteAirport/{id}")
	public String searchIdToDelet(@PathVariable int id,Model model) {
		System.out.println("Deleting By Id invoked ");
		
		boolean validateId = validatiring.validateId(id);
		if(validateId) {
			boolean entityById = validatiring.deleteAirportEntityById(id);
			
			if(entityById) {
				model.addAttribute("deletemessage", "successfully deleted ");
			}
			else {
				model.addAttribute("deletemessage", "no record found with that Id");
			}
		}
		else {
			model.addAttribute("message", "id must be greater than 0");
		}
		
		return "redirect:/index.jsp";
	}
	
	@RequestMapping(value = "/getdetails")
	public String getAllAirports(Model model) {
		
		List<AirportEntity> AirportDetails = validatiring.getAllAirportEntities();
		model.addAttribute("Airports", AirportDetails);
		return "/index.jsp";
	}
	
	@RequestMapping(value = "/editAirport/{id}")
	public String editAirportById(@PathVariable int id,Model model) {
		System.out.println("PAth variable "+id);
		AirportEntity entity = validatiring.getAirportEntityById(id);
		
		model.addAttribute("id", entity.getAirportId());
		model.addAttribute("name", entity.getAirportName());
		model.addAttribute("location", entity.getAirportLocation());
		model.addAttribute("planes", entity.getNoOfPlanes());
		model.addAttribute("runway", entity.getNoOfRunways());
		
		return "/WEB-INF/AirportEdit.jsp";
	}
	
	@RequestMapping(value = "/updateAir")
	public String updateAirport(@RequestParam int airportId,@RequestParam String airportName,@RequestParam String airportLocation,@RequestParam int noOfPlanes,@RequestParam int noOfRunways,Model model) {
		System.out.println("update Airport invoked ");
		boolean result = validatiring.updateAirport(airportId, airportName, airportLocation, noOfPlanes, noOfRunways);
		
		if(result) {
			model.addAttribute("ResultMessage", "Updated Sucessfull");
		}
		else {
			model.addAttribute("ResultMessage", "Updated un Sucessfull");
		}
		
		return "redirect:/index.jsp";
	}
}
