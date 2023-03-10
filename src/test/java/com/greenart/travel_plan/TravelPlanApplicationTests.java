package com.greenart.travel_plan;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.greenart.travel_plan.repository.TravelDetailListRepository;
import com.greenart.travel_plan.repository.ZoneConnectionRepository;

import lombok.extern.slf4j.Slf4j;

@SpringBootTest
@Slf4j
class TravelPlanApplicationTests {
@Autowired ZoneConnectionRepository zoneConnectionRepository;
@Autowired TravelDetailListRepository traDetailListRepository;
	@Test
	void getZone(){
		System.out.println(zoneConnectionRepository.findAll());


	}

	@Test
	void getPlace() {
		System.out.println(traDetailListRepository.findAll());
	}
}
