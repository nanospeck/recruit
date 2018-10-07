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

import com.heavenhr.recruit.exception.ApplicationNotFoundException;
import com.heavenhr.recruit.factory.NotificationFactory;
import com.heavenhr.recruit.model.Application;
import com.heavenhr.recruit.model.Offer;
import com.heavenhr.recruit.repository.ApplicationsRepository;
import com.heavenhr.recruit.service.NotificationService;
import com.heavenhr.recruit.util.URIMappingUtil;

@RestController
@RequestMapping("/recruit-service/v1/*")
public class ApplicationsController {

	@Autowired
	private ApplicationsRepository applicationsRepository;

	@Autowired
	private OffersController offersController;

	@Autowired
	private NotificationFactory notificationFactory;

	@Autowired
	private URIMappingUtil urlMappingUtil;

	@PostMapping("/applications")
	public ResponseEntity<Object> createApplication(@RequestBody Application application) {

		Long id = application.getRelatedOffer();

		Offer relatedOffer = offerIdValidator(id);

		Application savedApplication = applicationsRepository.save(application);

		offerUpdate(relatedOffer);

		URI location = urlMappingUtil.getReturnURL(savedApplication.getId());

		return ResponseEntity.created(location).build();

	}

	@GetMapping("/applications/offer/{id}")
	public List<Application> retrieveApplicationsByOffer(@PathVariable long offerId) {

		List<Application> applications = applicationsRepository.findByRelatedOffer(offerId);

		if (applications == null || applications.isEmpty()) {
			throw new ApplicationNotFoundException("No applications found for offer id: " + offerId);
		}

		return applications;
	}

	@GetMapping("/applications/{id}")
	public Application retrieveApplication(@PathVariable long id) {
		Optional<Application> application = applicationsRepository.findById(id);

		if (!application.isPresent())
			throw new ApplicationNotFoundException("No application with id: " + id);

		return application.get();
	}

	@GetMapping("/applications")
	public List<Application> retrieveAllApplications() {
		return applicationsRepository.findAll();
	}

	@GetMapping("/applications/count")
	public Integer retrieveAllApplicationsCount() {
		return applicationsRepository.findAll().size();
	}

	@PutMapping("/applications/{id}")
	public ResponseEntity<Object> updateApplication(@RequestBody Application application, @PathVariable long id) {

		Optional<Application> applicationOptional = applicationsRepository.findById(id);

		if (!applicationOptional.isPresent())
			return ResponseEntity.notFound().build();

		String appStatusOld = applicationOptional.get().getApplicationStatus() == null ? ""
				: applicationOptional.get().getApplicationStatus().toString();
		String appStatusNew = application.getApplicationStatus() == null ? ""
				: application.getApplicationStatus().toString();

		application.setId(id);

		applicationsRepository.save(application);
		
		if (appStatusNew != appStatusOld) {
			NotificationService notificationService = notificationFactory.getNotificationService(appStatusNew);
			notificationService.printNotification();
		}

		return ResponseEntity.noContent().build();
	}

	private Offer offerIdValidator(Long id) {
		return offersController.retrieveOffer(id);
	}

	private void offerUpdate(Offer offer) {
		Integer applicationCounter = offer.getNumberOfApplications();
		offer.setNumberOfApplications(++applicationCounter);
		offersController.updateOffer(offer, offer.getId());
	}
}
