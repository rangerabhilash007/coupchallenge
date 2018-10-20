package com.ranger.coupchallenge.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ranger.coupchallenge.model.CoupResponse;
import com.ranger.coupchallenge.service.CoupSolverService;

@RestController
public class CoupController {

	@Autowired
	CoupSolverService coupSolverService;

	@GetMapping(value = "/coup")
	@ExceptionHandler(IllegalArgumentException.class)
	CoupResponse getEngineers(@RequestParam("scooters") int[] scooters, @RequestParam("C") int managerCapacity,
			@RequestParam("P") int engineerCapacity) {

		return new CoupResponse(coupSolverService.solve(scooters, managerCapacity, engineerCapacity));
	}
}
