package com.heavenhr.recruit.controller;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.heavenhr.recruit.exception.OfferNotFoundException;
import com.heavenhr.recruit.model.Offer;
import com.heavenhr.recruit.repository.OffersRepository;
import com.heavenhr.recruit.util.URIMappingUtil;
/**
 * Offers Controller class
 * 
 * @author Akhil Anil
 *
 */
@RestController
@RequestMapping("/recruit-service/v1/*")
public class OffersController {

	@Autowired
	private OffersRepository offersRepository;

	@Autowired
	private URIMappingUtil urlMappingUtil;

	@PostMapping("/offers")
	public ResponseEntity<Object> createOffer(@RequestBody Offer offer) {
		Offer savedoffer = offersRepository.save(offer);

		URI location = urlMappingUtil.getReturnURL(savedoffer.getId());

		return ResponseEntity.created(location).build();

	}

	@GetMapping("/offers/{id}")
	public Offer retrieveOffer(@PathVariable long id) {
		Optional<Offer> offer = offersRepository.findById(id);

		if (!offer.isPresent())
			throw new OfferNotFoundException("No offer with id:" + id);

		return offer.get();
	}

	@GetMapping("/offers")
	public List<Offer> retrieveAllOffers() {
		return offersRepository.findAll();
	}

	@PutMapping("/offers/{id}")
	public ResponseEntity<Object> updateOffer(@RequestBody Offer offer, @PathVariable long id) {

		Optional<Offer> offerOptional = offersRepository.findById(id);

		if (!offerOptional.isPresent())
			return ResponseEntity.notFound().build();

		offer.setId(id);

		offersRepository.save(offer);

		return ResponseEntity.noContent().build();
	}
}
