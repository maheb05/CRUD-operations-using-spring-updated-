package com.demo.airport.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.demo.airport.entity.RunwayEntity;
import com.demo.airport.service.RunwayService;

@Controller
public class RunwayController {

	private RunwayService runwayService;

	@Autowired
	public RunwayController(RunwayService runwayService) {
		this.runwayService = runwayService;
	}

	@RequestMapping(value = "/saveRunwayDetails")
	public String saveDetails(@RequestParam long runwayLength, @RequestParam long runwayWidth,
			@RequestParam String surfaceType, @RequestParam String availability, Model model) {

		System.out.println("Runway Controller Invoked");

		boolean validate = runwayService.validate(runwayLength, runwayWidth, surfaceType, availability);
		if (validate) {
			model.addAttribute("saveMessage", "Data SuccessFully Saved");
		} else {
			model.addAttribute("saveMessage", "Something Went Wrong please try again");
		}
		return "/runway.jsp";
	}

	@RequestMapping(value = "/readById")
	public String getRunwayById(@RequestParam int runwayID, Model model) {
		System.out.println("Getting details by Id");

		boolean validateId = runwayService.validateId(runwayID);
		if (validateId) {
			RunwayEntity entity = runwayService.getRunwayById(runwayID);
			if (entity != null) {
				model.addAttribute("Id", entity.getRunwayID());
				model.addAttribute("Length", entity.getRunwayLength());
				model.addAttribute("Width", entity.getRunwayWidth());
				model.addAttribute("Surface", entity.getSurfaceType());
				model.addAttribute("Availability", entity.getAvailability());
			} else {
				model.addAttribute("readMessage", "No Record Found");
			}
		} else {
			model.addAttribute("readMessage", "Id Should not be null and should be greater than 0");
		}
		return"/runway.jsp";
	}
	
	@RequestMapping(value = "/getAll")
	public String getAllDetails(Model model) {
		System.out.println("Getting All The Details");
		
		List<RunwayEntity> runwayRecords = runwayService.getAllRunwayEntities();
		if(!runwayRecords.isEmpty()) {
			model.addAttribute("Runways", runwayRecords);
		}
		else {
			model.addAttribute("errorMessage", "No Details are Available");
		}
		return "/runway.jsp";
	}
	
	@RequestMapping(value = "editRecord/{id}")
	public String editRunwayRecord(@PathVariable int id,Model model) {
		System.out.println("Path variable to Update");
		
		RunwayEntity entity = runwayService.getRunwayById(id);
		model.addAttribute("ID", entity.getRunwayID());
		model.addAttribute("LENGTH", entity.getRunwayLength());
		model.addAttribute("WIDTH", entity.getRunwayWidth());
		model.addAttribute("SURFACE", entity.getSurfaceType());
		model.addAttribute("AVAILABILITY", entity.getAvailability());
		
		return "/WEB-INF/RunwayEdit.jsp";
	}
	
	@RequestMapping(value = "/updateRunway")
	public String updateRunwayRecord(@RequestParam int runwayID,
			@RequestParam long runwayLength,
			@RequestParam long runwayWidth,
			@RequestParam String surfaceType,
			@RequestParam String availability,Model model) {
		
		boolean runway = runwayService.updateRunway(runwayID, runwayLength, runwayWidth, surfaceType, availability);
		
		if(runway) {
			model.addAttribute("updateMessage", "SuccessFully Updated");
		}
		else {
			model.addAttribute("updateMessage", "Something Went Wrong please try again");
		}
		
		return "redirect:/runway.jsp";
	}
	
	@RequestMapping(value = "/deleteRecord/{id}")
	public String deleteRunwayRecord(@PathVariable int id,Model model) {
		System.out.println("Deleting the Record");
		boolean validateId = runwayService.validateId(id);
		if(validateId) {
			boolean entity = runwayService.deleteRunwayById(id);
			if(entity) {
				model.addAttribute("deleteMessage", "SucessFully Deleted");
			}
			else {
				model.addAttribute("deleteMessage", "ID Not Found");
			}
		}
		else {
			model.addAttribute("deleteMessage", "ID Should not be null and it must greater than 0");
		}
		return "redirect:/runway.jsp";
	}
}
