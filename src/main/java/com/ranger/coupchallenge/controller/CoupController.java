package com.ranger.coupchallenge.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ranger.coupchallenge.model.CoupRequest;
import com.ranger.coupchallenge.model.CoupResponse;
import com.ranger.coupchallenge.service.CoupSolverService;

@RestController
public class CoupController {

	@Autowired
	CoupSolverService coupSolverService;
	
	//GET API for getting fleetEngineers
	@GetMapping(value = "/coup")
	@ExceptionHandler(IllegalArgumentException.class)
	CoupResponse getEngineersUsingGet(@RequestParam("scooters") int[] scooters, @RequestParam("C") int managerCapacity,
			@RequestParam("P") int engineerCapacity) {

		return new CoupResponse(coupSolverService.solve(scooters, managerCapacity, engineerCapacity));
	}

	//POST API for getting fleetEngineers
	@PostMapping(value = "/coup")
	@ExceptionHandler(IllegalArgumentException.class)
	CoupResponse getEngineersUsingPost(@RequestBody CoupRequest coupRequest) {
		System.out.println(coupRequest.toString());
		return new CoupResponse(coupSolverService.solve(coupRequest.getScooters(), coupRequest.getManagerCapacity(),
				coupRequest.getEngineerCapacity()));
	}

}
