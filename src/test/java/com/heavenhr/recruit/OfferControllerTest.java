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

import com.heavenhr.recruit.controller.OffersController;
import com.heavenhr.recruit.enumeration.ApplicationStatus;
import com.heavenhr.recruit.model.Offer;
import com.heavenhr.recruit.repository.OffersRepository;
import com.heavenhr.recruit.util.URIMappingUtil;

@RunWith(SpringRunner.class)
@SpringBootTest
public class OfferControllerTest {

	@InjectMocks
	private OffersController offerController;

	@Mock
	private OffersRepository offerRepository;

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
	public void testOfferCreate() {
		System.out.println(ApplicationStatus.APPLIED.toString());
		Offer offer = new Offer();
		offer.setJobTitle("HR");
		when(offerRepository.save(any(Offer.class))).thenReturn(offer);
		ResponseEntity<Object> createoffer = offerController.createOffer(offer);
		assertEquals(createoffer.getStatusCode().value(), HttpStatus.CREATED.value());
	}

}
