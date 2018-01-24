package com.microservices.data;

import org.springframework.data.jpa.repository.JpaRepository;

import com.microservices.domain.Flight;

public interface FlightRepository extends JpaRepository<Flight, Long>
{
	public Flight findByName(String name);
} 
