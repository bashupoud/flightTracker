package com.microservices;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.microservices.FlightTrackerApplication;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = FlightTrackerApplication.class)
@WebAppConfiguration
public class FlightTrackerApplicationTests {

	@Test
	public void contextLoads() {
	}

}
