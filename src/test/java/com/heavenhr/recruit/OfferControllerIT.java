package com.heavenhr.recruit;

import static org.assertj.core.api.Assertions.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import com.heavenhr.recruit.model.Offer;

@RunWith(SpringRunner.class)
@SpringBootTest
public class OfferControllerIT {

	@Test
	public void contextLoads() {
		
		
	}

	@Test
	public void test() {
		Offer offer = new Offer();
		offer.setId(new Long(9));
		offer.setJobTitle("SSE2");
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<Offer> response = restTemplate.postForEntity("http://localhost:8080/recruit-service/v1/offers",
				offer, Offer.class);

		assertThat(response.getStatusCode()).isEqualTo(HttpStatus.CREATED);
		// assertThat(response.getBody()).contains("Offers");
	}
}
