package com.microservices.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.microservices.controllers.Position;
import com.microservices.data.FlightRepository;
import com.microservices.domain.Flight;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@Service
public class PositionTrackingExternalService {
	@Autowired
	private FlightRepository repository;
	@Autowired
	private RemotePositionMicroserviceCalls remoteService;

	@HystrixCommand(fallbackMethod="handleExternalServiceDown")
	//If the Situation is dire, this whole method will be skipped, circuit breaker
	public Position getLatestPositionFromRemoteMicroService(String name){
		Position response= remoteService.getLatestPositionForVehicle(name);

		response.setUpToDate(true);
		
		System.out.println("SUCCESS!!!!");
		
		return response;
		
		
		
		
		
	}
	
	public Position handleExternalServiceDown(String name){
		System.out.println("RUNNING FALLBACK");
		
		// Do Something
		//TO DO--> 
		// Read the last known position for this Vehicle from the cache that was saved in database before
		
		Position position= new Position();
		Flight vehicle =repository.findByName(name);
		position.setLat(vehicle.getLat());
		position.setLongitude(vehicle.getLongitude());
		position.setTimestamp(vehicle.getLastRecordedPosition());
		position.setUpToDate(false);
		
		
		return position;
		
	}
	
	

}
