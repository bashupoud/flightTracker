package com.microservices.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.microservices.data.FlightRepository;
import com.microservices.domain.Flight;

@RestController
@RequestMapping("/")
public class FlightRestController 
{
	@Autowired
	private FlightRepository data;
	
	@RequestMapping("/flights")
	public FlightList allVehicles()
	{
		List<Flight> all = data.findAll();
		return new FlightList(all);
	}
	
	
	@RequestMapping(value="/flights", method=RequestMethod.POST)
	public ResponseEntity<Flight> createANewFlight(@RequestBody Flight flight)
	{
		data.save(flight);
		return new ResponseEntity<Flight>(flight,HttpStatus.CREATED);
	}
}
