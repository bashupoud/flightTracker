package com.microservices.services;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.microservices.controllers.Position;

//Representationg the rest calls

@FeignClient(name= "fleetman-position-tracker")
public interface RemotePositionMicroserviceCalls {
	//REST Call, Feign is automatically use the REST template
	// in this case the method will call first and we are sending the rquest, in the normal case this is the opposite way
	
	@RequestMapping(method=RequestMethod.GET,value="/flights/{name}")
	public Position getLatestPositionForVehicle(@PathVariable("name") String name);

}
