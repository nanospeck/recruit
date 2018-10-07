package com.heavenhr.recruit;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import com.heavenhr.recruit.controller.ApplicationsController;
import com.heavenhr.recruit.model.Application;
import com.heavenhr.recruit.repository.ApplicationsRepository;
import com.heavenhr.recruit.util.URIMappingUtil;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ApplicationControllerTest {

	@InjectMocks
	private ApplicationsController applicationController;

	@Mock
	private ApplicationsRepository applicationsRepository;

	@Mock
	private URIMappingUtil uriMappingUtil;

	@Test
	public void contextLoads() {

	}

	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void testApplicationCreate() {
		//to-do
	}

	//to-do
	// all other endpoint test cases
}
