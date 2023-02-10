package com.greenart.travle_plan;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.greenart.travle_plan.repository.ZoneConnectionRepository;

import lombok.extern.slf4j.Slf4j;

@SpringBootTest
@Slf4j
class TravlePlanApplicationTests {
@Autowired ZoneConnectionRepository zoneConnectionRepository;
	@Test
	void getZone(){
		System.out.println(zoneConnectionRepository.findAll());
	}
}
