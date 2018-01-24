package com.microservices.rest;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.microservices.domain.Flight;

@XmlRootElement(name="flights")
public class FlightList
{
	private List<Flight> flights;
	
	public FlightList() {}
	
	public FlightList(List<Flight> flights)
	{
		this.flights = flights;
	}

	@XmlElement(name="flight")
	public List<Flight> getVehicles() {
		return flights;
	}

	public void setVehicles(List<Flight> flights) {
		this.flights = flights;
	}
	
	
}
